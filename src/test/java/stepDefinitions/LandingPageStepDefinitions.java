package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.DashboardPageObjects;
import pageObjects.LandingPageObjects;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefinitions {

    TestContextSetup test;
    LandingPageObjects landingPageObjects;
    DashboardPageObjects dashboardPageObjects;

    public LandingPageStepDefinitions(TestContextSetup test)
    {
        this.test = test;
        test.driver = new ChromeDriver();
        test.driver.manage().window().maximize();
        test.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        landingPageObjects = new LandingPageObjects(test.driver);
        dashboardPageObjects = new DashboardPageObjects(test.driver);


    }

    @Given("User is in login page")
    public void user_is_in_login_page() {

        test.driver.get("https://ralvie.minervaiotstaging.com/");


    }
    @When("User logins to the application")
    public void user_logins_to_the_application() {
        landingPageObjects.loginToTheApplication("9thstage@gonetor.com","Admin@123");

    }
    @When("User selects company")
    public void user_selects_company() {
        landingPageObjects.selectOrganization();
    }


    @Then("User redirects into dashboard page")
    public void user_redirects_into_dashboard_page() {
        Assert.assertTrue(dashboardPageObjects.dashBoardLogo().isDisplayed());
        System.out.println("dashboard page is displayed");

    }
}
