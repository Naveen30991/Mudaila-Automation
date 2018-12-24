package com.mudaila.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.mudaila.qa.base.MudailaBaseClass;

public class ClientRegistrationPage extends MudailaBaseClass{
	
	public ClientRegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}

}
