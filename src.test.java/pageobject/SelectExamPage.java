package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import common.DriverFactory;

/**
 * PageObject Class of ExamFX New User Enrollment - SelectExam Page.
 * This class contains methods to perform Actions & Validations on UI Elements of ExamFX New User Enrollment SelectExam Page.
 * 
 * @author Balaji.M
 * @Date Created: 15-Sept-2016
 */
public class SelectExamPage {
	
	WebDriver driver;
	//private By txt_discountCode = By.id("Content_txtCode");	
	private By btn_NewStudent = By.id("Content_lbnNewStudent");
	private By btn_Login = By.id("Content_lbnLogin");
	private By btn_NewPassword = By.id("Content_lbnConvert");	
	
	private By lbl_EMail = By.xpath("//div[@id='Content_divLogin']/table[2]/tbody/tr[2]");
	private By txt_EMail = By.id("Content_txtEMail");
	private By lbl_Password = By.xpath("//div[@id='Content_divLogin']/table[3]/tbody/tr[1]");
	private By txt_Password = By.id("Content_txtPassword");	
	
	private By hed_selectExam = By.xpath("//div[@class='orange-bar']");	
	private By bcm_SelectExamPageBreadCrumb = By.xpath("//div[@class='breadcrumb']");	
	
	private By hed_availableCourses = By.xpath("//div[@id='Content_divAvailableCourses']/h4");
	private By hed_InsuranceCourses = By.xpath("//div[@id='Content_divInsurance']/h4");	
	private By hed_SecurityCourses = By.xpath("//div[@id='Content_divSecurities']/h4");
	private By hed_ContinuingEducation = By.xpath("//div[@id='Content_divCE']/h4");
	
	//INSURANCE COURSES HREF LINKS
	private By lnk_AllLinesAdjustersInsurance = By.linkText("All Lines Adjusters Insurance");
	private By lnk_LifeandHealthInsurance = By.linkText("Life and Health Insurance");
	private By lnk_LimitedLinesAutomobile = By.linkText("Limited Lines Automobile");
	private By lnk_LimitedSubAgent = By.linkText("Limited Sub-Agent");
	private By lnk_MedicareSupplementLongTermCare = By.linkText("Medicare Supplement/Long Term Care");
	private By lnk_PropertyandCasualtyInsurance = By.linkText("Property and Casualty Insurance");
	private By lnk_VariableProducts = By.linkText("Variable Products");
	
	//Securities COURSES HREF LINKS
	private By lnk_Series24 = By.linkText("Series 24");
	private By lnk_Series26 = By.linkText("Series 26");
	private By lnk_Series6 = By.linkText("Series 6");
	private By lnk_Series6and63 = By.linkText("Series 6 and 63");
	private By lnk_Series63 = By.linkText("Series 63");
	private By lnk_Series65 = By.linkText("Series 65");
	private By lnk_Series66 = By.linkText("Series 66");
	private By lnk_Series7 = By.linkText("Series 7");
	
	//Continuing Education Next level HREF LINKS
	private By lnk_CE_NextLevel = By.linkText("Next Level");
	
	public SelectExamPage(){
		this.driver = DriverFactory.getDriver();
	}
	
	public String getPageHeading()
	{
		System.out.println("******************getPageHeading()");
		
		String heading = driver.findElement(hed_selectExam).getText();
		
		System.out.println("**heading:" + heading);
		
		return heading;
	}
	
	public boolean isBreadCrumbDisplayed()
	{
		System.out.println("******************isBreadCrumbDisplayed()");
		
		boolean flag = driver.findElement(bcm_SelectExamPageBreadCrumb).isDisplayed();
		
		return flag;
	}
	
	public boolean isNewStudentButtonDisplayed()
	{
		System.out.println("******************isNewStudentButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_NewStudent).isDisplayed();
		
		return flag;
	}
	
	public boolean isEMailAddressLabelDisplayed()
	{
		System.out.println("******************isEMailAddressLabelDisplayed()");
		
		boolean flag = driver.findElement(lbl_EMail).isDisplayed();
		
		return flag;
	}
	
	public boolean isEMailAddressFieldDisplayed()
	{
		System.out.println("******************isEMailAddressFieldDisplayed()");
		
		boolean flag = driver.findElement(txt_EMail).isDisplayed();
		
		return flag;
	}
	
	public boolean isPasswordLabelDisplayed()
	{
		System.out.println("******************isPasswordLabelDisplayed()");
		
		boolean flag = driver.findElement(lbl_Password).isDisplayed();
		
		return flag;
	}
	
	public boolean isPasswordFieldDisplayed()
	{
		System.out.println("******************isPasswordFieldDisplayed()");
		
		boolean flag = driver.findElement(txt_Password).isDisplayed();
		
		return flag;
	}
	
	public void enterEMailAddress(String emailAddress){
		
		driver.findElement(txt_EMail).sendKeys(emailAddress);		
	}
	
	public void enterPassword(String password){
		
		driver.findElement(txt_Password).sendKeys(password);		
	}
	
	public boolean isLoginButtonDisplayed()
	{
		System.out.println("******************isLoginButtonDisplayed()");
		
		boolean flag = driver.findElement(btn_Login).isDisplayed();
		
		return flag;
	}
	
	public boolean isNewPasswordDisplayed()
	{
		System.out.println("******************isNewPasswordDisplayed()");
		
		boolean flag = driver.findElement(btn_NewPassword).isDisplayed();
		
		return flag;
	}
	
	public SelectExamPage clickOnNewStudent(){
		driver.findElement(btn_NewStudent).click();
		
		return this;
	}
	
	public boolean isCoursesHeadingDisplayed()
	{
		System.out.println("******************isCoursesHeadingDisplayed()");
		
		boolean flag = false;
		
		flag = driver.findElement(hed_availableCourses).isDisplayed();
		flag = driver.findElement(hed_InsuranceCourses).isDisplayed();
		flag = driver.findElement(hed_SecurityCourses).isDisplayed();
		flag = driver.findElement(hed_ContinuingEducation).isDisplayed();
		
		return flag;
	}
	
	public boolean areAllInsuranceCoursesLinksDisplayed()
	{
		System.out.println("******************areAllInsuranceCoursesLinksDisplayed()");
		
		boolean flag = false;
		
		flag = driver.findElement(lnk_AllLinesAdjustersInsurance).isDisplayed();
		flag = driver.findElement(lnk_LifeandHealthInsurance).isDisplayed();
		flag = driver.findElement(lnk_LimitedLinesAutomobile).isDisplayed();
		flag = driver.findElement(lnk_LimitedSubAgent).isDisplayed();
		flag = driver.findElement(lnk_MedicareSupplementLongTermCare).isDisplayed();
		flag = driver.findElement(lnk_PropertyandCasualtyInsurance).isDisplayed();
		flag = driver.findElement(lnk_VariableProducts).isDisplayed();
		
		return flag;
	}
	
	public boolean areAllSecuritiesCoursesLinksDisplayed()
	{
		System.out.println("******************areAllSecuritiesCoursesLinksDisplayed()");
		
		boolean flag = false;
		
		flag = driver.findElement(lnk_Series24).isDisplayed();
		flag = driver.findElement(lnk_Series26).isDisplayed();
		flag = driver.findElement(lnk_Series6).isDisplayed();
		flag = driver.findElement(lnk_Series6and63).isDisplayed();
		flag = driver.findElement(lnk_Series63).isDisplayed();
		flag = driver.findElement(lnk_Series65).isDisplayed();
		flag = driver.findElement(lnk_Series66).isDisplayed();
		flag = driver.findElement(lnk_Series7).isDisplayed();
		
		return flag;
	}
	
	public boolean isCENextLevelLinkDisplayed()
	{
		System.out.println("******************isCENextLevelLinkDisplayed()");
		
		boolean flag = false;
		
		flag = driver.findElement(lnk_CE_NextLevel).isDisplayed();
		
		return flag;
	}
	
	public boolean isLinkforCourseDisplayed(String courseName){
		
		System.out.println("******************isLinkforCourseDisplayed()");
		
		boolean flag = false;
		
		flag = driver.findElement(By.linkText(courseName)).isDisplayed();
		
		return flag;
	}	
	
	public SelectLocationPage clickOnCourseName(String courseName){		
		driver.findElement(By.linkText(courseName)).click();
		
		return new SelectLocationPage();
	}	
	
	
	
	
	
}
