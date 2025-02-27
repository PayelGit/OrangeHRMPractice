package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.IOException;

public class Hooks {

    public WebDriver driver;
    public TestContextSetup textContextSetup;

    public Hooks(TestContextSetup textContextSetup)
    {
        this.textContextSetup = textContextSetup;
    }

    @Before
    public void beforeSetUp()
    {

//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//        driver.get("https://ralvie.minervaiotstaging.com/");
//        driver.manage().window().maximize();
        System.out.println("browser launched");
    }

    @After
    public void tearUp() throws IOException {

        textContextSetup.base.launchBrowser().quit();
        System.out.println("browser closed");
    }
    /*after will execute after each scenario in every feature file*/

    /*Hooks with tags*/
    /*partial common & partial unique code how to run --> common will be in hooks & background*/
    /*then this scenario under Before will execute before each scenario described in steps*/
    /*then this scenario under Before("@tags") will execute before each scenario described in steps
    which having the same tags*/
    /*Before --> Background --> Scenario execution*/



}

