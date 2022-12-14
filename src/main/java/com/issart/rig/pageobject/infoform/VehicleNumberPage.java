package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VehicleNumberPage extends BasePage {
    public VehicleNumberPage(WebDriver driver) {
        super(driver);
    }

    private final By mcField = By.name("mc");
    private final By dotField = By.name("dot");
    private final By continueButton = By.xpath("//button");

    public void fillNumbers(Driver driverModel){
        type(mcField, driverModel.getVehicle().getMcNumber());
        type(dotField, driverModel.getVehicle().getDotNumber());
    }

    public VehicleInfoPage clickContinue(){
        press(continueButton);
        return new VehicleInfoPage(driver);
    }

}
