package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX Enroll Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX Enroll Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class EFXEnrollPage {
	
	WebDriver driver;
	
	public EFXEnrollPage(){
		this.driver = DriverFactory.getDriver();
	}
		
	private By txt_discountCode = By.id("Content_txtCode");	
	private By btn_Continue = By.id("Content_lbnContinue");
	
	private By lbl_enroll = By.xpath("//div[@class='orange-bar']");	
	private By bcm_enrollPageBreadCrumb = By.xpath("//div[@class='breadcrumb']");	
	private By lbl_discountCode = By.xpath("//div[@class='section-1']/ul/li[1]");	
	private By lbl_ManagerEMailAddress = By.xpath("//div[@class='section-1']/ul/li[2]");	
		
	public String getPageHeading()
	{
		System.out.println("******************getPageHeading()");
		
		String heading = driver.findElement(lbl_enroll).getText();
		
		System.out.println("**heading:" + heading);
		
		return heading;
	}
	
	public boolean isBreadCrumbDisplayed()
	{
		System.out.println("******************isBreadCrumbDisplayed()");
		
		boolean flag = driver.findElement(bcm_enrollPageBreadCrumb).isDisplayed();
		
		return flag;
	}
	
	public String getDiscountCodeLabel()
	{
		System.out.println("******************getDiscountCodeLabel()");
		
		String discountCodeLabel = driver.findElement(lbl_discountCode).getText();
		
		System.out.println("**heading:" + discountCodeLabel);
		
		return discountCodeLabel;
	}
	
	public String getManagerEMailAddressLabel()
	{
		System.out.println("******************getManagerEMailAddressLabel()");
		
		String managerEMailAddressLabel = driver.findElement(lbl_ManagerEMailAddress).getText();
		
		System.out.println("**managerEMailAddressLabel:" + managerEMailAddressLabel);
		
		return managerEMailAddressLabel;
	}
	
	public boolean isDiscountCodeFieldPresent()
	{
		System.out.println("******************isDiscountCodeFieldPresent()");
		
		boolean flag = driver.findElement(txt_discountCode).isDisplayed();
		
		return flag;
	}
	
	public void enterDiscountCode(String discountCode)
	{
		System.out.println("******************enterDiscountCode()");
		
		driver.findElement(txt_discountCode).sendKeys(discountCode);
	}
	
	public void enterManagerEmailAddress(String managerEmailAddress)
	{
		System.out.println("******************enterManagerEmailAddress()");
		
		driver.findElement(txt_discountCode).sendKeys(managerEmailAddress);
	}
	
	public boolean isContinueButtonDisplayed()
	{
		System.out.println("******************isContinueButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_Continue).isDisplayed();		
		
		return flag;
	}
	
	public SelectExamPage clickContinue(){
		driver.findElement(btn_Continue).click();
		
		return new SelectExamPage();
	}
}
