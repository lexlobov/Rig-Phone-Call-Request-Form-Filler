package com.issart.rig.formfillers;

import com.issart.rig.model.PaymentDetails;
import com.issart.rig.pageobject.paymentform.MapPage;
import com.issart.rig.pageobject.paymentform.OverviewPage;
import com.issart.rig.pageobject.paymentform.PaymentPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class PaymentFormFiller {

    WebDriver driver;

    private void setUp(){
        FirefoxOptions ffopt = new FirefoxOptions()
                .addPreference("dom.webnotifications.enabled", true)
                .addPreference("geo.enabled", true)
                .addPreference("geo.provider.use_corelocation", true)
                .addPreference("geo.prompt.testing", true)
                .setHeadless(true)
                .addPreference("geo.prompt.testing.allow", true);

        driver = new FirefoxDriver(ffopt);
    }
    private String link;

    public PaymentFormFiller(String link) {
        this.link = link;
    }

    public String fillTheForm(PaymentDetails details) throws InterruptedException {
        if ("false".equals(link)) {
            System.out.println("Wasn't able to get link from sms message :<");
            return "{" +
                    "\"success\": false" +
                    "}";
        }
        setUp();
        driver.get(link);
        OverviewPage overviewPage = new OverviewPage(driver);
        PaymentPage paymentPage = overviewPage.goToPaymentPage();
        MapPage mapPage = paymentPage.fillPaymentForm(details);
        boolean success = mapPage.isSuccess();

        driver.quit();
        return String.format("{" +
                "\"success\": %s" +
                "}", success);
    }

}
