package lab8.pageobjects;

import lab8.helpers.TestHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public class SelectedArticlePage {

    private static Logger Log = LogManager.getLogger(SelectedArticlePage.class);

    By loc_post_caption = By.cssSelector("span.post__title-text");

    public void waitUntilLoad (WebDriverWait waiter){
        TestHelper.isPageLoad(waiter, loc_post_caption, "The Best articles for the week");
    }

    public String getPageCaption(WebDriver driver, WebDriverWait waiter) throws Exception {
        return TestHelper.getTextFromElem(driver, waiter, loc_post_caption, "post__title-text");
    }

}
