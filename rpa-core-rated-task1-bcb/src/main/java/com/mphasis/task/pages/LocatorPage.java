package com.mphasis.task.pages;

import com.workfusion.automation.rpa.driver.DriverWrapper;
import com.workfusion.automation.rpa.elements.web.common.Button;
import com.workfusion.automation.rpa.elements.web.common.TextBox;
import org.openqa.selenium.By;

public class LocatorPage extends BasePage {

    private final TextBox searchBox = new TextBox(driver, By.id("mainSearchField"), "Search Box");

    private final Button searchButton = new Button(driver, By.id("mainSearchButton"), "Search Button");

    public LocatorPage(DriverWrapper driver) {
        super(driver);
    }

    //TODO try submit()
    public ResultsPage searchLocations(String location, Integer maxResultCount){
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        SmartWait wait = new SmartWait(driver);
        searchBox.setText(location);

        searchButton.click();
        driver.waitForWebPageIsLoaded(10);
        return new ResultsPage(driver);
    }
}
