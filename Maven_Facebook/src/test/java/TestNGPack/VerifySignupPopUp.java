package TestNGPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
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
import page.LoginPage;
import page.SingupPopUp;

public class VerifySignupPopUp extends Base {
	
	WebDriver driver;
	SingupPopUp signUpPopUp;
	LoginPage loginPage;
	SoftAssert soft;
	String testId;
	
	
	@Parameters ("browser")
	@BeforeTest
	public void openBrowser(String browserName ) {
    	System.out.println("VerifySignupPopUp.Before Test");
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
		System.out.println("VerifySignupPopUp.Before Class");
		signUpPopUp = new SingupPopUp(driver);
		loginPage = new LoginPage(driver) ;
		soft = new SoftAssert();
	}
	
	@BeforeMethod
	public void goToSignUpPop() {
		System.out.println("VerifySignupPopUp.Before Method");
		driver.get("https://www.facebook.com/");		
	}
	
	@Test (priority = 1)
	public void verifyDayDropDown() {
		testId = "Test301";
		System.out.println("VerifySignupPopUp.Test 1");
		loginPage.clickOnCreateNewAccount();
		signUpPopUp.selectDay();
		
		soft.assertEquals(9, 9);
		
		soft.assertAll();
	}
	
	@Test (priority = 2)
    public void verifyMonthDropDown() {
		testId = "Test302";
		System.out.println("VerifySignupPopUp.Test 2");
		loginPage.clickOnCreateNewAccount();
		signUpPopUp.selectMonth();
		System.out.println(signUpPopUp.getSelectedMonth());
		soft.assertEquals(3, 3);
		
		soft.assertAll();
		
	}
	
	@Test (priority = 3, dependsOnMethods = "verifyMonthDropDown")
    public void verifyYearDropDown() {
		testId = "Test303";
		System.out.println("VerifySignupPopUp.Test 3");
		loginPage.clickOnCreateNewAccount();
		signUpPopUp.selectYear();
		
		soft.assertEquals(1998, 1998);
		
		soft.assertAll();
		
	}
	
	
	@AfterMethod
	public void logOutFromApplication(ITestResult result) throws IOException, InterruptedException {
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreen(driver, testId);
		}
		System.out.println("VerifySignupPopUp.After Method");
	}
	
	@AfterClass
	public void closedTheBrowser() {
		System.out.println("VerifySignupPopUp.After Class");
		loginPage = null;
		soft = null;
		signUpPopUp = null;
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("VerifySignupPopUp.After Test");
		driver.quit();
		driver = null;
		System.gc();
	}

}
