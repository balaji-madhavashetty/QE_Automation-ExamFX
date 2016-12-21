package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
public class EFXSmokeTest1 {
	
	static WebDriver driver;
	TestData testData;
	SoftAssert softAssert;
	
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
	 * test_efx_116_LaunchApplication
	 * 
	 * @author Balaji.M
	 * @Date Created: 15-Sept-2016	 
	 */
	@Test
	private void test_efx_116_LaunchApplication() throws Exception {
		
		boolean flag = false;
		softAssert = new SoftAssert();
		
		Reporter.log("Executing Test Case: test_efx_116_LaunchApplication()");
		
		eFXHomePage = new EFXHomePage();
		
		flag = eFXHomePage.isExamFXLogoDisplayed();
		softAssert.assertTrue(flag, "ExamFX Logo is NOT displayed on ExamFX Home Page");
		
		flag = eFXHomePage.isLeftNavigationPaneDisplayed();
		softAssert.assertTrue(flag, "Left Navigation Pane is NOT displayed on ExamFX Home Page");			
		
		String menuItemsString = eFXHomePage.getMenuItemsOfLeftNavigationPane();
		
		flag = (menuItemsString.contains("ABOUT US") && 
				menuItemsString.contains("COURSE TOUR") &&
				menuItemsString.contains("INSURANCE") && 
				menuItemsString.contains("SECURITIES") &&
				menuItemsString.contains("CONTINUING EDUCATION") &&
				menuItemsString.contains("EMPLOYERS") &&
				menuItemsString.contains("INDIVIDUAL LEARNERS"));	
		softAssert.assertTrue(flag, "Left Navigation Pane is NOT displaying ONE or more Menu Items on ExamFX Home Page");	
		
		String signUpForExamFXLabels = eFXHomePage.getSignUpForExamFXLabels();
		signUpForExamFXLabels.contains("NEW USERS");
		signUpForExamFXLabels.contains("SIGN UP FOR EXAMFX");
		
		String loginUserLabels = eFXHomePage.getLoginUserLabels();
		flag = (loginUserLabels.contains("RETURNING USER LOGIN") &&
					loginUserLabels.contains("E-Mail Address:") &&
					loginUserLabels.contains("Password:") &&
					loginUserLabels.contains("SIGN IN") &&
					loginUserLabels.contains("FORGOT PASSWORD?") &&
					loginUserLabels.contains("MANAGERS") &&
					loginUserLabels.contains("MANAGE YOUR STUDENTS") &&
					loginUserLabels.contains("VOUCHER CODE") &&
					loginUserLabels.contains("REDEEM"));
		softAssert.assertTrue(flag, "Left Navigation Pane is NOT displaying ONE or more Menu Items on ExamFX Home Page");	
		
		flag = eFXHomePage.isEMailAddressFieldDisplayed();
		softAssert.assertTrue(flag, "EMail Address Input Field is NOT displayed on ExamFX Home Page");
		
		flag = eFXHomePage.isPasswordFieldDisplayed();
		softAssert.assertTrue(flag, "Password Input Field is NOT displayed on ExamFX Home Page");
		
		flag = eFXHomePage.isForgotPasswordButtonDisplayed();
		softAssert.assertTrue(flag, "Forgot Password Input Field is NOT displayed on ExamFX Home Page");
		
		flag = eFXHomePage.isSignInButtonDisplayed();
		softAssert.assertTrue(flag, "SignIN Button is NOT displayed on ExamFX Home Page");
		
		flag = eFXHomePage.isForgotPasswordButtonDisplayed();
		softAssert.assertTrue(flag, "Forgot Password Button is NOT displayed on ExamFX Home Page");
		
		flag = eFXHomePage.isRedeemButtonDisplayed();
		softAssert.assertTrue(flag, "Redeem Button is NOT displayed on ExamFX Home Page");
		
		flag = eFXHomePage.isManageYourStudentsLinkDisplayed();
		softAssert.assertTrue(flag, "Manage Your Students Link is NOT displayed on ExamFX Home Page");		
		
		softAssert.assertAll();
	}	
	
	/**
	 * test_efx_116_LaunchApplication
	 * 
	 * @author Balaji.M
	 * @Date Created: 15-Sept-2016	 
	 */
	@Test
	private void test_VerifyEnrollPage() throws Exception {
		
		boolean flag = false;
		softAssert = new SoftAssert();
		
		Reporter.log("Executing Test Case: test_VerifyEnrollPage()");
		
		eFXHomePage = new EFXHomePage();
		eFXEnrollPage = eFXHomePage.clickSignUpButton();
		
		String pageHeading = eFXEnrollPage.getPageHeading();
		pageHeading.equalsIgnoreCase("Enroll");
		
		flag = eFXEnrollPage.isBreadCrumbDisplayed();
		softAssert.assertTrue(flag, "Enroll Page BreadCrumb is NOT displayed on New User SignUp - Enroll Page");
		
		String discountCodeLabel = eFXEnrollPage.getDiscountCodeLabel();
		discountCodeLabel.contains("Discount Code");
		discountCodeLabel.contains("Found on promotional flyers or in the body of promotional e-mail messages.");
		
		String managerEmailAddressLabel = eFXEnrollPage.getManagerEMailAddressLabel();
		managerEmailAddressLabel.contains("Manager E-Mail Address");
		managerEmailAddressLabel.contains("Provided to you by a manager or recruiter that has directed you to this site.");
		
		flag = eFXEnrollPage.isDiscountCodeFieldPresent();
		softAssert.assertTrue(flag, "DiscountCode Input Field is NOT Present on Enroll Page");
		
		flag = eFXEnrollPage.isContinueButtonDisplayed();
		softAssert.assertTrue(flag, "Continue Button is NOT Dispalyed on Enroll Page");
		
		softAssert.assertAll();
		
	}	
	
	/**
	 * test_VerifySelectExamPage
	 * 
	 * @author Balaji.M
	 * @Date Created: 15-Sept-2016	 
	 */
	@Test
	private void test_VerifySelectExamPage() throws Exception {
		
		boolean flag = false;
		softAssert = new SoftAssert();
		
		Reporter.log("Executing Test Case: test_VerifySelectExamPage()");
		
		eFXHomePage = new EFXHomePage();
		eFXEnrollPage = eFXHomePage.clickSignUpButton();		
		selectExamPage = eFXEnrollPage.clickContinue();
		
		String pageHeading = selectExamPage.getPageHeading();
		pageHeading.contains("SELECT AN EXAM");
		
		flag = selectExamPage.isBreadCrumbDisplayed();
		softAssert.assertTrue(flag, "BreadCrub is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isNewStudentButtonDisplayed();
		softAssert.assertTrue(flag, "NewStudent Button is NOT Displayed on Select An Exam Page");		
		
		flag = selectExamPage.isEMailAddressLabelDisplayed();
		softAssert.assertTrue(flag, "EMailAddress Label is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isEMailAddressFieldDisplayed();
		softAssert.assertTrue(flag, "EMailAddress Input Field is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isPasswordLabelDisplayed();
		softAssert.assertTrue(flag, "Password Label is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isPasswordFieldDisplayed();
		softAssert.assertTrue(flag, "Password Input Field is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isLoginButtonDisplayed();
		softAssert.assertTrue(flag, "LOGIN Button is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isNewPasswordDisplayed();
		softAssert.assertTrue(flag, "NewPassword is NOT Displayed on Select An Exam Page");
		
		selectExamPage = selectExamPage.clickOnNewStudent();
		
		pageHeading = selectExamPage.getPageHeading();
		softAssert.assertTrue(pageHeading.contains("SELECT AN EXAM"), "Select an Exam Page Heading is NOT displayed on ExamFX Home Page");	
		
		flag = selectExamPage.isCoursesHeadingDisplayed();
		softAssert.assertTrue(flag, "Courses Heading is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.areAllInsuranceCoursesLinksDisplayed();
		softAssert.assertTrue(flag, "One or More Links of Insurance Courses are NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.areAllSecuritiesCoursesLinksDisplayed();
		softAssert.assertTrue(flag, "One or More Links of Securities Courses are NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isCENextLevelLinkDisplayed();
		softAssert.assertTrue(flag, "Next Level Link of Continuining Education is NOT Displayed on Select An Exam Page");
		
		flag = selectExamPage.isLinkforCourseDisplayed("Life and Health Insurance");
		softAssert.assertTrue(flag, "Life and Health Insurance" + "Course Link is NOT Displayed on Select An Exam Page");
		
		softAssert.assertAll();		
	}	
	
	/**
	 * test_VerifySelectYourLocationPage
	 * 
	 * @author Balaji.M
	 * @Date Created: 15-Sept-2016	 
	 */
	@Test
	private void test_VerifySelectYourLocationPage() throws Exception {
		
		boolean flag = false;
		softAssert = new SoftAssert();
		
		Reporter.log("Executing Test Case: test_VerifySelectYourLocationPage()");
		
		eFXHomePage = new EFXHomePage();
		eFXEnrollPage = eFXHomePage.clickSignUpButton();		
		selectExamPage = eFXEnrollPage.clickContinue();
		selectExamPage = selectExamPage.clickOnNewStudent();
		selectLocationPage = selectExamPage.clickOnCourseName(testData.get("courseName"));
		
		String pageHeading = selectLocationPage.getPageHeading();
		pageHeading.contains("SELECT YOUR LOCATION");
		
		flag = selectLocationPage.isBreadCrumbDisplayed();
		softAssert.assertTrue(flag, "BreadCrub is NOT Displayed on Select Your Location Page");
		
		String dropdownLabel = selectLocationPage.getLabelofSelectYourState();
		dropdownLabel.contains("In which state will you earn your license?");
		
		flag = selectLocationPage.isSelectYourStateDropDownDisplayed();
		softAssert.assertTrue(flag, "Select Your State DropDown is NOT Displayed on Select Your Location Page");
		
		//FAILING
		flag = selectLocationPage.isStateDisplayedinSelectYourStateDropDown("California");
		softAssert.assertTrue(flag, "California " + "State is NOT Displayed on Select Your Location Page");
		
		flag = selectLocationPage.isContinueButtonDisplayed();
		softAssert.assertTrue(flag, "Continue Button is NOT Displayed on Select Your Location Page");
			
		softAssert.assertAll();		
	}	
	
	/**
	 * test_VerifySelectYourPackagePage
	 * 
	 * @author Balaji.M
	 * @Date Created: 15-Sept-2016	 
	 */
	@Test
	private void test_VerifySelectYourPackagePage() throws Exception {
		
		boolean flag = false;
		softAssert = new SoftAssert();
		
		Reporter.log("Executing Test Case: test_VerifySelectYourPackagePage()");
		
		eFXHomePage = new EFXHomePage();
		eFXEnrollPage = eFXHomePage.clickSignUpButton();		
		selectExamPage = eFXEnrollPage.clickContinue();
		selectExamPage = selectExamPage.clickOnNewStudent();
		selectLocationPage = selectExamPage.clickOnCourseName(testData.get("courseName"));
		selectLocationPage.selectSateforEnrollment(testData.get("state"));
		selectPackageAndAddOnsPage = selectLocationPage.clickOnContinue();			
		
		selectPackageAndAddOnsPage.radioButtons();		
			
		softAssert.assertAll();		
	}	
	
	@AfterClass
	public void tearDown(){		
		DriverFactory.shutDownDriver();
	}
}
