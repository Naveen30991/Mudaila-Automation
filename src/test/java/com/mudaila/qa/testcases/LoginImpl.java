package com.mudaila.qa.testcases;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mudaila.qa.base.MudailaBaseClass;
import com.mudaila.qa.pages.ForgotPassword;
import com.mudaila.qa.pages.HomePage;
import com.mudaila.qa.pages.LoginPage;


public class LoginImpl extends MudailaBaseClass {

    private static Logger log=LogManager.getLogger(LoginImpl.class.getName());
	LoginPage loginpage;
	HomePage homepage;
	ForgotPassword forgotPassword;
	
	public LoginImpl()
	{
		super();
	}
  	
	@BeforeMethod
	public void allInvocation()
	{
		initialization();
		loginpage = new LoginPage();
		homepage=new HomePage();
		forgotPassword=new ForgotPassword();
	}
	
	@Test(priority=1)
	public void titleImpl()
	{
		log.info("Checking the logs");
		 log.info("Window Maximized");
		   log.debug("Now hitting Amazon server");
		String title=loginpage.verifyTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Mudaila");
	}
	
	@Test(priority=2)
	public void logoCheck() {
		boolean logo=loginpage.logoCheck();
		Assert.assertTrue(logo);
		System.out.println(logo);
	}
	
	@Test(priority=3)
	public void rememberMe()  {
		boolean status=loginpage.isSelected();
		System.out.println(status);
		Assert.assertTrue(status);
	}
	
	@Test(priority=4)
	public void mudailaLoginImpl()
	{
		homepage=loginpage.mudailaLogin();
	}
	
	@Test(priority=5)
	public void forgotpPassword() {
		forgotPassword=loginpage.forgotPassword();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
