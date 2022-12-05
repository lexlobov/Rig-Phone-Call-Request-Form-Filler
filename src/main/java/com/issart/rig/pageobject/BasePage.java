package com.issart.rig.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void press(By locator){
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    protected boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
