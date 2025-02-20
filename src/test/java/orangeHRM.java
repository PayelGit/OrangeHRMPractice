import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class orangeHRM {


    public  static WebDriverWait wait;
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        Assert.assertTrue(driver.findElement(By.cssSelector(".orangehrm-login-branding")).isDisplayed());
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));//
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oxd-icon.bi-list.oxd-topbar-header-hamburger")));//
        // Assert.assertTrue(driver.findElement(By.cssSelector(".oxd-icon.bi-list.oxd-topbar-header-hamburger")).isDisplayed());//
        // driver.findElement(By.cssSelector(".oxd-icon.bi-list.oxd-topbar-header-hamburger")).click();
         driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule']")).click();
        // /*Add employee*/
         String expectedURL = driver.getCurrentUrl();
         String actualURL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
//         Assert.assertEquals(actualURL,expectedURL);
        String recordCount = driver.findElement(By.cssSelector(".orangehrm-horizontal-padding.orangehrm-vertical-padding>span")).getText();
        System.out.println("Total records present in the employee list : " + recordCount);
         driver.findElement(By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon")).click();
         driver.findElement(By.name("firstName")).sendKeys("Rup");
         driver.findElement(By.name("lastName")).sendKeys("Chowdhury");
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")).click();
        Thread.sleep(2000);
        System.out.println("Employee created!!");
         driver.findElement(By.cssSelector(".oxd-topbar-body-nav>ul>li:nth-child(2)")).click();
         String expectedURLForEmpList = driver.getCurrentUrl();
         String actualURLForEmpList = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
//         Assert.assertEquals(expectedURLForEmpList,actualURLForEmpList);
         driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")).click();
         driver.findElement(By.cssSelector(".oxd-form-row > div > div:nth-child(1) > div > div:nth-child(2) > div > div > input")).sendKeys("Payel");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")).click();
        Thread.sleep(1000);
        System.out.println("Total records present after creation an employee in the employee list : " + recordCount);
         String[] str = recordCount.split(" ");
         String st = str[0].replace("[^0-9]","");
        System.out.println(st);
         if(st.equals("1"))
         {
             System.out.println("Record found");
         }
         else {
             System.out.println("record not found");
         }
         driver.quit();

         List<WebElement> list = driver.findElements(By.cssSelector(".oxd-table-body>div>div>div:nth-child(3)>div"));
         for(WebElement li : list)
         {
             String listOfEmployees = li.getText();
             if(listOfEmployees.equalsIgnoreCase("Payel"))
             {
                 driver.findElement(By.cssSelector(".oxd-icon.bi-pencil-fill")).click();
                 driver.findElement(By.xpath("//div[@role='tablist']/div[6]")).click();
             }
         }

    }
}
