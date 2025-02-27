package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils
{
    public WebDriver driver;
    public WebDriverWait wait;

    public GenericUtils(WebDriver driver)
    {
        this.driver = this.driver;
    }
    public void switchWindow()
    {
        String currentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> itr = windowHandles.iterator();
//        for (Iterator<String> it = itr; it.hasNext(); ) {
            String childWindow = itr.next();
            if(currentWindow!=childWindow)
            {
                driver.switchTo().window(childWindow);
            }


//        }
    }

    public void waitForElementVisible(WebElement element, int duration)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void waitForElementClickable(WebElement element, int duration)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
