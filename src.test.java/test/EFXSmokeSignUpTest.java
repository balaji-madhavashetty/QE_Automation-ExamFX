package test;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.EFXEnrollPage;
import pageobject.EFXHomePage;
import pageobject.EFXLaunchCoursePage;
import pageobject.ESWMainMenuPage;
import pageobject.ESWVerifyInformationPage;
import pageobject.EnrollmentCompletePage;
import pageobject.PaymentPage;
import pageobject.SelectExamPage;
import pageobject.SelectLocationPage;
import pageobject.SelectPackageAndAddOnsPage;
import pageobject.SelectYourShippingMethodPage;
import pageobject.SetUpYourAccountPage;
import pageobject.VirtualStudyCalenderPage;

import common.DriverFactory;
import common.TestData;

/**
 * Test Class File Containing Test Cases of ExamFX Smoke Suite - New User SignUp Test Cases
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 *
 */
public class EFXSmokeSignUpTest {
	
	static WebDriver driver;
	TestData testData;
	
	EFXHomePage eFXHomePage; 
	EFXLaunchCoursePage eFXLaunchCoursePage; 
	ESWVerifyInformationPage eSWVerifyInformationPage;
	ESWMainMenuPage efxMainMenuPage;
	VirtualStudyCalenderPage virtualStudyCalenderPage;		
	EFXEnrollPage eFXEnrollPage;
	SelectExamPage selectExamPage;
	SelectLocationPage selectLocationPage;
	SelectPackageAndAddOnsPage selectPackageAndAddOnsPage;
	SetUpYourAccountPage setUpYourAccountPage;	
	SelectYourShippingMethodPage selectYourShippingMethodPage;
	PaymentPage paymentPage;
	EnrollmentCompletePage enrollmentCompletePage;
	
	@BeforeClass
	public void setUp(){		
		driver = DriverFactory.setUpDriver();
		testData = new TestData();		
	}
	
	/**
	 * New User SignUp Test Case with complete flow
	 * 
	 * @TODO: More Assertions to be Added for Each Page & Splitted into test Cases
	 * 
	 * @author Balaji.M
	 * @Date Created: 15-Sept-2016	 
	 */
	@Test
	private void testSignUpNewUser() throws Exception {
		
		Reporter.log("Executing Test Case:testSignUpNewUser()");
		eFXHomePage = new EFXHomePage();
		eFXEnrollPage = eFXHomePage.clickSignUpButton();
		selectExamPage = eFXEnrollPage.clickContinue();
		selectExamPage.clickOnNewStudent();
		selectLocationPage = selectExamPage.clickOnCourseName(testData.get("courseName"));
		selectLocationPage.selectSateforEnrollment(testData.get("state"));
		selectPackageAndAddOnsPage = selectLocationPage.clickOnContinue();	
		selectPackageAndAddOnsPage.clickOnContinue();	
		setUpYourAccountPage = selectPackageAndAddOnsPage.clickContinueAfterAddOns();		
		setUpYourAccountPage.clickOnAccept();			
		
		//Basic information
		setUpYourAccountPage.enterFirstName(testData.get("firstName"));		
		setUpYourAccountPage.enterLastName(testData.get("lastName"));	
		setUpYourAccountPage.enterEMailAddress(testData.get("eMailAddress"));	
		setUpYourAccountPage.enterConfirmEmailAddress(testData.get("confirmEmailAddress"));	
		setUpYourAccountPage.enterPhoneNumber(testData.get("phoneNumber"));	
		setUpYourAccountPage.enterFaxNumber(testData.get("faxNumber"));
		setUpYourAccountPage.enterPassword(testData.get("password"));
		setUpYourAccountPage.enterConfirmPassword(testData.get("confirmPassword"));	
		setUpYourAccountPage.enterSSN(testData.get("SSN"));	
		
		//Residence Information
		setUpYourAccountPage.enterAddress1(testData.get("address1"));	
		setUpYourAccountPage.enterAddress2(testData.get("address2"));
		setUpYourAccountPage.enterCity(testData.get("city"));
		setUpYourAccountPage.selectSateforAddress(testData.get("state"));
		setUpYourAccountPage.enterZipCode(testData.get("zipCode"));	
		
		//Security Questions
		setUpYourAccountPage.selectSecurityQuestion1(testData.get("securityQuestion1"));			
		setUpYourAccountPage.enterSecurityAnswer1(testData.get("securityAnswer1"));				
		setUpYourAccountPage.selectSecurityQuestion2(testData.get("securityQuestion2"));		
		setUpYourAccountPage.enterSecurityAnswer2(testData.get("securityAnswer2"));		
		setUpYourAccountPage.selectHearAboutEFXRadioButton();		
		setUpYourAccountPage.enterAffiliatedCompany(testData.get("affiliatedCompany"));			
		setUpYourAccountPage.enterTitle(testData.get("title"));	
		selectYourShippingMethodPage = setUpYourAccountPage.clickOnContinue();		
		
		//Shipping Method Selection Flows
		selectYourShippingMethodPage.checkIfShippingAddressSameAsResidence();		
		selectYourShippingMethodPage.clickOnContinue();				
		selectYourShippingMethodPage.clickOKonAddressConfirmPopup();			
		paymentPage = selectYourShippingMethodPage.clickOnContinueAfterShippingMethodSelection();	
		
		//paymentPage.clickOnProcessOrder();
		
		//Payment Page Flows
		//paymentPage.enterNameOnCreditCard(testData.get("nameOnCreditCard"));
		paymentPage.enterCreditCardNumber(testData.get("creditCardNumber"));	
		paymentPage.enterExpirationDate(testData.get("expirationDate"));	
		paymentPage.enterCVV(testData.get("CVV"));		
		paymentPage.enterNameOnCreditCard(testData.get("nameOnCreditCard"));		
		enrollmentCompletePage = paymentPage.clickOnProcessOrder();		
		
		//Enrollment Confirmation Flows
		efxMainMenuPage = enrollmentCompletePage.clickOnNextOnVerifyInformationPage();		
		enrollmentCompletePage.clickOnLaunchCourse();	
		efxMainMenuPage = enrollmentCompletePage.clickOnNextOnVerifyInformationPage();			
	}	
	
	@AfterClass
	public void tearDown(){		
		DriverFactory.shutDownDriver();
	}
}
