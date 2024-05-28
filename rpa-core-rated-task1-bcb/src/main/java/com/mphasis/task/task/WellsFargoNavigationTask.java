package com.mphasis.task.task;

import com.mphasis.task.pages.LandingPage;
import com.mphasis.task.pages.LocatorPage;
import com.mphasis.task.pages.ResultsPage;
import com.mphasis.task.pages.client.WellsFargoClient;
import com.mphasis.task.pages.dto.WellsFargoLocationDto;
import com.workfusion.odf2.compiler.BotTask;
import com.workfusion.odf2.core.cdi.Injector;
import com.workfusion.odf2.core.cdi.Requires;
import com.workfusion.odf2.core.task.generic.GenericTask;
import com.workfusion.odf2.core.task.output.SingleResult;
import com.workfusion.odf2.core.task.output.TaskRunnerOutput;
import com.workfusion.odf2.core.webharvest.rpa.RpaDriver;
import com.workfusion.odf2.core.webharvest.rpa.RpaFactory;
import com.workfusion.odf2.core.webharvest.rpa.RpaRunner;
import com.workfusion.odf2.service.ControlTowerServicesModule;
import com.workfusion.odf2.service.s3.S3Bucket;
import com.workfusion.odf2.service.s3.S3Module;
import com.workfusion.odf2.service.s3.S3Service;
import org.slf4j.Logger;

import javax.inject.Inject;
import java.nio.charset.StandardCharsets;
import java.util.List;

@BotTask(requireRpa = true)
@Requires({ControlTowerServicesModule.class, S3Module.class})
public class WellsFargoNavigationTask implements GenericTask {

    private final RpaRunner rpaRunner;

    private final Logger logger;

    private final S3Service s3Service;

    static String HARDCODED_SEARCH_LOCATION = "Cherry Hill";

    static int REQUIRED_RESULTS_COUNT = 10;

    @Inject
    public WellsFargoNavigationTask(Injector injector) {
        RpaFactory rpaFactory = injector.instance(RpaFactory.class);
        this.rpaRunner = rpaFactory.builder(RpaDriver.UNIVERSAL).maximizeOnStartup(true).closeOnCompletion(true).build();
        this.logger = injector.instance(Logger.class);
        this.s3Service = injector.instance(S3Service.class);
    }

    @Override
    public TaskRunnerOutput run() {
        final String[] S3Url = new String[1];
        this.rpaRunner.execute(driver -> {
            WellsFargoClient wellsFargoClient = new WellsFargoClient(this.logger);
            LandingPage landingPage = wellsFargoClient.getLandingPage();
            LocatorPage locatorPage = landingPage.navigateToLocator();
            ResultsPage resultsPage = locatorPage.searchLocations(HARDCODED_SEARCH_LOCATION, REQUIRED_RESULTS_COUNT);
            List<WellsFargoLocationDto> searchResults = resultsPage.processSearchResult(REQUIRED_RESULTS_COUNT);
            // preparing CSV
            String csvContent = prepareCSV(searchResults);
            // saving or uploading CSV content to S3 Bucket
            final S3Bucket s3Bucket = s3Service.getBucket("525424");
            byte[] csvBytes = csvContent.getBytes(StandardCharsets.UTF_8);
            S3Url[0] = s3Bucket.put(csvBytes, "wells_fargo_locations.csv").getDirectUrl();
        });
        return new SingleResult().withColumn("locations_csv_url", S3Url[0]);
    }

    private String prepareCSV(List<WellsFargoLocationDto> locations) {
        StringBuilder sb = new StringBuilder();
        sb.append("Location Name, City, State, Address, Phone, Latitude, Longitude\n");
        for (WellsFargoLocationDto location : locations) {
            sb.append(location.getLocationName()).append(", ")
                    .append(location.getCity()).append(", ")
                    .append(location.getState()).append(", ")
                    .append(location.getAddress()).append(", ")
                    .append(location.getPhone()).append(", ")
                    .append(location.getLocationLatitude()).append(", ")
                    .append(location.getLocationLongitude()).append("\n");
        }
        return sb.toString();
    }
}

