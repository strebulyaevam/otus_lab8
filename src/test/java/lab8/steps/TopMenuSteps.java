package lab8.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lab8.pageobjects.TopMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.util.List;

public class TopMenuSteps {

    @Autowired
    TopMenu topMenu;

    @When("Top bar is opened")
    public void topMenuIsOpened() throws Exception {
        topMenu.waitUntilLoad();
    }

    @Then("Top bar contains items")
    public void topBarContainsItems(io.cucumber.datatable.DataTable expItemsTable) {

        List<String> expResult = expItemsTable.asList(String.class);
        List<String> actualResult = topMenu.getAllTopMenuItems();
        Assert.assertEquals(expResult, actualResult);
    }

    @Then("Top bar item {string} is selected")
    public void topBarItemIsSelected(String menu_item) {
        Assert.assertTrue(topMenu.isMenuItemSelected(menu_item));
    }

    @When("Top bar item {string} is clicked")
    public void topBarItemIsOpened(String menu_item) throws Exception {
        topMenu.clickTopMenuItemByName(menu_item);
    }

    @When("button Войти is clicked")
    public void buttonLoginIsClicked() throws Exception {
        topMenu.clickOnLoginButton();
    }


    @When("button Регистрация is clicked")
    public void buttonRegistrIsClicked() throws Exception {
        topMenu.clickOnRegistrButton();
    }



}
