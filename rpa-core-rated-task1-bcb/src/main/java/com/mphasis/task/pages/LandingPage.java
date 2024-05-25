package com.mphasis.task.pages;

import com.workfusion.automation.rpa.driver.DriverWrapper;
import com.workfusion.automation.rpa.elements.web.common.Button;
import org.openqa.selenium.By;

public class LandingPage extends BasePage {

    final String ATM_LOCATIONS_XPATH = "//a[contains(text(), 'ATMs/Locations')]";
    
    Button atmLocationsButton = new Button(driver, By.xpath(ATM_LOCATIONS_XPATH), "ATM Locations Button");

    public LandingPage(DriverWrapper driver) {
        super(driver);
    }

    public LocatorPage navigateToLocator() {
        atmLocationsButton.click();
        driver.waitForWebPageIsLoaded(10);
        return new LocatorPage(driver);
    }
}


