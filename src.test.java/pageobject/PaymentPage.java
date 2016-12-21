package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment PaymentPage Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment PaymentPage Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class PaymentPage {
	
	WebDriver driver;
	
	public PaymentPage(){
		this.driver = DriverFactory.getDriver();
	}		
	
	//private By txt_CreditCardNumber = By.id("credit-card-number");
	//private By txt_CreditCardNumber = By.className("card-field");
	//private By txt_CreditCardNumber = By.xpath("//input/@type/@placeholder='Card Number'");	
	//private By txt_CreditCardNumber = By.xpath("//input/@type");
	private By txt_CreditCardNumber = By.xpath("//input/[@type='tel']");	
	private By txt_ExpirationDate = By.xpath("//input/@type/@placeholder='Expiration Date'");	
	private By txt_CVV = By.className("cvv card-field");
	private By txt_NameOnCard = By.id("cvv card-field");
	private By btn_ProcessOrder = By.id("btnSubmit");		
	
	public void enterCreditCardNumber(String creditCardNumber){	
		
		System.out.println("***********enterCreditCardNumber()");		
		System.out.println("***********txt_CreditCardNumber Element Status isDisplayed:"+ driver.findElement(txt_CreditCardNumber).isDisplayed());
		System.out.println("***********txt_CreditCardNumber Element Status isEnabled:"+ driver.findElement(txt_CreditCardNumber).isEnabled());
		System.out.println("***********txt_CreditCardNumber Element Status isSelected:"+ driver.findElement(txt_CreditCardNumber).isSelected());
		
		driver.findElement(txt_CreditCardNumber).clear();
		driver.findElement(txt_CreditCardNumber).click();
		driver.findElement(txt_CreditCardNumber).sendKeys(creditCardNumber);
	}	
	
	public void enterExpirationDate(String expirationDate){		
		driver.findElement(txt_ExpirationDate).clear();
		driver.findElement(txt_ExpirationDate).click();
		driver.findElement(txt_ExpirationDate).sendKeys(expirationDate);
	}	
	
	public void enterCVV(String cVV){	
		driver.findElement(txt_CVV).clear();
		driver.findElement(txt_CVV).click();
		driver.findElement(txt_CVV).sendKeys(cVV);
	}	
	
	public void enterNameOnCreditCard(String nameOnCreditCard){		
		driver.findElement(txt_NameOnCard).sendKeys(nameOnCreditCard);
	}	
	
	public EnrollmentCompletePage clickOnProcessOrder(){
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(btn_ProcessOrder));
		
		driver.findElement(btn_ProcessOrder).click();
		
		return new EnrollmentCompletePage();
	}	
}
