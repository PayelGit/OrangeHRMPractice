package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageObjects {


    WebDriver driver;
    By dashboardLogo = By.id("dashboard-header-text-name");


    public DashboardPageObjects(WebDriver driver)
    {
        this.driver = driver;
    }


    public WebElement dashBoardLogo()
    {
        return driver.findElement(dashboardLogo);
    }

}
