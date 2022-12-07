package com.issart.rig;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.infoform.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DriverInfoFiller {


    WebDriver driver;
    private void setUp(){
        FirefoxOptions ffopt = new FirefoxOptions()
                .addPreference("dom.webnotifications.enabled", true)
                .addPreference("geo.enabled", true)
                .addPreference("geo.provider.use_corelocation", true)
                .addPreference("geo.prompt.testing", true)
                .addPreference("geo.prompt.testing.allow", true)
                .setHeadless(true);

        driver = new FirefoxDriver(ffopt);
    }
    private String link;

    public DriverInfoFiller(String link) {
        this.link = link;
    }

    public String fillTheForm(Driver driverModel) throws InterruptedException {
        if("false".equals(link)){
            System.out.println("Wasn't able to get link from sms message :<");
            return "{"+
                    "\"success\": false"+
                    "}";
        }
        setUp();
        try {
            driver.get(link);
            var startPage = new StartPage(driver);
            var coordinatesPage = startPage.goToCoordinatesPage();
            coordinatesPage.fillCoordinates(driverModel);
            var driverInfoPage = coordinatesPage.fillCoordinates(driverModel);
            driverInfoPage.fillNames(driverModel);
            var vehicleNumberPage = driverInfoPage.clickContinue();
            vehicleNumberPage.fillNumbers(driverModel);
            var vehicleInfoPage = vehicleNumberPage.clickContinue();
            vehicleInfoPage.enterVehicleDetails(driverModel);
            var successPage = vehicleInfoPage.clickContinue();
            boolean success = successPage.isSuccess();


        driver.quit();
        return String.format("{"+
                    "\"success\": %s"+
                    "}",
                    success);
        } catch (Exception e){
            driver.quit();
            return "{"+
                    "\"success\": false"+
                    "}";
        }
    }


}
