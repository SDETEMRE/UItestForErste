package test.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.pages.BasePage;
import test.pages.Erste;
import test.utilities.BrowserUtils;
import org.junit.Assert;

import java.time.Duration;

public class erste{
    Erste erste = new Erste();
    @Given("User login with valid credentials")
    public void user_login_with_valid_credentials() {
        erste.landingPage();
        erste.login();
    }
    @When("User enters Fashion in the search box")
    public void user_enters_fashion_in_the_search_box() {
        erste.textSearchBox();
    }
    @When("User enters {string} in the search box")
    public void user_enters_in_the_search_box(String fashion) {
        BrowserUtils.waitForVisibility(erste.searchBox, Duration.ofSeconds(30));
        erste.searchBox.sendKeys(fashion);
        erste.searchBtn.click();
    }
    @Then("user verifies selected category")
    public void user_verifies_selected_category() {
        erste.listOfFashion(1).click();
        String expectedResult = "Fashion";
        String actualResult = erste.publishCategory.getAttribute("innerHTML");
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Then("user verifies that selected category is not shown")
    public void user_verifies_that_selected_category_is_not_shown() {
        String expectedResult = "I'm sorry, I could not find what you were searching for. Could you please specify your search criteria?";
        String actualResult = erste.sorryMessage.getAttribute("innerHTML");
        Assert.assertEquals(expectedResult,actualResult);

    }
}
