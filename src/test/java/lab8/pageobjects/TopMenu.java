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
import java.util.List;

@Component
public class TopMenu {
    private static Logger Log = LogManager.getLogger(TopMenu.class);

    @Autowired
    WebDriver driver;

    WebDriverWait waiter;

    public TopMenu() {
    }

    @PostConstruct
    private void init() {
        waiter = new WebDriverWait(driver, 4);
    }

    By loc_1st_item = By.xpath("//div[@class='main-navbar']//a[@href='https://habr.com/ru/all/']");

    By loc_top_menu = By.cssSelector("ul.nav-links>li a");
    By loc_topmenu_item_byname(String item_name){ return By.xpath("//div[@class='main-navbar']//li[@class='nav-links__item']//a[contains(text(), '" + item_name + "')]");}
    By loc_loginbtn = By.cssSelector("a#login");
    By lo_regist_btn = By.cssSelector("a.btn.btn_medium.btn_navbar_registration");

    public void waitUntilLoad (){
        TestHelper.isPageLoad(waiter, loc_1st_item, "Top Menu");
    }

    public void clickTopMenuItemByName (String menuname) throws Exception {
        Log.info("Try to click on " + menuname + " menu item in TOP menu");
        TestHelper.clickOnElem(waiter, loc_topmenu_item_byname(menuname), menuname + " menu item in TOP menu");
        Log.info("Get menu " + menuname + " successfully");
    }

    public List<String> getAllTopMenuItems(){
        return TestHelper.getAllMenuItems(driver, loc_top_menu);
    }

    public boolean isMenuItemSelected (String item_name){
        return driver.findElement(loc_topmenu_item_byname(item_name)).getAttribute("class").contains("nav-links__item-link_current");
    }

    public void clickOnLoginButton() throws Exception {
        TestHelper.clickOnElem(waiter, loc_loginbtn, "Login btn");
    }

    public void clickOnRegistrButton() throws Exception {
        TestHelper.clickOnElem(waiter, lo_regist_btn, "Registration btn");
    }

}
