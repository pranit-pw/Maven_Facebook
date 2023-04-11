package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SingupPopUp {
	
	@FindBy (xpath = "//input[@id='u_e_b_3p']")
	private WebElement fistName;
	
	@FindBy (xpath = "//input[@id='u_e_d_OX']")
	private WebElement lastName;
	
	@FindBy (xpath = "//input[@id='u_e_g_Fq']")
	private WebElement emailOrPhoneNumber;
	
	@FindBy (xpath = "//input[@id='pass']")
	private WebElement newPassword;
	
	@FindBy (xpath = "//select[@id='day']")
	private WebElement day;
	
	@FindBy (xpath = "//select[@id='month']")
	private WebElement month;
	
	@FindBy (xpath = "//select[@id='year']")
	private WebElement year;
	
	@FindBy (xpath = "//label[text() = 'Female']")
	private WebElement genderFemale;
	
	@FindBy (xpath = "//label[text() = 'Male']")
	private WebElement genderMale;
	
	@FindBy (xpath = "//label[text() = 'Custom']")
	private WebElement genderCustom;
	
	@FindBy (xpath = "//button[@id='u_e_s_Ra']")
	private WebElement signUp;
	
	@FindBy (xpath = "//img[@id='u_e_9_IP']")
	private WebElement closeButton;
	
	@FindBy (xpath = "(//option[@selected=\"1\"])[2]")
	private WebElement selectedMonth;
	
	private WebDriver driver;
	
	//Variable Initialization
	public SingupPopUp(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	//Variable Use
	public void sendFirstName() {
		fistName.sendKeys("pranit");
	}
	
	public void sendLastName() {
		lastName.sendKeys("warahikar");
	}
	
	public void enterEmailOrPhoneNumber() {
		lastName.sendKeys("pranitwarhikar@gmail.com");
	}
	
	public void enterNewPassword() {
		newPassword.sendKeys("pranit@5172#");
	}
	
	public void selectMonth() {
		Select s = new Select(month);
		s.deselectByValue("3");
	}
	
	public void selectDay() {
		Select s = new Select(day);
		s.selectByValue("9");		
	}
	
	public void selectYear() {
		Select s = new Select(year);
		s.deselectByValue("1998");
	}
	
	public void clickOnFemaleButton() {
		genderFemale.click();
	}
	
	public void clickOnMaleButton() {
		genderMale.click();
	}
	
	public void clickONCustomButton() {
		genderCustom.click();
	}
	
	public void clickOnSignUpButton() {
		signUp.click();
	}
	
	public void clickOnCloseButton() {
		closeButton.click();
	}
	
	public String getSelectedMonth() {
		String text = selectedMonth.getAttribute("value");
		return text;
	}
	




}
