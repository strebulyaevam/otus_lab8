package lab8.steps;

import io.cucumber.java.en.Then;
import lab8.pageobjects.LoginPage;
import lab8.pageobjects.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class LoginPageSteps {

    @Autowired
    MainMenu mainMenu;

    @Autowired
    LoginPage loginPage;

    @Then("LoginPage is displayed")
    public void loginpageIsDisplayed() {
        Assert.assertTrue(mainMenu.titleContainString("Вход"));
        loginPage.waitUntilLoad();
    }
}
