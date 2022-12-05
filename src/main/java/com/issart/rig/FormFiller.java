package com.issart.rig;

import com.issart.rig.model.Result;
import com.issart.rig.pageobject.StartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FormFiller {

    WebDriver driver = new FirefoxDriver();
    private String link;

    public FormFiller(String link) {
        this.link = link;
    }

    public Result fillTheForm(){
        if("false".equals(link)){
            return new Result(false);
        }
        driver.get(link);
        StartPage startPage = new StartPage(driver);

        return new Result(true);
    }

    // TODO Дописать методы
}
