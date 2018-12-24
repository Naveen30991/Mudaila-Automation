package com.mudaila.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mudaila.qa.base.MudailaBaseClass;
import com.mudaila.qa.pages.ClientRegistrationPage;
import com.mudaila.qa.pages.HomePage;
import com.mudaila.qa.pages.LoginPage;

public class HomePageImpl extends MudailaBaseClass {

	LoginPage loginPage;
	HomePage homePage;
	ClientRegistrationPage clientRegPage;
	public HomePageImpl() {
		super();
	}
	
	@BeforeMethod
	public void allInvocation() {
		initialization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		clientRegPage=new ClientRegistrationPage();
		homePage = loginPage.mudailaLogin();
	}
	
	@Test(priority=1)
	public void verifyDashboardText()
	{
		String title=homePage.dashboardTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Dashboard Profile");
	}
	
	@Test(priority=2)
	public void clickOnClient()
	{
		homePage.clickOnClint();
	}
	
	@Test(priority=3)
	public void clickOnClientregistration() throws InterruptedException
	{
		homePage.clickOnClint();
		Thread.sleep(3000);
		clientRegPage=homePage.clickOnClientReg();
		System.out.println(clientRegPage);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
