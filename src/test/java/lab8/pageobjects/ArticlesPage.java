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
public class ArticlesPage {

    private static Logger Log = LogManager.getLogger(ArticlesPage.class);

    @Autowired
    WebDriver driver;

    WebDriverWait waiter;

    public ArticlesPage() {
    }

    @PostConstruct
    private void init() {
        waiter = new WebDriverWait(driver, 4);
    }

    By loc_menuitem_best = By.xpath("//a[@href='https://habr.com/ru/top/' and @class='toggle-menu__item-link toggle-menu__item-link_active' and contains(text(), 'Лучшие')]/parent::li");
    By loc_menu_items = By.cssSelector("div.tabs__level.tabs__level_bottom a.toggle-menu__item-link");

    public void waitUntilLoad (){
        TestHelper.isPageLoad(waiter, loc_menuitem_best, "The Best articles");
    }

    public By get_loc_post_title_bynum (int post_num) {return By.cssSelector("ul.content-list.content-list_posts.shortcuts_items>li:nth-child(" + post_num +") a.post__title_link");}
    public By get_loc_readmore_btn_bypostnum (int post_num) {return By.cssSelector("ul.content-list.content-list_posts.shortcuts_items>li:nth-child(" + post_num +") a.btn.btn_x-large.btn_outline_blue.post__habracut-btn");}

    public List<String> getAllArticleMenuItems(){
        return TestHelper.getAllMenuItems(driver, loc_menu_items);
    }

    public SelectedArticlePage clickOnReadMoreButton(int post_num) throws Exception {
        TestHelper.clickOnElem(waiter, get_loc_readmore_btn_bypostnum(post_num), "Read more btn for " + post_num + "article");
        return new SelectedArticlePage();
    }
}
