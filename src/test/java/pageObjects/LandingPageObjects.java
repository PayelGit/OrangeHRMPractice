package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObjects {
    WebDriver driver;
    By userName = By.id("textfield-login-user-username");
    By passWord = By.id("textfield-login-view-password");
    By loginBtn = By.id("btn_login_user_signin");
    By selectOrganization = By.id("buttons-select-user-organization-0");
    By selectOrgBtn = By.id("btn-get-started-organization");



    public LandingPageObjects(WebDriver driver)
    {
        this.driver = driver;
    }


    public void loginToTheApplication(String username, String pass)
    {
        driver.findElement(userName).sendKeys(username);
        driver.findElement(passWord).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public void selectOrganization()
    {
        driver.findElement(selectOrganization).click();
        driver.findElement(selectOrgBtn).click();
    }


}
