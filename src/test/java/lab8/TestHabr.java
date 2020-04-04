package lab8;

import com.google.common.collect.ImmutableList;
import config.Lab8Config;
import lab8.pageobjects.LoginPage;
import lab8.pageobjects.MainMenu;
import lab8.pageobjects.RegistrPage;
import lab8.pageobjects.TopMenu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class TestHabr {

    @Autowired
    Lab8Config cfg;

    @Autowired
    MainMenu mainMenu;

    @Autowired
    TopMenu topMenu;

    @Test
    public void openHabrHomePage() throws Exception {
        mainMenu.openMainPage();
        Assert.assertEquals(mainMenu.getTitle(), "Лучшие публикации за сутки / Хабр");
    }

    @Autowired
    LoginPage loginPage;

    @Autowired
    RegistrPage registrPage;

    @Test
    public void topBarIsOntheHomePage() throws Exception {
        List<String> expResult = ImmutableList.<String>builder()
                .add("Все потоки")
                .add("Разработка")
                .add("Научпоп")
                .add("Администрирование")
                .add("Дизайн")
                .add("Менеджмент")
                .add("Маркетинг")
                .build();

        mainMenu.openMainPage();
        topMenu.waitUntilLoad();
        List<String> actualResult = topMenu.getAllTopMenuItems();
        Assert.assertEquals(expResult, actualResult);
    }

    @Test
    public void firstItemOfTopBarIsSelected() throws Exception {
        mainMenu.openMainPage();
        topMenu.waitUntilLoad();
        Assert.assertTrue(topMenu.isMenuItemSelected("Все потоки"));
    }

    @Test
    public void buttonLoginDispalyTheCorrectPage() throws Exception {
        mainMenu.openMainPage();
        topMenu.waitUntilLoad();
        topMenu.clickOnLoginButton();
        Assert.assertTrue(mainMenu.titleContainString("Вход"));
        loginPage.waitUntilLoad();
    }

    @Test
    public void buttonRegistrationDispalyTheCorrectPage() throws Exception {
        mainMenu.openMainPage();
        topMenu.waitUntilLoad();
        topMenu.clickOnRegistrButton();
        Assert.assertTrue(mainMenu.titleContainString("Регистрация"));
        registrPage.waitUntilLoad();
    }
}
