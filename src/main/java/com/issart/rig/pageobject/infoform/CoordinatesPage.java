package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.*;

public class CoordinatesPage extends BasePage {
    public CoordinatesPage(WebDriver driver) {
        super(driver);
    }

    private final By servicePointField = By.xpath("//input");

    public DriverInfoPage fillCoordinates(Driver driverModel) throws InterruptedException {
        int n = 0;
        while (n++ < 5) {
            try {
                String coordinates = "Lat: " + driverModel.getLatitude() + " Lon: " + driverModel.getLongitude();
                type(servicePointField, coordinates);
                driver.findElement(servicePointField).sendKeys(Keys.ENTER);
                break;
            } catch (WebDriverException e){
                Thread.sleep(1000);
            }
        }
        return new DriverInfoPage(driver);
    }

}
