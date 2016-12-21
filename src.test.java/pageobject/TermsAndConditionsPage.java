package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment - TermsAndConditions Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment - TermsAndConditions Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class TermsAndConditionsPage {
	
	WebDriver driver;
	
	public TermsAndConditionsPage(){
		this.driver = DriverFactory.getDriver();
	}		
	
	private By btn_iAccept = By.id("Content_btnAccept");
	private By btn_iDecline = By.id("Content_btnDecline");
	
	public void clickOnAccept(){
		driver.findElement(btn_iAccept).click();
	}	
	
	public void clickOnDecline(){
		driver.findElement(btn_iDecline).click();
	}	
	
	
}
