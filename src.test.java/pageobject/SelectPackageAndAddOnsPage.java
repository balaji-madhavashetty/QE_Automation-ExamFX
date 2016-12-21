package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment - SelectPackageAndAddOnsPage.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment - SelectPackageAndAddOnsPage.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class SelectPackageAndAddOnsPage {
	
	WebDriver driver;
	
	public SelectPackageAndAddOnsPage(){
		this.driver = DriverFactory.getDriver();
	}		
	
	//private By btn_Continue = By.id("Content_lbnContinue");  //.//*[@id='Content_lbnContinue']
//	private By btn_Continue_BeforeAdOnsPage = By.xpath(".//*[@id='Content_lbnContinue']");
//	private By btn_Continue_AfterAdOnsPage = By.xpath(".//*[@id='Content_lbnContinue']");
	
	private By hed_selectYourPackagePage = By.xpath("//div[@class='orange-bar']");	
	private By bcm_SelectYourPackagePageBreadCrumb = By.xpath("//div[@class='breadcrumb']");		
	
	private By btn_Continue_BeforeAdOnsPage = By.id("Content_lbnContinue");	
	private By btn_Continue_AfterAdOnsPage = By.id("Content_lbnContinue");	
	
	public String getPageHeading()
	{
		System.out.println("******************getPageHeading()");
		
		String heading = driver.findElement(hed_selectYourPackagePage).getText();
		
		System.out.println("**heading:" + heading);
		
		return heading;
	}
	
	public boolean isBreadCrumbDisplayed()
	{
		System.out.println("******************isBreadCrumbDisplayed()");
		
		boolean flag = driver.findElement(bcm_SelectYourPackagePageBreadCrumb).isDisplayed();
		
		return flag;
	}
	
	public void radioButtons()
	{		
		System.out.println("******************radioButtons()");
		
		List<WebElement> packageRadioButtons = driver.findElements(By.name("ctl00$Content$Packages"));
		
		for(int i=0; i<packageRadioButtons.size(); i++){
			
			boolean flag = packageRadioButtons.get(i).isSelected();
			System.out.println("******************packageRadioButtons.get(i).isSelected()" + flag );
									
			System.out.println("******************packageRadioButtons.get(i).getTagName()" + packageRadioButtons.get(i).getTagName() );
			System.out.println("******************packageRadioButtons.get(i).getText()" + packageRadioButtons.get(i).getText() );
			
			System.out.println("******************packageRadioButtons.get(i).getSize()" + packageRadioButtons.get(i).getSize() );
			
			System.out.println("******************packageRadioButtons.get(i).getAttribute()" + packageRadioButtons.get(i).getAttribute("id"));
			
			System.out.println("******************CLICKING ");
			//packageRadioButtons.get(i).click();		
			
			
			String str = "ExamFX Flex Package";
		    // (1) Find the element that has the label text as its text
		   // IWebElement labelForButton = commondriver.FindElement(By.XPath("//label[text()='ExamFX Advantage Package Light - Life and Health ($194.95)']"));
			 WebElement labelForButton = driver.findElement(By.xpath("//label[contains(text(),str)]"));

		    // (2) Get the FOR attribute from that element
		    String forAttribute = labelForButton.getAttribute("for");
		    
		    System.out.println("******************forAttribute: " + forAttribute);

		    // (3) Find the input that has an id equal to that FOR attribute
		    WebElement radioElement = driver.findElement(By.id(forAttribute));

		    // (4) Click that input element
		    radioElement.click();		
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
	}
	
	public boolean isContinueButtonDisplayed(){	
		
		boolean flag = driver.findElement(btn_Continue_BeforeAdOnsPage).isDisplayed();
		
		return flag;
	}	
	
	public void clickOnContinue(){		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(btn_Continue_BeforeAdOnsPage));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(btn_Continue_BeforeAdOnsPage).click();
	}	
	
	public SetUpYourAccountPage clickContinueAfterAddOns(){
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			wait.until(ExpectedConditions.elementToBeClickable(btn_Continue_AfterAdOnsPage));
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(btn_Continue_AfterAdOnsPage).click();
		
		return new SetUpYourAccountPage();
	}		
}
