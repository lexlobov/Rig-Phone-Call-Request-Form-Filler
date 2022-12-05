package com.issart.rig.pageobject;

import com.issart.rig.model.Driver;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage{
    public StartPage(WebDriver driver) {
        super(driver);
    }

    // TODO Написать локаторы и сделать методы

    public DriverInfoPage goToDriverInfoPage(Driver driverModel){

        return new DriverInfoPage(driver);
    }

}
