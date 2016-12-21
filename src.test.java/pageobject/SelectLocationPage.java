package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment - SelectLocationPage.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment SelectLocationPage.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class SelectLocationPage {
	
	WebDriver driver;
	
	public SelectLocationPage(){
		this.driver = DriverFactory.getDriver();
	}
		
	private By hed_selectYourLocationPage = By.xpath("//div[@class='orange-bar']");	
	private By bcm_SelectYourLocationPageBreadCrumb = By.xpath("//div[@class='breadcrumb']");	
	private By lbl_selectYourLocation = By.xpath("//div[@class='section-1']/p");	
	private By drp_Location = By.id("Content_ddlLocation");	
	private By btn_Continue = By.id("Content_lbnContinue");
	
	public String getPageHeading()
	{
		System.out.println("******************getPageHeading()");
		
		String heading = driver.findElement(hed_selectYourLocationPage).getText();
		
		System.out.println("**heading:" + heading);
		
		return heading;
	}
	
	public boolean isBreadCrumbDisplayed()
	{
		System.out.println("******************isBreadCrumbDisplayed()");
		
		boolean flag = driver.findElement(bcm_SelectYourLocationPageBreadCrumb).isDisplayed();
		
		return flag;
	}
	
	public String getLabelofSelectYourState()
	{
		System.out.println("******************getLabelofSelectYourState()");
		
		String label = driver.findElement(lbl_selectYourLocation).getText();
		
		System.out.println("**heading:" + label);
		
		return label;
	}
	
	public boolean isSelectYourStateDropDownDisplayed() throws Exception{
		
		System.out.println("******************isSelectYourStateDropDownDisplayed()");
		
		boolean flag = false;
		flag = driver.findElement(drp_Location).isDisplayed();
		
		return flag;
	}
	
	public boolean isStateDisplayedinSelectYourStateDropDown(String state) throws Exception{
		
		System.out.println("******************isStateDisplayedinSelectYourStateDropDown():" + state);
		
		boolean flag = false;
		
		try{
			Select dropdown = new Select(driver.findElement(drp_Location));
			List<WebElement> statesList = dropdown.getOptions();
			statesList.contains(state.toString());
			dropdown.selectByVisibleText(state);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public SelectLocationPage selectSateforEnrollment(String state) throws Exception{
		
		System.out.println("******************selectSateforEnrollment():" + state);
		
		try{
			//driver.findElement(drp_Location).click();
			Select dropdown = new Select(driver.findElement(drp_Location));
			//dropdown.selectByIndex(1);
			//dropdown.selectByValue(state);
			dropdown.selectByVisibleText(state);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new SelectLocationPage();
	}
	
	public boolean isContinueButtonDisplayed(){	
		
		System.out.println("******************isContinueButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_Continue).isDisplayed();		
		
		return flag;	
	}	
	
	public SelectPackageAndAddOnsPage clickOnContinue(){	
		
		System.out.println("******************clickOnContinue()");

		driver.findElement(btn_Continue).click();			
		
		return new SelectPackageAndAddOnsPage();		
	}		
	
}
