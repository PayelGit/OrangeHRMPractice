import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class GoogleStopwatch {


    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();
//        driver.get("https://mail.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("payelbhp94@gmail.com");
//        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();


        driver.get("https://www.google.com/");
        WebElement serachBox = driver.findElement(By.xpath("//textarea[@title='Search']"));
        serachBox.sendKeys("stopwatch");
        serachBox.sendKeys(Keys.ENTER);
//        String val = driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > block-component > div > div > div:nth-child(1) > div > div > div > div > div > div > div > div > div:nth-child(3) > div.ERWxXc.LiVmoe > div.KxibG > div")).getText();


    }
}
