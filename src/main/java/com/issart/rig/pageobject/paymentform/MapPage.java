package com.issart.rig.pageobject.paymentform;

import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class MapPage extends BasePage {

    public MapPage(WebDriver driver) {
        super(driver);
    }

    private final By header = By.tagName("h2");

    public boolean isSuccess () throws InterruptedException {
        int n = 0;
        boolean l = false;
        while (n++<7){
            try {
                l = isDisplayed(header);
                break;
            } catch (WebDriverException e){
                Thread.sleep(1000);
            }
        }
        return l;
    }
}
