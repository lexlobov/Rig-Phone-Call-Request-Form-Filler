package com.issart.rig.pageobject.paymentform;

import com.issart.rig.model.PaymentDetails;
import com.issart.rig.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.id("email");
    private final By cardField = By.name("cardNumber");
    private final By cardExpiryField = By.name("cardExpiry");
    private final By cvcField = By.name("cardCvc");
    private final By billingNameField = By.name("billingName");

    private final By button = By.tagName("button");

    public MapPage fillPaymentForm(PaymentDetails details) throws InterruptedException {
        int n = 0;
        while (n++<13){
            try {
                type(emailField, details.getEmail());
                type(cardField, details.getCardNumber());
                type(cardExpiryField, details.getMonth() + details.getYear());
                type(cvcField, details.getCvc());
                type(billingNameField, details.getNameOnCard());
                findAll(button).get(2).click();
                break;
            } catch (WebDriverException e){
                Thread.sleep(1000);
            }
        }
        return new MapPage(driver);
    }
}
