package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import utils.TestContextSetup;

import java.time.Duration;

public class LandingPageStepDefinitions {

    TestContextSetup test;

    public LandingPageStepDefinitions(TestContextSetup test)
    {
        this.test = test;
        test.driver = new ChromeDriver();
        test.driver.manage().window().maximize();
        test.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Given("User is in login page")
    public void user_is_in_login_page() {

        test.driver.get("https://ralvie.minervaiotstaging.com/");


    }
    @When("User logins to the application")
    public void user_logins_to_the_application() {
        test.driver.findElement(By.id("textfield-login-user-username")).sendKeys("9thstage@gonetor.com");
        test.driver.findElement(By.id("textfield-login-view-password")).sendKeys("Admin@123");
        test.driver.findElement(By.id("btn_login_user_signin")).click();
    }
    @When("User selects company")
    public void user_selects_company() {
        test.driver.findElement(By.id("buttons-select-user-organization-0")).click();
        test.driver.findElement(By.id("btn-get-started-organization")).click();

    }
    @Then("User redirects into dashboard page")
    public void user_redirects_into_dashboard_page() {
        Assert.assertTrue(test.driver.findElement(By.id("dashboard-header-text-name")).isDisplayed());
        System.out.println("dashboard page is displayed");

    }
}
