package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import common.DriverFactory;

/**
 * PageObject Class of ExamFX EWS VirtualStudyCalender Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX EWS VirtualStudyCalender Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class VirtualStudyCalenderPage {
	
	WebDriver driver;
	
	public VirtualStudyCalenderPage(){
		this.driver = DriverFactory.getDriver();
	}	
	
	private By menu_MainMenu = By.xpath(".//*[@id='MainMenuMasterPageLink']");
	private By menu_MyAccount = By.xpath(".//*[@id='MyAccountMasterPageLink']");
	private By menu_ContactUS = By.xpath(".//*[@id='ContactUsMasterPageLink']");
	//private By btn_Next = By.ByClassName(btn-next);
	
	//private WebElement btn_Next = driver.findElement(By.className("btn-next"));
	
	
	public ESWMainMenuPage clickOnMainMenu(){
		driver.findElement(menu_MainMenu).click();
		
		return new ESWMainMenuPage();
	}
	
	public void clickOnMyAccount(){
		driver.findElement(menu_MyAccount).click();
	}
	
	public void clickOnContactUS(){
		driver.findElement(menu_ContactUS).click();
	}	
	
	public void clickOnNext(){
		driver.findElement(By.className("btn-next")).click();
	}
	
}
