package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.*;

public class CoordinatesPage extends BasePage {
    public CoordinatesPage(WebDriver driver) {
        super(driver);
    }

    private final By servicePointField = By.xpath("//input");
    private final By locationsListItem = By.xpath("//li");
    private final By continueButton = By.xpath("//button");

    private void clickItemInList() throws InterruptedException {
        int n = 0;
        while (n++<5){
            try {
                findAll(locationsListItem).get(0).click();
                break;
            } catch (WebDriverException | IndexOutOfBoundsException ex){
                Thread.sleep(1000);
            }
        }
    }

    public DriverInfoPage fillCoordinates(Driver driverModel) throws InterruptedException {
        int n = 0;
        while (n++ < 5) {
            try {
                type(servicePointField, driverModel.getAddress());
                break;
            } catch (WebDriverException e){
                Thread.sleep(1000);
            }
        }
        Thread.sleep(2000);
        clickItemInList();
        clickContinue();
        return new DriverInfoPage(driver);
    }

    public void clickContinue() throws InterruptedException {
        int n = 0;
        while (n++<10){
            try {
                findAll(continueButton).get(4).click();
                break;
            } catch (WebDriverException e){
                Thread.sleep(500);
            }
        }
    }
}
