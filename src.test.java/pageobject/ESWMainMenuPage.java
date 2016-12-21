package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX-ESW Page(Post Login of Existing User)
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX-ESW Page
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class ESWMainMenuPage {
	
	WebDriver driver;
	
	public ESWMainMenuPage(){
		this.driver = DriverFactory.getDriver();
	}	
	
	private By menu_MainMenu = By.id("ctl00_navigation_MainMenuMasterPageLink");
	private By menu_MyExamFx = By.id("ctl00_navigation_MyExamFxMasterPageLink");
	private By menu_ContactUs = By.id("ctl00_navigation_ContactUsMasterPageLink");
	private By menu_Logout = By.id("ctl00_navigation_lnkLogout");
	
	private By virtualStudyCalendar = By.xpath(".//*[@id='ctl00_content_FeatureRptr_ctl00_feature_']");
	private By studyByTopic = By.xpath(".//*[@id='ctl00_content_FeatureRptr_ctl01_feature_']");
	private By simulateYourExam = By.xpath(".//*[@id='ctl00_content_FeatureRptr_ctl02_feature_']");
	private By focussedReview = By.xpath(".//*[@id='ctl00_content_FeatureRptr_ctl03_feature_']");
	private By scheduleYourRealExam = By.xpath(".//*[@id='ctl00_content_FeatureRptr_ctl04_feature_']");
	private By guaranteeExam = By.xpath(".//*[@id='ctl00_content_FeatureRptr_ctl05_feature_']");
	private By additionalStudyTools = By.xpath(".//*[@id='ctl00_content_FeatureRptr_ctl06_feature_']");
	
	public ESWMainMenuPage clickOnMainMenu(){
		driver.findElement(menu_MainMenu).click();
		
		return this;
	}
	
	public ESWMainMenuPage clickOnMyExamFx(){
		driver.findElement(menu_MyExamFx).click();
		
		return this;
	}
	
	public ESWMainMenuPage clickOnContactUs(){
		driver.findElement(menu_ContactUs).click();
		
		return this;
	}
	
	public void clickOnLogout(){
		driver.findElement(menu_Logout).click();
	}	
	
	public VirtualStudyCalenderPage clickOnVirtualStudyCalender(){
		driver.findElement(virtualStudyCalendar).click();
		
		return new VirtualStudyCalenderPage();
	}	
	
	public void clickOnStudyByTopic(){
		driver.findElement(studyByTopic).click();
	}	
	
	public void clickOnSimulateYourExam(){
		driver.findElement(simulateYourExam).click();
	}	
	
	public void clickOnFocussedReview(){
		driver.findElement(focussedReview).click();
	}	
	
	public void clickOnScheduleYourRealExam(){
		driver.findElement(scheduleYourRealExam).click();
	}	
	
	public void clickOnGuaranteeExam(){
		driver.findElement(guaranteeExam).click();
	}	
	
	public void clickOnadditionalStudyTools(){
		driver.findElement(additionalStudyTools).click();
	}	

}
