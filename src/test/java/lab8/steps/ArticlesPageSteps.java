package lab8.steps;

import io.cucumber.java.en.Then;
import lab8.pageobjects.ArticlesPage;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticlesPageSteps {
    @Autowired
    ArticlesPage articlesPage;

    @Then("ArticlesPage is displayed")
    public void articlesPageIsDisplayed() {
        articlesPage.waitUntilLoad();
    }

}
