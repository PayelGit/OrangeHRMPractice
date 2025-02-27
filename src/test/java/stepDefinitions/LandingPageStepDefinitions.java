package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.DashboardPageObjects;
import pageObjects.LandingPageObjects;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefinitions {

    public TestContextSetup test;
    public LandingPageObjects landingPageObjects;
    public PageObjectManager pageObjectManager;
    public LandingPageStepDefinitions(TestContextSetup test)
    {
        this.test = test;
    }

    @Given("User is on login page")
    public void User_is_in_login_page()
    {
        landingPageObjects = test.pageObjectManager.getLandingPage();
    }


    @When("^User enters a username (.+) and password (.+)$")
    public void User_enters_valid_credentials_and_process_for_login(String username, String password) {
        landingPageObjects.loginToTheApplication(username, password);
        System.out.println(username + password);
    }
    @And("User selects organization")
    public void user_selects_organization()
    {
        landingPageObjects.selectOrganization();
    }


    @Then("User is navigated to Dashboard page")
    public void User_is_navigated_to_Dashboard_page()
    {
        Assert.assertTrue(landingPageObjects.verifyAppLogo().isDisplayed());
//        String loginPageURL = "https://ralvie.minervaiotstaging.com/dashboard";
//        Assert.assertEquals(test.driver.getCurrentUrl(), loginPageURL);
    }
    @Then("User receives error message")
    public void user_receives_error_message()
    {

//        Assert.assertTrue(loginPageObjects.verifyErrorMsg().isDisplayed());
        String errorMsg = "The email address or password you entered is incorrect. Please check your credentials and try again.";
        Assert.assertEquals(landingPageObjects.verifyErrorMsg(),errorMsg);
    }

    @And ("User should remain on the login page")
    public void  user_should_remain_on_the_login_page()
    {
        String loginPageURL = "https://ralvie.minervaiotstaging.com/";
//        Assert.assertEquals(test.driver.getCurrentUrl(), loginPageURL);
    }
}
