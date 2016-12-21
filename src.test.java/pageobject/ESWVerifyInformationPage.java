package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.DriverFactory;


/**
 * PageObject Class of ExamFX-ESW VerifyInformation Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX-ESW VerifyInformation Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class ESWVerifyInformationPage {
	
	WebDriver driver;	
	private By btn_Next = By.id("content_btnNext");
	
	public ESWVerifyInformationPage(){
		this.driver = DriverFactory.getDriver();
	}	
	
	public ESWMainMenuPage clickOnNext(){		
		
		driver.findElement(btn_Next).click();		
		return new ESWMainMenuPage();
	}
}
