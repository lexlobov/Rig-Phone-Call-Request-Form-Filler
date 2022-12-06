package com.issart.rig.pageobject.infoform;

import com.issart.rig.model.Driver;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }


    private final By startButton = By.xpath("//button");

    public CoordinatesPage goToCoordinatesPage(){
        press(startButton);
        return new CoordinatesPage(driver);
    }

}
