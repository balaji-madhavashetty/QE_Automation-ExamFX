package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ReadProperty;
import java.util.Properties;

public class CommonMethods {
	WebDriver driver;
	public static String pfileName = "testData.properties";
	public static Properties  prop = new ReadProperty().readPropertyFile(pfileName);
	
	public CommonMethods (){
		this.driver = DriverFactory.getDriver();
	}
	
	public void waitForPageTitle(String pageTitle){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(pageTitle));
	}
	
	public void waitForElementPresent(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
}
