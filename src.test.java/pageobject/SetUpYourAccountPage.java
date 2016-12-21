package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment - SetUp Your Account Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment - SetUp Your Account Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class SetUpYourAccountPage {
	
	WebDriver driver;
	
	public SetUpYourAccountPage(){
		this.driver = DriverFactory.getDriver();
	}		
	
	private By btn_iAccept = By.id("Content_btnAccept");
	private By btn_iDecline = By.id("Content_btnDecline");
	
	private By txt_FirstName = By.id("Content_txtFirstName");
	private By txt_LastName = By.id("Content_txtLastName");
	private By txt_EMailAddress = By.id("Content_txtEMail");
	private By txt_ConfirmEMailAddress = By.id("Content_txtEMailConfirm");
	private By txt_PhoneNumber = By.id("Content_txtPhone");
	private By txt_FAXNumber = By.id("Content_txtFax");
	private By txt_Password = By.id("Content_txtPassword");
	private By txt_ConfirmPassword = By.id("Content_txtPasswordConfirm");
	private By txt_SSN = By.id("Content_txtSSN");
	private By txt_Address1 = By.id("Content_txtAddress1");
	private By txt_Address2 = By.id("Content_txtAddress2");
	private By txt_City = By.id("Content_txtCity");
	private By drp_State = By.id("Content_ddlState");
	private By txt_ZipCode = By.id("Content_txtZIP");	
	private By drp_SecQues1 = By.id("Content_SecrtyQtnDrpDwnLst");
	private By txt_SecQues1 = By.id("Content_SecrtyQtnTxtBx");
	private By drp_SecQues2 = By.id("Content_SecrtyQtnDrpDwnLst2");	
	private By txt_SecQues2 = By.id("Content_SecrtyQtnTxtBx2");
	private By txt_AffiliatedCompany = By.id("Content_txtAffiliate");
	private By txt_Title = By.id("Content_txtTitle");	
	private By rad_HearAboutEFX = By.name("ctl00$Content$rblReferredBy");	
	private By btn_Continue = By.id("Content_lbnContinue");	
	
	
	public SetUpYourAccountPage clickOnAccept(){
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(btn_iAccept));
		
		driver.findElement(btn_iAccept).click();
		
		return new SetUpYourAccountPage();
	}	
	
	public void clickOnDecline(){
		driver.findElement(btn_iDecline).click();
	}	
	
	public void enterFirstName(String firstName){		
		driver.findElement(txt_FirstName).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName){
		driver.findElement(txt_LastName).sendKeys(lastName);
	}
	
	public void enterEMailAddress(String emailAddress){
		driver.findElement(txt_EMailAddress).sendKeys(emailAddress);
	}	
	
	public void enterConfirmEmailAddress(String confirmEmailAddress){
		driver.findElement(txt_ConfirmEMailAddress).sendKeys(confirmEmailAddress);
	}
	
	public void enterPhoneNumber(String phoneNumber){
		driver.findElement(txt_PhoneNumber).sendKeys(phoneNumber);
	}
	
	public void enterFaxNumber(String faxNumber){
		driver.findElement(txt_FAXNumber).sendKeys(faxNumber);
	}
	
	public void enterPassword(String password){
		driver.findElement(txt_Password).sendKeys(password);
	}
	
	public void enterConfirmPassword(String confirmPassword){
		driver.findElement(txt_ConfirmPassword).sendKeys(confirmPassword);
	}
	
	public void enterSSN(String SSN){
		driver.findElement(txt_SSN).sendKeys(SSN);
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
	
	public void selectSecurityQuestion1(String question1) throws Exception{		
		try{
			Select dropdown = new Select(driver.findElement(drp_SecQues1));
			dropdown.selectByVisibleText(question1);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterSecurityAnswer1(String answer1){
		driver.findElement(txt_SecQues1).sendKeys(answer1);
	}
	
	public void selectSecurityQuestion2(String question2) throws Exception{		
		try{
			Select dropdown = new Select(driver.findElement(drp_SecQues2));
			dropdown.selectByVisibleText(question2);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterSecurityAnswer2(String answer2){
		driver.findElement(txt_SecQues2).sendKeys(answer2);
	}
	
	public void selectHearAboutEFXRadioButton() throws Exception{		
		try{
			
			WebElement HearAboutEFX = driver.findElement(rad_HearAboutEFX);			
			HearAboutEFX.click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void enterAffiliatedCompany(String companyName){
		driver.findElement(txt_AffiliatedCompany).sendKeys(companyName);
	}
	
	public void enterTitle(String title){
		driver.findElement(txt_Title).sendKeys(title);
	}
	
	public SelectYourShippingMethodPage clickOnContinue(){
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(btn_Continue));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(btn_Continue).click();
		
		return new SelectYourShippingMethodPage();
	}	

}
