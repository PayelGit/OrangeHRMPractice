package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

   public WebDriver driver;
   public PageObjectManager pageObjectManager;
   public GenericUtils genericUtils;
   public Base base;

   public TestContextSetup() throws IOException
   {
      base = new Base() ;
      pageObjectManager = new PageObjectManager(base.launchBrowser());
      genericUtils = new GenericUtils(base.launchBrowser());
   }
}
