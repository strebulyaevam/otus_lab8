package lab8.pageobjects;

import config.Lab8Config;
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
import java.util.List;

@Component
@Scope("prototype")
public class MainMenu {
    private static Logger Log = LogManager.getLogger(MainMenu.class);

    @Autowired
    WebDriver driver;

    @Autowired
    Lab8Config cfg;

    WebDriverWait waiter;

    public MainMenu() {
    }

    @PostConstruct
    private void init() {
        waiter = new WebDriverWait(driver, 4);
    }

    By loc_1st_item = By.xpath("//div[@class = 'tabs__level tabs-level_top tabs-menu']//h3[contains(text(), 'Статьи')]");
    By loc_main_menu = By.cssSelector("div.tabs__level.tabs-level_top.tabs-menu h3.tabs-menu__item-text");
    By loc_menu_item_byname(String item_name){ return By.xpath("//div[@class = 'tabs__level tabs-level_top tabs-menu']//h3[ contains(text(), '" + item_name +"')]");}

    public void waitUntilLoad (){
        TestHelper.isPageLoad(waiter, loc_1st_item, "Main Menu");
    }

    public void clickItemByName (String menuname) throws Exception {
        By loc_item = By.xpath("//div[@class = 'tabs__level tabs-level_top tabs-menu']//h3[contains(text(), '" + menuname + "')]");
        TestHelper.clickOnElem(waiter, loc_item, menuname);
    }

/*
    public ArticlesPage selectArticleItem() throws Exception {
        clickItemByName("Статьи");
        return new ArticlesPage();
     }
*/

    public List<String> getAllMainMenuItems(){
        return TestHelper.getAllMenuItems(driver, loc_main_menu);
    }

    public boolean isMenuItemSelected (String item_name){
        return driver.findElement(loc_menu_item_byname(item_name)).getAttribute("class").contains("tabs-menu__item-text_active");
   }

   public void openMainPage () throws Exception {
       TestHelper.getURL(driver, cfg.hostname());
       TestHelper.isPageLoad(waiter, loc_1st_item, "Main Menu");
   }

   public String getTitle () {
        return driver.getTitle();
   }

   public boolean titleContainString (String title_part){
        return driver.getTitle().contains(title_part);
   }
}
