package page;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;

public class LoginPage {
	
	//Variable Declaration
	@FindBy (xpath = "//input[@id='email']")
	private WebElement userName ;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement password ;
	
	@FindBy (xpath = "//div[@class='_9ay7']")
	private WebElement errorMessageOfIncorrectPassword ;
	
	@FindBy (xpath = "//div[@class='_9ay7']")
	private WebElement errorMessageOfIncorrectUserName;
	
	@FindBy (xpath = "//button[text()='Log in']")
	private WebElement logInButton ;
	
	@FindBy (xpath = "//a[text()='Forgotten password?']")
	private WebElement forgotPassword ;
	
	@FindBy (xpath = "//a[text()='Create new account']")
	private WebElement createNewAccount ;
	
	private WebDriver driver;
	
	//Variable Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	//Variable Use
	public void sendUserName(String user) throws EncryptedDocumentException, IOException {
		userName.sendKeys(user);
	}
	
	public String getTextOfUserName() {
		String text = userName.getAttribute("aria-label") ;
		return text ;
	}
	
	public String getErrorMessageOfIncorrectPassword() {
		String text = errorMessageOfIncorrectPassword.getText();
		return text ;
	}
	
	public String getErrorMessageOfIncorrectUserName() {
		String text = errorMessageOfIncorrectUserName.getText();
		return text ;
	}
	
	
	
	public void sendPassword(String pass) throws EncryptedDocumentException, IOException {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton() {
		logInButton.click();
	}
	
	public void clickOnForgotPassword() {
		forgotPassword.click();
	}
	
	public void clickOnCreateNewAccount() {
		createNewAccount.click();
	}
	
	public void loginToApplication(String user, String pass) {
		userName.sendKeys(user);
		password.sendKeys(pass);
		logInButton.click();
	}

}
