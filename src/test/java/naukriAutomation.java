import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class naukriAutomation
{

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.naukri.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.id("login_Layer")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))));
        driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("payelbhp94@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Payel94@naukri");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//img[@alt='naukri user profile img']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(text(),'View & Update Profile')]"))));
        driver.findElement(By.xpath("//a[contains(text(),'View & Update Profile')]")).click();
        driver.findElement(By.cssSelector("#root > div > div > span > div > div > div > div > div > div.dashboard-component > div.dashboard > div > div > div > div.txt-wrapper.col > div:nth-child(1) > div > div.hdn > em")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Basic details')]")).isDisplayed());

        driver.findElement(By.id("totalAbsCtc_id")).click();
        driver.findElement(By.id("totalAbsCtc_id")).sendKeys(Keys.CONTROL,"A");
        driver.findElement(By.id("totalAbsCtc_id")).sendKeys(Keys.BACK_SPACE);
        driver.findElement(By.id("totalAbsCtc_id")).sendKeys("1400000");

        WebElement saveBtn = driver.findElement(By.id("saveBasicDetailsBtn"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",saveBtn);
        wait.until(ExpectedConditions.visibilityOf(saveBtn));
        saveBtn.click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mod-date>span")));
        String modTime = driver.findElement(By.cssSelector(".mod-date>span")).getText();
        System.out.println(modTime);
        if(modTime.equalsIgnoreCase("Profile last updated - Today"))
        {
            System.out.println("done");
        }
        driver.quit();
    }


}
