package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VehicleInfoPage extends BasePage {
    public VehicleInfoPage(WebDriver driver) {
        super(driver);
    }

    private final By selectors = By.xpath("//div[@role='button']");
    private final By elementsOfSelector = By.xpath("//li");
    private final By vinNumberField = By.id("mui-22");

    private final By continueButton = By.xpath("//button[@class='MuiButton-root MuiButton-contained MuiButton-containedSuccess MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButtonBase-root Mui-disabled VehicleFormBase_continueButton__AcWAe css-rswodx']");


    public void enterVehicleDetails(Driver driverModel) throws InterruptedException {
        chooseElementFromDropdown("make", driverModel);
        driver.wait(1500);
        chooseElementFromDropdown("year", driverModel);
        driver.wait(1500);
        chooseElementFromDropdown("model", driverModel);
        type(vinNumberField, driverModel.getVehicle().getVinNumber());
    }

    private void chooseElementFromDropdown(String param, Driver driverModel){
        int index = 0;
        String filteringParam = "";
        switch (param){
            case "make":{
                index = 0;
                filteringParam = driverModel.getVehicle().getManufacturer();
                break;
            }
            case "year":{
                index = 1;
                filteringParam = driverModel.getVehicle().getYear();
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

        List<WebElement> dropdowns = findAll(selectors);
        dropdowns.get(index).click();
        List<WebElement> manufacturers = findAll(elementsOfSelector);
        String finalFilteringParam = filteringParam;
        WebElement elementInDropdown = manufacturers.stream()
                .filter(e-> e.getText().equals(finalFilteringParam))
                .findFirst()
                .get();
        elementInDropdown.click();
    }

    public SuccessPage clickContinue(){
        press(continueButton);
        return new SuccessPage(driver);
    }

    // TODO Написать локаторы и сделать методы
}
