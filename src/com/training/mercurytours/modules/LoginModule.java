package com.training.mercurytours.modules;

import org.openqa.selenium.By;

import com.training.mercurytours.utils.CommonLib;

public class LoginModule extends CommonLib {

	By edtUserName=By.name("userName");
	By edtPassword=By.name("password");
	By btnLogin=By.name("login");
	By lnkIternary=By.linkText("ITINERARY");
	
	public boolean Login(String sUserName,String sPassword)
	{
		try
		{
			enterText(edtUserName, sUserName);
			enterText(edtPassword, sPassword);
			clickElem(btnLogin);
			if(isElemDisplayed(getElem(lnkIternary)))
			{
				System.out.println("Logged into Mercury Tours Successfully");
				return true;
			}
			else
			{
				System.out.println("Failed to Login to Mercury Tours");
				takeScreenshot("LoginFailed.png");
				return false;
			}
			
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			return false;
		}
	}
	
	
}
