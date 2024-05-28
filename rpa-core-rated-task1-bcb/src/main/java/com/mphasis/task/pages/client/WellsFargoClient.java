package com.mphasis.task.pages.client;

import com.mphasis.task.pages.LandingPage;
import com.workfusion.automation.rpa.driver.DriverType;
import com.workfusion.automation.rpa.driver.DriverWrapper;
import com.workfusion.automation.rpa.driver.RobotDriverWrapper;
import com.workfusion.rpa.helpers.RPA;
import org.slf4j.Logger;


public class  WellsFargoClient {

    private static final String WELLS_FARGO_URL = "https://www.wellsfargo.com/";

    DriverWrapper driverWrapper;

    public WellsFargoClient(Logger logger) {
        this.driverWrapper = new RobotDriverWrapper(logger);
        driverWrapper.getDriverSettings().setPageLoadWaitSeconds(10);
    }

    public LandingPage getLandingPage() {
        this.driverWrapper.switchDriver(DriverType.CHROME);
        RPA.openChrome(WELLS_FARGO_URL);
        return new LandingPage(driverWrapper);
    }
}