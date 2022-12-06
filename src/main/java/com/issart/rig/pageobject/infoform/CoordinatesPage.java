package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoordinatesPage extends BasePage {
    public CoordinatesPage(WebDriver driver) {
        super(driver);
    }

    private final By servicePointField = By.xpath("//input");
    private final By continueButton = By.xpath("//button");


    public void fillCoordinates(Driver driverModel){
        String coordinates = "Lat: " + driverModel.getLatitude() + " Lon: " + driverModel.getLongitude();
        type(servicePointField, coordinates);
    }

    public DriverInfoPage clickContinue(){
        press(continueButton);
        return new DriverInfoPage(driver);
    }
}
