package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoordinatesPage extends BasePage {
    public CoordinatesPage(WebDriver driver) {
        super(driver);
    }

    private final By servicePointField = By.xpath("");
    private final By continueButton = By.xpath("");
    // TODO Написать локаторы и сделать методы

    public void fillCoordinates(Driver driverModel){
        String coordinates = driverModel.getLatitude() + "," + driverModel.getLongitude();
        type(servicePointField, coordinates);
    }

    public DriverInfoPage clickContinue(){
        press(continueButton);
        return new DriverInfoPage(driver);
    }
}
