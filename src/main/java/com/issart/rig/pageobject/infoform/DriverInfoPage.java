package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverInfoPage extends BasePage {
    public DriverInfoPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameField = By.name("firstName");
    private final By lastNameField = By.name("lastName");
    private final By continueButton = By.xpath("//button");

    // TODO Написать локаторы и сделать методы

    public void fillNames(Driver driverModel){
        type(firstNameField, driverModel.getFirstName());
        type(lastNameField, driverModel.getLastName());
    }

    public VehicleNumberPage clickContinue(){
        press(continueButton);
        return new VehicleNumberPage(driver);
    }
}
