package module;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingUpPopUp {
	
		
		@FindBy (xpath = "//div[@id='u_3_a_7w']") 
		private WebElement firstName ;
		
		@FindBy (xpath = "//div[@id='u_3_c_/o']")
		private WebElement lastName ;
		
		@FindBy (xpath = "//div[@id='u_3_f_zB']")
		private WebElement email ;
		
		@FindBy (xpath = "//div[@id='password_field']")
		private WebElement newPass ;
		
		@FindBy (xpath = "//select[@id='day']")
		private WebElement day ;
		
		@FindBy (xpath = "//select[@id='month']")
		private WebElement month ;
		
		@FindBy (xpath = "//select[@id='year']")
		private WebElement yearOFBirth ;
		
		@FindBy (xpath = "//input[@id='u_3_6_9I']")
		private WebElement custom ;
		
		@FindBy (xpath = "//input[@id='u_3_5_zd']")
		private WebElement male ;
		
		@FindBy (xpath = "//input[@id='u_3_4_9/']")
		private WebElement female ;
		
		private WebDriver driver ;
		private WebDriverWait wait ;
		private Actions action ;
		private JavascriptExecutor javascriptExecutor ;
		
		//Variable Initialization
		public SingUpPopUp (WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver ;
			wait = new WebDriverWait (driver, 20) ;
			action = new Actions (driver) ;
			javascriptExecutor = (JavascriptExecutor) driver ;
			
		}	
			
		public void clickOnCustom() {
			wait = new WebDriverWait(driver, 20) ;
			wait.until(ExpectedConditions.visibilityOf(custom)) ;
			javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", custom) ;
			javascriptExecutor.executeScript("window.scrollBy(0,1000)");
			
			action.moveToElement(custom).click().build().perform();				
        }
		
		public void selectYearOfBirth() {
			
			
		}
 }


