package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment CompletePage
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment CompletePage
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class EnrollmentCompletePage {
	
	WebDriver driver;
	
	public EnrollmentCompletePage(){
		this.driver = DriverFactory.getDriver();
	}	

	private By btn_LaunchCourse = By.id("Content_DirectLaunch");	
	private By btn_NextOnVerifyInfoPage = By.id("content_btnNext");		
	
	public void clickOnLaunchCourse(){
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(btn_LaunchCourse));
		
		driver.findElement(btn_LaunchCourse).click();
	}	
	
	public ESWMainMenuPage clickOnNextOnVerifyInformationPage(){
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(btn_NextOnVerifyInfoPage));
		
		driver.findElement(btn_NextOnVerifyInfoPage).click();
		
		return new ESWMainMenuPage();
	}	
}
