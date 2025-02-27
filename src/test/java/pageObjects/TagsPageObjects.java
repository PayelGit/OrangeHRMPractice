package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class TagsPageObjects {

    public WebDriver driver;

    public TagsPageObjects(WebDriver driver)
    {
        this.driver = driver;
    }


    By navigateToTagBtn = By.id("ralvie-logo-navpanelopen-dashboardtagsicon");
    By listOfTags = By.cssSelector(".main-body>div>div:nth-child(2)>div>div>div>div>div>div>div>div:nth-child(1)");
    By addTagBtn = By.id("btn-add-tags");
    By tagNameField = By.id("textfield-tags-add");
    By submitBtn = By.id("btn-tags-add");
    By searchTextbox = By.xpath("//input[@placeholder='Search by tag name']");

    public void navigateToTagModule()
    {
        driver.findElement(navigateToTagBtn).click();
    }
    /*fetch tags*/
    public void fetchTagCounts() {
        List<WebElement> tagLists = driver.findElements(listOfTags);
        System.out.println("Total tags present : " + tagLists.size());
        for (WebElement element : tagLists) {
            /*Print all tag names*/
            System.out.println(element.getText());
        }
    }

    public void createTag(String tagName) throws IOException {
        driver.findElement(addTagBtn).click();
        Random random = new Random();
        int val = random.nextInt(3);
        driver.findElement(tagNameField).sendKeys(tagName+val);
        driver.findElement(submitBtn).click();

    }

    /*Validation 1: Check if the new record appears in the list*/
    public void searchRecord(String tagName) throws IOException {

        try {
            driver.findElement(searchTextbox).click();
            driver.findElement(searchTextbox).sendKeys(tagName);
            List<WebElement> tagLists = driver.findElements(listOfTags);
            if (tagLists.size()!=0 && tagLists.size()>=1) {
                System.out.println("Record validated successfully on the list.");
            } else {
                System.out.println("Record validation failed in the list.");
            }
        } catch (Exception e) {
            System.out.println("Error finding the new record: " + e.getMessage());
        }
    }


}
