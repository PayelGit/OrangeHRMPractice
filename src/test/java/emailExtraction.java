import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class emailExtraction {

    public static void main(String[] args) throws InterruptedException, AWTException {
        WebDriver driver = new ChromeDriver();
//        driver.get("https://mail.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("payelbhp94@gmail.com");
//        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();


        driver.get("https://www.convertcsv.com/email-extractor.htm");
        List<WebElement> list= driver.findElements(By.className("headerBlue"));
        for(WebElement li : list)
        {
            String text = li.getText();
            if(text.equalsIgnoreCase("Step 1: Select your input"))
            {
                System.out.println("header verified");
            }
        }

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.id("fileTabLink")));
        driver.findElement(By.id("fileTabLink")).click();
        String filePath = "C:\\Users\\payel\\Downloads\\3-6 Years - 25-Feb.pdf";
        WebElement uploadElement = driver.findElement(By.xpath("//input[@type='file']"));

        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",uploadElement);
        uploadElement.sendKeys(filePath);
        driver.findElement(By.xpath("//input[@title='Find Emails in Text']")).click();
        driver.findElement(By.cssSelector(".fa.fa-clipboard")).click();

        WebElement resultBox = driver.findElement(By.cssSelector("#txta"));
        String extractedEmails = resultBox.getText();

        // Print the extracted emails in the console
        System.out.println("Extracted Emails:\n" + extractedEmails);
        System.out.println("done");
//        driver.quit();

//        Robot robot = new Robot();
//        StringSelection filePath = new StringSelection("C:\\Users\\payel\\Downloads\\3-6 Years - 21-Feb.pdf");
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath,null);
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        robot.keyRelease(KeyEvent.VK_V);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

    }
}
