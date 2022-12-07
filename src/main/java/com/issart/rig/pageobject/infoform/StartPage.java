package com.issart.rig.pageobject.infoform;

import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.*;

public class StartPage extends BasePage {
    public StartPage(WebDriver driver) {
        super(driver);
    }


    private final By startButton = By.xpath("//button");

    public CoordinatesPage goToCoordinatesPage() throws InterruptedException {
        int n = 0;
        while (n++ < 5){
            try {
                press(startButton);
                break;
            } catch (WebDriverException e){
                Thread.sleep(1000);
            }
        }
        return new CoordinatesPage(driver);
    }

    public void acceptGeoData() throws InterruptedException {
        int i = 0;
        while (i++ < 5) {
            try {
                Alert alert = driver.switchTo().alert();
                break;
            } catch (NoAlertPresentException e) {
                Thread.sleep(1000);
                continue;
            }
        }
    }

}
