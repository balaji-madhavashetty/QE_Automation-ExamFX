package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX LaunchCourse Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX LaunchCourse Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class EFXLaunchCoursePage {
	
	WebDriver driver;
	
	//private By txt_UserName = By.id("txtEMail");	
	private By lnk_LaunchYourExamFX_Course = By.linkText("Click Here to Launch Your ExamFX - Life and Health Course.");
	
	public EFXLaunchCoursePage(){
		this.driver = DriverFactory.getDriver();
	}	
	
	public ESWVerifyInformationPage clickToLaunchCourse(){		
		
		driver.findElement(lnk_LaunchYourExamFX_Course).click();		
		return new ESWVerifyInformationPage();
	}
}
