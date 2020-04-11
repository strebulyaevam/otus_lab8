package lab8.pageobjects;

import lab8.helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RegistrPage {
    private static Logger Log = LogManager.getLogger(RegistrPage.class);

    By loc_email = By.cssSelector("input[type='email']");

    public void waitUntilLoad (WebDriverWait waiter){
        TestHelper.isPageLoad(waiter, loc_email, "RegistrationPage");
    }
}
