package common;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import utils.ReadPropertyFile1;

/**
 * DriverFactory Class which Instantiates Selenium WebDriver for Different Browsers
 *  
 *@author Framework Class
 */
public class DriverFactory {
	
	static String globalPropertyFileName = "global.properties";
	static Properties  prop = new ReadPropertyFile1().readPropertyFile(globalPropertyFileName);
	
	static WebDriver driver;
	static String url = prop.getProperty("url");
	static String browser = prop.getProperty("browser");	
	static int implecitWait = Integer.parseInt(prop.getProperty("implecitWait"));
	static int pageLoadTimeOut = Integer.parseInt(prop.getProperty("pageLoadTimeOut"));
	static int timeOut = Integer.parseInt(prop.getProperty("timeOut"));
	
	
	public static WebDriver setUpDriver(){
		if (browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if (browser.equals("firefox")){
			//Below Profile is added as sendKeys is Not working for Input Type of "Number" (In Paymnet page of ExamFX
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("dom.forms.number", false);
			profile.setPreference("dom.forms.tel", false);
			driver = new FirefoxDriver(profile);
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		else if (browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		else if (browser.equals("edge")){
			//Incomplete code
			driver = new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}
		
		else if (browser.equals("safari")){
			System.setProperty("webdriver.safari.noinstall", "true"); //To stop uninstall each time
			driver = new SafariDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().setScriptTimeout(implecitWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		return driver;
	}	
	
	public static void shutDownDriver(){
		driver.close();
		driver.quit();
	}	
		
	public static WebDriver getDriver(){
		return driver;
	}
}
