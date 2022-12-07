package com.issart.rig.pageobject.paymentform;

import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    private final By continueButton = By.xpath("//button");

    public PaymentPage goToPaymentPage() throws InterruptedException {
        int n = 0;
        while (n++ < 5){
            try {
                press(continueButton);
                break;
            } catch (WebDriverException e){
                Thread.sleep(1000);
            }
        }
        return new PaymentPage(driver);
    }
}
