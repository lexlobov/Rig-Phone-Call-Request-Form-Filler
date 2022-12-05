package com.issart.rig;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.infoform.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInfoFiller {

    WebDriver driver = new FirefoxDriver();
    private String link;

    public DriverInfoFiller(String link) {
        this.link = link;
    }

    public String fillTheForm(Driver driverModel){
        if("false".equals(link)){
            System.out.println("Wasn't able to get link from sms message :<");
            return "{"+
                    "\"success\": false"+
                    "}";
        }
        try {
            driver.get(link);
            var startPage = new StartPage(driver);
            var coordinatesPage = startPage.goToCoordinatesPage();
            coordinatesPage.fillCoordinates(driverModel);
            var driverInfoPage = coordinatesPage.clickContinue();
            driverInfoPage.fillNames(driverModel);
            var vehicleNumberPage = driverInfoPage.clickContinue();
            vehicleNumberPage.fillNumbers(driverModel);
            var vehicleInfoPage = vehicleNumberPage.clickContinue();
            vehicleInfoPage.enterVehicleDetails(driverModel);
            var successPage = vehicleInfoPage.clickContinue();

            return String.format("{"+
                    "\"success\": %s"+
                    "}",
                    successPage.isSuccess());
        } catch (NoSuchElementException e){
            return "{"+
                    "\"success\": false"+
                    "}";
        }
    }

    // TODO Дописать методы
}
