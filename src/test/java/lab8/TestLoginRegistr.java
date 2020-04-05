package lab8;

import com.google.common.collect.ImmutableList;
import config.Lab8Config;
import lab8.pageobjects.LoginPage;
import lab8.pageobjects.MainMenu;
import lab8.pageobjects.RegistrPage;
import lab8.pageobjects.TopMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

@Test
@ContextConfiguration(classes = TestConfig.class)
public class TestLoginRegistr extends AbstractTestNGSpringContextTests {

    @Autowired
    MainMenu mainMenu;

    @Autowired
    TopMenu topMenu;

    @Autowired
    LoginPage loginPage;

    @Autowired
    RegistrPage registrPage;


    @Test
    public void buttonLoginDispalyTheCorrectPage() throws Exception {
        mainMenu.openMainPage();
        topMenu.waitUntilLoad();
        topMenu.clickOnLoginButton();
        loginPage.waitUntilLoad();
        Assert.assertTrue(mainMenu.titleContainString("Вход"));
    }

    @Test
    public void buttonRegistrationDispalyTheCorrectPage() throws Exception {
        mainMenu.openMainPage();
        topMenu.waitUntilLoad();
        topMenu.clickOnRegistrButton();
        registrPage.waitUntilLoad();
        Assert.assertTrue(mainMenu.titleContainString("Регистрация"));
    }
}
