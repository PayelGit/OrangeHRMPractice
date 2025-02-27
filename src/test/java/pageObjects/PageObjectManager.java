package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager
{



    public WebDriver driver;
    LandingPageObjects landingPageObjects;
    DashboardPageObjects dashboardPageObjects;
    TagsPageObjects tagsPageObjects;

    public PageObjectManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public LandingPageObjects getLandingPage()
    {
        landingPageObjects = new LandingPageObjects(driver);
        return landingPageObjects;
    }

    public DashboardPageObjects getDashboardPageObjects()
    {
        dashboardPageObjects = new DashboardPageObjects(driver);
        return dashboardPageObjects;
    }

    public TagsPageObjects getTagPage()
    {
        tagsPageObjects = new TagsPageObjects(driver);
        return tagsPageObjects;
    }
}
