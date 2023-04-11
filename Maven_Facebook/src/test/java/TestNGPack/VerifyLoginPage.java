package TestNGPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

public class VerifyLoginPage extends Base {
	
	WebDriver driver;
	LoginPage loginPage ;
	ForgotPasswordPage forgotPasswordPage ;
	SoftAssert soft;
	String testId ;
	
	
	@Parameters ("browser")
	@BeforeTest
	public void openBrowser(String browserName ) {
    	System.out.println("VerifyLoginPage.Before Test");
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
		System.out.println("VerifyLoginPage.Before Class");
		loginPage = new LoginPage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
		soft = new SoftAssert();
	}
	
	@BeforeMethod
	public void goToLoginPage() {
		System.out.println("VerifyLoginPage.Before Method");
		driver.get("https://www.facebook.com/");
	}
	
	@Test (priority = 1)
	public void verifyTextPresentOnUserName() {
		testId = "Test101";
		System.out.println("VerifyLoginPage.Test 1");
		String actualMsg = loginPage.getTextOfUserName();
		String expectedMsg = "Email address or phone number" ;
		System.out.println(loginPage.getTextOfUserName());
		
		soft.assertEquals(actualMsg, expectedMsg);
		
		soft.assertAll();
//		if(actualMsg.equals(expectedMsg))
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED");
//		}
	}
	
	@Test (priority = 2)
	public void verifyErrorMessageOfIncorrectPassword() throws EncryptedDocumentException, IOException, InterruptedException {
		testId = "Test102";
		System.out.println("VerifyLoginPage.Test 2");
		loginPage.sendUserName(Utility.getDataFromExelFile("Sheet1", 2, 0));
		loginPage.clickOnLoginButton();
		String actualMsg = loginPage.getErrorMessageOfIncorrectPassword();
		String expectedMsg = "The password that you've entered is incorrect. Forgotten password?" ;
		System.out.println(loginPage.getErrorMessageOfIncorrectPassword());
		
		soft.assertEquals(actualMsg, expectedMsg);
		
		soft.assertAll();
		
//		if(actualMsg.equals(expectedMsg))
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED");
//		}
	}
	
	@Test (priority = 3)
	public void verifyErrorMessageOfIncorrectUserName() throws EncryptedDocumentException, IOException {
		testId = "Test103";
		System.out.println("VerifyLoginPage.Test 3");
		loginPage.sendPassword(Utility.getDataFromExelFile("Sheet1", 2, 1));
		loginPage.clickOnLoginButton();
		String actualMsg = loginPage.getErrorMessageOfIncorrectUserName();
		String expectedMsg = "The email address or mobile number you entered isn't "
				           + "connected to an account. Find your account and log in.";
		System.out.println(loginPage.getErrorMessageOfIncorrectUserName());
		
		soft.assertEquals(actualMsg, expectedMsg);
		
		soft.assertAll();
		
//		if(actualMsg.equals(expectedMsg))
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED");
//		}
	}
	
	@Test (priority = 4)
	public void verifyForgotPasswordLinkOnLoginPage() {
		testId = "Test104";
		System.out.println("VerifyLoginPage.Test 4");
		loginPage.clickOnForgotPassword();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		System.out.println(driver.getCurrentUrl());
		
//		Assert.assertNotEquals(actualUrl, expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		driver.navigate().back();
		
		
//		if(actualUrl.equals(expectedUrl))
//		{
//			System.out.println("PASSED");
//		}
//		else
//		{
//			System.out.println("FAILED");
//		}
	}
	
	@Test (priority = 5, dependsOnMethods = "verifyForgotPasswordLinkOnLoginPage")
	public void verifyCreateNewAccountButtonOnLoginPage() throws InterruptedException {
		testId = "Test104";
		System.out.println("VerifyLoginPage.Test 5");
		Thread.sleep(3000);
		loginPage.clickOnCreateNewAccount();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException, InterruptedException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreen(driver, testId);
		}
		System.out.println("VerifyLoginPage.After Method");
		
	}
	
	@AfterClass
	public void closedTheBrowser() {
		System.out.println("VerifyLoginPage.After Class");
		loginPage = null;
    	forgotPasswordPage = null;
        soft = null;
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("VerifyLoginPage.After Test");
		driver.quit();
		driver = null;
		System.gc();
	}

}
