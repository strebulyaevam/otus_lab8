package lab8.pageobjects;

import lab8.helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LoginPage {

    private static Logger Log = LogManager.getLogger(LoginPage.class);

    @Autowired
    WebDriver driver;

    WebDriverWait waiter;


    public LoginPage() {
    }

    By loc_email = By.cssSelector("input[type='email']");

    @PostConstruct
    private void init() {
        waiter = new WebDriverWait(driver, 4);
    }

    public void waitUntilLoad (){
        TestHelper.isPageLoad(waiter, loc_email, "LoginPage");
    }
}
