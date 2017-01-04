package com.Kargo.Self_Ex_Genrator_Script;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;




public class SelfExcuateSnippet 
{
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	 

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
	  //  driver = new FirefoxDriver();
	  System.setProperty("webdriver.chrome.driver", "/Users/IsabelaFairooz/Downloads/chromedriver");
	  driver = new ChromeDriver();
	    baseUrl = "http://adtag.krg.io/self-execute/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	

	  @Test
	  public void testSnippetGenrator() throws Exception {
	    driver.get(baseUrl);
	    driver.findElement(By.name("adtag_url")).clear();
	    driver.findElement(By.name("adtag_url")).sendKeys(Constants.ad_tag_url);
	    Thread.sleep(5000);
	    driver.findElement(By.name("slot_id")).clear();
	    driver.findElement(By.name("slot_id")).sendKeys(Constants.ad_Slot_ID);
	    Thread.sleep(5000);
	    driver.findElement(By.name("snippet")).clear();
	    driver.findElement(By.name("snippet")).sendKeys(Constants.Crative_Snippet);
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
	    Thread.sleep(5000);
	   if(driver.getPageSource().contains("Kargo Ad Self-Serving Tag: Start - GeneratedAt"))
	   {
		   System.out.println(" found");
	   }
	   else
	   {
		   System.out.println("NO");
	   }
	    
	  }

	  @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

	  private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	      driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }

}
