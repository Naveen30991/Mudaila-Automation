package com.mudaila.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mudaila.qa.base.MudailaBaseClass;

public class LoginPage extends MudailaBaseClass {

	HomePage homepage;
	ForgotPassword forgotpassword;
	String currentUrl="http://motherearth.mudaila.com/beta/authentication/login/forgot";

	@FindBy(xpath = "//img[@class='profile-img']")
	WebElement logo;
	
	@FindBy(xpath = "/html/head/title")
	WebElement title;

	@FindBy(name = "username")
	WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginbtn;

	@FindBy(xpath = "//*[@id=\"login\"]/form/span[1]/label/span")
	WebElement rememberMe;

	@FindBy(xpath = "//a[contains(text(),'Forgot Password')]")
	WebElement forgetpwd;

	@FindBy(xpath = "//a[contains(text(),'Write a Quote')]")
	WebElement quote;

	@FindBy(xpath = "//a[contains(text(),'Conatct Us')]")
	WebElement contactUs;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Logo Check
	public boolean logoCheck() {
		return logo.isDisplayed();
	}

	//Verifing Title
	public String verifyTitle() {

		return driver.getTitle();
	}

	public HomePage mudailaLogin() {
		username.sendKeys(prop.getProperty("username"));
		password.sendKeys(prop.getProperty("password"));
		loginbtn.submit();
		return new HomePage();
	}

	public boolean isSelected() {
		      rememberMe.click();
		return rememberMe.isEnabled();
	}
	
	public ForgotPassword forgotPassword() {
		forgetpwd.click();
		String curretnurl=driver.getCurrentUrl();
		Assert.assertEquals(curretnurl, currentUrl);
		return new ForgotPassword();
	}
}
