package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class VehicleInfoPage extends BasePage {
    public VehicleInfoPage(WebDriver driver) {
        super(driver);
    }

    private final By selectors = By.xpath("//div[@role='button']");
    private final By elementsOfSelector = By.xpath("//li");
    private final By vinNumberField = By.name("vinEightDigits");

    private final By continueButton = By.xpath("//button[text()='Send information']");


    public void enterVehicleDetails(Driver driverModel) throws InterruptedException {
        chooseElementFromDropdown("make", driverModel);
        chooseElementFromDropdown("year", driverModel);
        chooseElementFromDropdown("model", driverModel);
        type(vinNumberField, driverModel.getVehicle().getVinNumber());
    }

    private void chooseElementFromDropdown(String param, Driver driverModel) throws InterruptedException {
        int index = 0;
        String filteringParam = "";
        switch (param){
            case "make":{
                index = 0;
                filteringParam = driverModel.getVehicle().getManufacturer().toUpperCase();
                break;
            }
            case "year":{
                index = 1;
                filteringParam = driverModel.getVehicle().getYear().toUpperCase();
                break;
            }
            case "model":{
                index = 2;
                filteringParam = driverModel.getVehicle().getModel();
                break;
            }
            default:
                throw new RuntimeException();
        }

        int i = 0;
        List<WebElement> dropdowns = findAll(selectors);
        while (i++ < 5) {
            try {
                dropdowns.get(index).click();
                List<WebElement> manufacturers = findAll(elementsOfSelector);
                String finalFilteringParam = filteringParam;
                WebElement elementInDropdown = manufacturers.stream()
                        .filter(e -> e.getText().equals(finalFilteringParam))
                        .findFirst().get();
                elementInDropdown.click();
                break;
            } catch (NoSuchElementException | WebDriverException e) {
                Thread.sleep(1000);
                continue;
            }

        }

    }

    public SuccessPage clickContinue(){
        press(continueButton);
        return new SuccessPage(driver);
    }


}
