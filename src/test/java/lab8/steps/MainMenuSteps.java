package lab8.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab8.pageobjects.MainMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class MainMenuSteps {

    @Autowired
    MainMenu mainMenu;

    @When("HomePage is open")
    public void openHost() throws Exception {
        mainMenu.openMainPage();
    }

    @Then("page title should be {string}")
    public void pageTitleShouldBe(String title) {
        Assert.assertEquals(mainMenu.getTitle(), title);
    }

    @Then("Title contains {string}")
    public void titleContains(String title_part) {
        Assert.assertTrue(mainMenu.titleContainString(title_part));
    }

    @Then("Main menu contains items")
    public void mainMenuContainsItems(io.cucumber.datatable.DataTable expItemsTable) {

        List<String> expResult = expItemsTable.asList(String.class);
        List<String> actualResult = mainMenu.getAllMainMenuItems();
        Assert.assertEquals(expResult, actualResult);
    }

    @When("Main Menu is opened")
    public void mainMenuIsOpened() {
        mainMenu.waitUntilLoad();
    }

    @Then("Main menu item {string} is selected")
    public void mainMenuItemIsSelected(String menu_item) {
        Assert.assertTrue(mainMenu.isMenuItemSelected(menu_item));
    }

    @When("Main menu item {string} is clicked")
    public void mainMenuItemIsClicked(String menu_item) throws Exception {
        mainMenu.clickItemByName(menu_item);
    }
}
