package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.TagsPageObjects;
import utils.TestContextSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TagsStepDefinitions {

    TestContextSetup test;
    public TagsPageObjects tagsPageObjects;
    FileInputStream fis ;
    Properties prop ;

    public TagsStepDefinitions(TestContextSetup test) throws IOException
    {
        this.test = test;
        fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
        prop = new Properties();
        prop.load(fis);
        this.tagsPageObjects = test.pageObjectManager.getTagPage();
    }






    @And("User navigates into Tag module")
    public void User_navigates_into_Tag_module()
    {
        tagsPageObjects.navigateToTagModule();
    }


    @And("User creates a tag and validates")
    public void User_creates_a_tag_and_validates() throws IOException {
        tagsPageObjects.createTag(prop.getProperty("tagName"));
        tagsPageObjects.searchRecord(prop.getProperty("tagName"));
    }



}

