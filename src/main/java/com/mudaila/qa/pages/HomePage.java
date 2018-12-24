package com.mudaila.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mudaila.qa.base.MudailaBaseClass;

public class HomePage extends  MudailaBaseClass{
	
	@FindBy(xpath="/html/body/div[2]/aside[2]/section[1]/h1")
	WebElement header;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']/li[2]/ul[1]/li[4]")
	WebElement treeView;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']/li[2]/ul[1]/li[4]/ul/li[2]")
	WebElement clientRegistration;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String dashboardTitle() {
		return header.getText();
	}
	
	public void clickOnClint()
	{
		treeView.click();
	}

	public ClientRegistrationPage clickOnClientReg()
	{
		Actions a=new Actions(driver);
		a.moveToElement(treeView).click().build().perform();
		clientRegistration.click();
		return new ClientRegistrationPage();
	}
}
