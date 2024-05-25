package com.mphasis.task.pages;

import com.workfusion.automation.rpa.driver.DriverWrapper;
import com.workfusion.automation.rpa.pages.AbstractPage;

public class BasePage extends AbstractPage {
    public BasePage(DriverWrapper driver) {
        super(driver);
        driver.waitForWebPageIsLoaded(10); // Użycie istniejącego API do czekania na załadowanie strony
    }

    public DriverWrapper getWrapper() {
        return this.driver;
    }
}
