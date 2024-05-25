package com.mphasis.task.pages.common;

import org.openqa.selenium.By;


public class BankLocatorSelectors {
    public static final By SEARCH_RESULTS_LIST = By.id("searchResultsList");
    public static final By RESULT_ITEM = By.className("aResult");
    public static final By LOCATION_NAME = By.cssSelector(".adr .fn.heading");
    public static final By ADDRESS_ELEMENT = By.className("adr");
    public static final By STREET_ADDRESS = By.className("street-address");
    public static final By CITY = By.className("locality");
    public static final By STATE = By.className("region");
    public static final By POSTAL_CODE = By.className("postal-code");
    public static final By PHONE = By.cssSelector(".tel[itemprop='telephone']");
    public static final By LOCATION_DATA = By.cssSelector("[data-location]");

    private BankLocatorSelectors() {
        throw new AssertionError("Utility class should not be instantiated");
    }
}
