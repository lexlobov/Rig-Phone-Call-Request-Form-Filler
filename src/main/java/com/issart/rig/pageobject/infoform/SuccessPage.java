package com.issart.rig.pageobject.infoform;

import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SuccessPage extends BasePage {
    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    private final By successHeader = By.xpath("//h2");


    public boolean isSuccess () throws InterruptedException {
        Thread.sleep(2000);
        try{
            return isDisplayed(successHeader);
        } catch (NoSuchElementException e) {return false;}
    }
}
