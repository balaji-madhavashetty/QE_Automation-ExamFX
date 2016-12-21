package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment - SelectYourShippingMethod Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment - SelectYourShippingMethod Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class SelectYourShippingMethodPage {
	
	WebDriver driver;
	
	public SelectYourShippingMethodPage(){
		this.driver = DriverFactory.getDriver();
	}		
	
	private By chk_ShippingAddressSameAsResidence = By.id("Content_cbxSameAsBilling");	
	private By txt_FirstName = By.id("Content_txtShippingFirstName");
	private By txt_LastName = By.id("Content_txtShippingLastName");
	private By txt_Company = By.id("Content_txtShippingCompany");
	private By txt_Address1 = By.id("Content_txtShippingAddress1");
	private By txt_Address2 = By.id("Content_txtShippingAddress2");
	private By txt_City = By.id("Content_txtShippingCity");
	private By drp_State = By.id("Content_ddlShippingState");
	private By txt_ZipCode = By.id("Content_txtShippingZip");		
	private By rad_AddressType = By.name("ctl00$Content$rblAddressType");	
	private By btn_Continue = By.id("Content_lnkGetRates");		
	private By btn_ContinueAfterShippingMethodSelection = By.id("Content_lnkSubmit");	
	
	private By btn_PopUpOKButton = By.id("Content_btnProceed");	
	
	public void checkIfShippingAddressSameAsResidence() throws Exception{		
		try{
			
			WebElement ShippingAddressSameAsResidence = driver.findElement(chk_ShippingAddressSameAsResidence);			
			ShippingAddressSameAsResidence.click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterFirstName(String firstName){		
		driver.findElement(txt_FirstName).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName){
		driver.findElement(txt_LastName).sendKeys(lastName);
	}	
	
	public void enterCompany(String company){
		driver.findElement(txt_Company).sendKeys(company);
	}	

	public void enterAddress1(String address1){
		driver.findElement(txt_Address1).sendKeys(address1);
	}
	
	public void enterAddress2(String address2){
		driver.findElement(txt_Address2).sendKeys(address2);
	}
	
	public void enterCity(String city){
		driver.findElement(txt_City).sendKeys(city);
	}
	
	public void selectSateforAddress(String state) throws Exception{		
		try{
			Select dropdown = new Select(driver.findElement(drp_State));
			dropdown.selectByVisibleText(state);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterZipCode(String zipCode){
		driver.findElement(txt_ZipCode).sendKeys(zipCode);
	}	
	
	public void selectAddressType() throws Exception{		
		try{
			
			WebElement AddressType = driver.findElement(rad_AddressType);			
			AddressType.click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void clickOnContinue(){
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(btn_Continue));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(btn_Continue).click();
	}	
	
	public void clickOKonAddressConfirmPopup(){
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(btn_PopUpOKButton));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(btn_PopUpOKButton).click();
	}
	
	public PaymentPage clickOnContinueAfterShippingMethodSelection(){
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(btn_ContinueAfterShippingMethodSelection));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(btn_ContinueAfterShippingMethodSelection).click();
		
		return new PaymentPage();
	}	
}
