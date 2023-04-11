package TestNGPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browser_Setup.Base;
import Utils.Utility;
import page.ForgotPasswordPage;
import page.LoginPage;

public class VerifyForgotPasswordPage extends Base {
  
	WebDriver driver ;
	LoginPage loginPage ;
	ForgotPasswordPage forgotPasswordPage ;
	SoftAssert soft;
	String testId;
	 
	
	    
	@Parameters ("browser")
	@BeforeTest
	public void openBrowser(String browserName ) {
    	System.out.println("VerifyForgotPasswordPage.Before Test");
    	if(browserName.equals("Chrome"))
    	{
    	    driver = openChromeBrowser();
    	}
    	
    	if(browserName.equals("Firefox"))
    	{
    		driver = openFirefoxBrowser();
    	}
    	
    	if(browserName.equals("Edge"))
    	{
    		driver = openEdgeBrowser();
    	}
    	
    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS) ;
	}

    @BeforeClass
    public void beforeClass() {
    	System.out.println("VerifyForgotPasswordPage.Before Class");
    	loginPage = new LoginPage(driver) ;
    	forgotPasswordPage = new ForgotPasswordPage (driver) ;
    	soft = new SoftAssert();
    }
    
    @BeforeMethod
    public void goToForgotPasswordPage() {
    	System.out.println("VerifyForgotPasswordPage.Before Method");
    	driver.get("https://www.facebook.com/");
    	loginPage.clickOnForgotPassword() ;
    }
    
    @Test (priority = 1)
    public void verifyMessageOnForgotPasswordPage() {
    	testId = "Test201";
    	System.out.println("VerifyForgotPasswordPage.Test 1");
    	String actualMsg = forgotPasswordPage.getTextMessege();
    	String expectedMsg = "Please enter your email address or mobile number to search for your account." ;
    	System.out.println(forgotPasswordPage.getTextMessege());
    	
    	Assert.assertEquals(actualMsg, expectedMsg);
    	
//    	if(actualMsg.equals(expectedMsg))
//    	{
//    		System.out.println("PASSED");
//    	}
//    	else
//    	{
//    		System.out.println("FAILED");
//    	}
    }
    
    @Test (priority = 2)
    public void verifyCancelButtonOnForgotPasswordPage() {
    	testId = "Test202";
    	System.out.println("VerifyForgotPasswordPage.Test 2");
    	forgotPasswordPage.clickOnCancelButton();
    	String actualUrl = driver.getCurrentUrl() ;
    	String expectedUrl = "https://www.facebook.com/login.php" ;
    	String actualTitle = driver.getTitle() ;
    	String expectedTitle = "Log in to Facebook" ;
    	System.out.println(driver.getTitle());
    	
    	soft.assertEquals(actualUrl, expectedUrl);
    	soft.assertEquals(actualTitle, expectedTitle);
    	
    	soft.assertAll();
    	
//    	if(actualUrl.equals(expectedUrl) && actualTitle.equals(expectedTitle))
//    	{
//    		System.out.println("PASSED");
//    	}
//    	else
//    	{
//    		System.out.println("FAILED");
//    	}
    }
    
    @Test (priority = 3)
    public void verifySearchButtonOnForgotPasswordPage() {
    	testId = "Test203";
    	System.out.println("VerifyForgotPasswordPage.Test 3");
    	forgotPasswordPage.enterEmailOrMobile("pranitwarhikar@gmail.c");
    	forgotPasswordPage.clickOnSearchButton();
    	String expectedErrorMessage = "Your search did not return any results. Please try again with other information." ;
    	String expectedErrorTitle = "No search results123" ;
    	String actualErrorMessage = forgotPasswordPage.getErrorMessage();
    	String actualErrorTitle = forgotPasswordPage.getErrorTitle();
    	
    	System.out.println(forgotPasswordPage.getErrorMessage());
    	System.out.println(forgotPasswordPage.getErrorTitle());
    	
    	soft.assertEquals(actualErrorMessage, expectedErrorMessage);
    	soft.assertEquals(actualErrorTitle, expectedErrorTitle);
    	
    	soft.assertAll();
    	
//    	if(expectedErrorMessage.equals(actualErrorMessage) && expectedErrorTitle.equals(actualErrorTitle))
//    	{
//    		System.out.println("PASSED");
//    	}
//    	else
//    	{
//    		System.out.println("FAILED");
//    	}
    }
    
    @AfterMethod
    public void logOutFromApplication(ITestResult result) throws IOException, InterruptedException {
    	System.out.println("VerifyForgotPasswordPage.After Method");
    	
    	if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreen(driver, testId);
		}
		System.out.println("VerifyLoginPage.After Method");
    }
    
    @AfterClass
    public void closeTheBrowser() {
    	System.out.println("VerifyForgotPasswordPage.After Class");
    	loginPage = null;
    	forgotPasswordPage = null;
        soft = null;
    }
    
    @AfterTest
    public void afterTest() {
    	System.out.println("VerifyForgotPasswordPage.Afetr Test");
    	driver.quit();
    	driver = null;
    	System.gc();
    }
    
}


