package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehicleInfoPage extends BasePage {
    public VehicleInfoPage(WebDriver driver) {
        super(driver);
    }

    private final By manufacturerSelector = By.xpath("");
    private final By yearSelector = By.xpath("");
    private final By modelSelector = By.xpath("");
    private final By vinNumberField = By.xpath("");

    private final By continueButton = By.xpath("");


    public void enterVehicleDetails(Driver driverModel){

    }

    public SuccessPage clickContinue(){
        press(continueButton);
        return new SuccessPage(driver);
    }

    // TODO Написать локаторы и сделать методы
}
