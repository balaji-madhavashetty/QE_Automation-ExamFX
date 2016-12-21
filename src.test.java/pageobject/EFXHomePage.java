package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX Home/Login Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX Home Page
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 *
 */
public class EFXHomePage {
	
	WebDriver driver;
	
	public EFXHomePage(){
		this.driver = DriverFactory.getDriver();
	}	
	
	private By txt_UserName = By.id("txtEMail");
	private By txt_password = By.id("txtPassword");
	private By btn_SignIn = By.id("BtnSignIn");
	private By btn_ForgotPassword = By.id("lnkForgotPassword");
	private By btn_SignUp = By.id("lbEnrollBegin");
	//
	private By loc_examFXLogo = By.xpath("//div[@class='logo']");
	private By frm_LeftNavigation = By.xpath("//div/ul[@class='pn-navigation']");
	private By btn_newUserSignUp = By.id("lbEnrollBegin");
	private By lbl_newUserSignUp = By.xpath("//div[@class='new-user-box']");
	private By lbl_loginUser = By.xpath("//div[@class='login-box']");	
	
	private By tbx_emailAddress = By.id("txtEMail");
	private By tbx_passWord = By.id("txtPassword");
	private By btn_signIn = By.id("BtnSignIn");
	private By btn_forgotPassword = By.id("lnkForgotPassword");
	private By btn_redeem = By.id("lbVoucherCodeRedeem");	
	private By lnk_manageYourStudents = By.xpath("//a[text()='MANAGE YOUR STUDENTS']");

	public EFXLaunchCoursePage loginExamFX(String user, String psw){
		Reporter.log("Logging In to ExamFX with UserName:" + user);	
		
		driver.findElement(txt_UserName).sendKeys(user);
		driver.findElement(txt_password).sendKeys(psw);
		
		clickSignInButton();		
		return new EFXLaunchCoursePage();
	}
	
	public void clickSignInButton(){
		driver.findElement(btn_SignIn).click();
	}
	
	public void clickForgotPasswordButton(){
		driver.findElement(btn_ForgotPassword).click();
	}
	
	public EFXEnrollPage clickSignUpButton(){
		driver.findElement(btn_SignUp).click();
		
		return new EFXEnrollPage();
	}	
	
	
	// ExamFX Home Page - UI Elements Validations
	public boolean isExamFXLogoDisplayed(){		
		
		System.out.println("******************isExamFXLogoDisplayed()");
		
		boolean flag = driver.findElement(loc_examFXLogo).isDisplayed();
		
		return flag;
	}
	
	public boolean isLeftNavigationPaneDisplayed(){		
		
		System.out.println("******************isLeftNavigationPaneDisplayed()");
		
		boolean flag = driver.findElement(frm_LeftNavigation).isDisplayed();
		
		return flag;
	}
	
	public String getMenuItemsOfLeftNavigationPane(){		
		
		System.out.println("******************getMenuItemsOfLeftNavigationPane()");
		
		String menuItems = driver.findElement(frm_LeftNavigation).getText();
		
		System.out.println("MenuItems Of LeftNavigationPane:" + menuItems);
		
		return menuItems;
	}
	
	public String getSignUpForExamFXLabels(){	
		
		System.out.println("******************getSignUpForExamFXLabels()");
		
		String signUpForExamFXLabels = driver.findElement(lbl_newUserSignUp).getText();
		
		System.out.println("SignUp For ExamFX Labels:" + signUpForExamFXLabels);
		
		return signUpForExamFXLabels;
	}
	
	public boolean isSignUpForExamFXButtonDisplayed(){		
		
		System.out.println("******************isSignUpForExamFXButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_newUserSignUp).isDisplayed();
		
		return flag;
	}
	
	public String getLoginUserLabels(){	
		
		System.out.println("******************getLoginUserLabels()");
		
		String loginUserLabels = driver.findElement(lbl_loginUser).getText();
		
		System.out.println("Login User Labels:" + loginUserLabels);
		
		return loginUserLabels;
	}
	
	public boolean isEMailAddressFieldDisplayed(){	
		
		System.out.println("******************isEMailAddressFieldDisplayed()");
		
		boolean flag = driver.findElement(tbx_emailAddress).isDisplayed();
		
		return flag;
	}
	
	public boolean isPasswordFieldDisplayed(){
		
		System.out.println("******************isPasswordFieldDisplayed()");
		
		boolean flag = driver.findElement(tbx_passWord).isDisplayed();
		
		return flag;
	}
	
	public boolean isSignInButtonDisplayed(){	
		
		System.out.println("******************isSignInButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_signIn).isDisplayed();
		
		return flag;
	}
	
	public boolean isForgotPasswordButtonDisplayed(){
		
		System.out.println("******************isForgotPasswordButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_forgotPassword).isDisplayed();
		
		return flag;
	}
	
	public boolean isManageYourStudentsLinkDisplayed(){	
		
		System.out.println("******************isManageYourStudentsLinkDisplayed()");
		
		boolean flag = driver.findElement(lnk_manageYourStudents).isDisplayed();
		
		return flag;
	}
	
	public boolean isRedeemButtonDisplayed(){		
		
		System.out.println("******************isRedeemButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_redeem).isDisplayed();
		
		return flag;
	}
	
	
}
