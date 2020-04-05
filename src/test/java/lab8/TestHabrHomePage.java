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
public class TestHabrHomePage extends AbstractTestNGSpringContextTests {

    @Autowired
    MainMenu mainMenu;

    @Autowired
    TopMenu topMenu;

    @Test
    public void openHabrHomePage() throws Exception {
        mainMenu.openMainPage();
        Assert.assertEquals(mainMenu.getTitle(), "Лучшие публикации за сутки / Хабр");
    }

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
}
