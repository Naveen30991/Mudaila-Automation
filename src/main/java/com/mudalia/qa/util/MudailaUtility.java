package com.mudalia.qa.util;

import com.mudaila.qa.base.MudailaBaseClass;

public class MudailaUtility extends MudailaBaseClass {
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;

	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}

}
