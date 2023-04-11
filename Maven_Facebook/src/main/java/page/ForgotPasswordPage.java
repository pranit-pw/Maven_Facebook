package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	@FindBy (xpath = " //table//div")
	private WebElement textMessage ;
	
	@FindBy (xpath = "//input[@id='identify_email']")
	private WebElement emailOrMobileNumber ;
	
	@FindBy (xpath = "//button[text()='Search']")
	private WebElement searchButton ;
	
	@FindBy (xpath = "//a[text()='Cancel']")
	private WebElement cancelButton ;
	
	@FindBy (xpath = "//div[@class='_9o4h']")
	private WebElement errorMessage ;
	
	@FindBy (xpath = "//div[@class='_9o4g fsl fwb fcb']")
	private WebElement errorTitle;
	
//	private WebDriver driver ;
	
	//Variable Initialization
	public ForgotPasswordPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
//		this.driver = driver ;
	}
	
	//Variable Use
	public String getTextMessege() {
		String text = textMessage.getText();
		return text;
	}
	
	public void enterEmailOrMobile(String user ) {
		emailOrMobileNumber.sendKeys(user);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	public void clickOnCancelButton() {
		cancelButton.click();
	}
	
	public String getErrorMessage() {
		String text = errorMessage.getText(); 
		return text ;
	}
	
	public String getErrorTitle() {
		String text = errorTitle.getText();
		return text ;
	}
	
	
	

}
