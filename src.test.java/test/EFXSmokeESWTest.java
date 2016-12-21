package test;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageobject.EFXHomePage;
import pageobject.EFXLaunchCoursePage;
import pageobject.ESWMainMenuPage;
import pageobject.ESWVerifyInformationPage;
import pageobject.VirtualStudyCalenderPage;

import common.DriverFactory;
import common.TestData;

/**
 * Test Class File Containing Test Cases of ExamFX Smoke Suite - Existing User SignIn & Launch Course Test Cases
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 *
 */
public class EFXSmokeESWTest {
	
	static WebDriver driver;
	TestData testData;
	
	EFXHomePage eFXHomePage; 
	EFXLaunchCoursePage eFXLaunchCoursePage; 
	ESWVerifyInformationPage eswVerifyInformationPage;
	ESWMainMenuPage eswMainMenuPage;
	VirtualStudyCalenderPage virtualStudyCalenderPage;
	
	@BeforeClass
	public void setUp(){		
		driver = DriverFactory.setUpDriver();
		testData = new TestData();		
		
		eFXHomePage = new EFXHomePage();
		eFXLaunchCoursePage = new EFXLaunchCoursePage();
		eswVerifyInformationPage = new ESWVerifyInformationPage();
		eswMainMenuPage = new ESWMainMenuPage();
		virtualStudyCalenderPage = new VirtualStudyCalenderPage();		
	}
	
	/**
	 * Existing User Login & Launch The Course Test Case with complete flow
	 * 
	 *@TODO: More Assertions to be Added for Each Page & Splitted into test Cases
	 * 
	 * @author Balaji.M
	 * @Date Created: 15-Sept-2016	 
	 */	
	@Test
	private void testLoginToExamFX() throws Exception {
		
		String strUserName = testData.get("login.username");
		String strPassWord = testData.get("login.password");
		
		Reporter.log("UserName/Password ="+ strUserName +"/"+ strPassWord);
		eFXLaunchCoursePage = eFXHomePage.loginExamFX(strUserName,strPassWord);		
		eswVerifyInformationPage = eFXLaunchCoursePage.clickToLaunchCourse();		
		eswMainMenuPage = eswVerifyInformationPage.clickOnNext();		
		
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window & // perform operations on popup		
		Thread.sleep(10000);
		driver.switchTo().window(parentWindowHandler);  // switch back to parent window		
		Thread.sleep(10000);
		
		eswMainMenuPage.clickOnMainMenu();
		eswMainMenuPage.clickOnContactUs();
		eswMainMenuPage.clickOnMainMenu();
		eswMainMenuPage.clickOnMyExamFx();
		eswMainMenuPage.clickOnMainMenu();		

		virtualStudyCalenderPage = eswMainMenuPage.clickOnVirtualStudyCalender();		
		eswMainMenuPage = virtualStudyCalenderPage.clickOnMainMenu();
		
//		eswMainMenuPage.clickOnStudyByTopic();	
//		eswMainMenuPage.clickOnMainMenu();
		
		eswMainMenuPage.clickOnSimulateYourExam();	
		eswMainMenuPage.clickOnMainMenu();
		
		eswMainMenuPage.clickOnFocussedReview();	
		eswMainMenuPage.clickOnMainMenu();
		
		eswMainMenuPage.clickOnScheduleYourRealExam();
		eswMainMenuPage.clickOnMainMenu();
		
		eswMainMenuPage.clickOnGuaranteeExam();
		eswMainMenuPage.clickOnMainMenu();
		
		eswMainMenuPage.clickOnadditionalStudyTools();	
		eswMainMenuPage.clickOnMainMenu();		
		eswMainMenuPage.clickOnStudyByTopic();	
		eswMainMenuPage.clickOnMainMenu();
		eswMainMenuPage.clickOnLogout();
		
		virtualStudyCalenderPage = eswMainMenuPage.clickOnVirtualStudyCalender();	
		virtualStudyCalenderPage.clickOnNext();
		virtualStudyCalenderPage.clickOnMainMenu();		
		
		eswMainMenuPage.clickOnLogout();
		
		//Alert alert = driver.switchTo().alert();
		//alert.accept();	
	}	
	
	@AfterClass
	public void tearDown(){
		DriverFactory.shutDownDriver();
	}
}
