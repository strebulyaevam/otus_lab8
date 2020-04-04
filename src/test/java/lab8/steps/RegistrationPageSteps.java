package lab8.steps;

import io.cucumber.java.en.Then;
import lab8.pageobjects.MainMenu;
import lab8.pageobjects.RegistrPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class RegistrationPageSteps {
    @Autowired
    MainMenu mainMenu;

    @Autowired
    RegistrPage registrPage;

    @Then("RegistrationPage is displayed")
    public void registrPageIsDisplayed() {
        Assert.assertTrue(mainMenu.titleContainString("Регистрация"));
        registrPage.waitUntilLoad();
    }

}
