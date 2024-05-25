package com.mphasis.task.pages;

import com.mphasis.task.pages.dto.WellsFargoLocationDto;
import com.workfusion.automation.rpa.driver.DriverWrapper;
import com.workfusion.automation.rpa.elements.web.common.Button;
import com.workfusion.automation.rpa.elements.web.common.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.mphasis.task.pages.common.BankLocatorSelectors.*;

public class LocatorPage extends BasePage {

    private TextBox searchBox = new TextBox(driver, By.id("mainSearchField"), "Search Box");

    private Button searchButton = new Button(driver, By.id("mainSearchButton"), "Search Button");

    public LocatorPage(DriverWrapper driver) {
        super(driver);
    }

    public List<WellsFargoLocationDto> searchLocations(String location, Integer maxResultCount) {
        searchBox.setText(location);
        searchButton.click();
        driver.waitForWebPageIsLoaded(10);

        WebElement searchResultsList = driver.findElement(SEARCH_RESULTS_LIST);
        List<WebElement> resultItems = searchResultsList.findElements(RESULT_ITEM);

        return mapToDto(resultItems);
    }

    private List<WellsFargoLocationDto> mapToDto(List<WebElement> searchResults) {
        List<WellsFargoLocationDto> locations = new ArrayList<>();
        for (WebElement result : searchResults) {
            // Pobranie nazwy lokalizacji
            WebElement addressElement = result.findElement(ADDRESS_ELEMENT);
            String locationName = addressElement.findElement(By.cssSelector(".fn.heading")).getText();

            // Pobranie adresu
            String streetAddress = addressElement.findElement(STREET_ADDRESS).getText();
            String city = addressElement.findElement(CITY).getText();
            String state = addressElement.findElement(STATE).getText();
            String postalCode = addressElement.findElement(POSTAL_CODE).getText();
            String address = streetAddress + "\n" + city + ", " + state + ", " + postalCode;

            // Pobranie numeru telefonu
            String phone = result.findElement(PHONE).getText().replace("Phone: ", "");

            // Pobranie współrzędnych lokalizacji
            String locationData = result.getAttribute("data-location");
            String[] coordinates = locationData.split(",");
            String locationLatitude = coordinates[0];
            String locationLongitude = coordinates[1];

            locations.add(WellsFargoLocationDto.builder()
                    .locationName(locationName)
                    .city(city)
                    .state(state)
                    .address(address)
                    .phone(phone)
                    .locationLatitude(locationLatitude)
                    .locationLongitude(locationLongitude)
                    .build());
        }
        return locations;
    }
}
