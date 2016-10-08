package com.training.mercurytours.modules;

import org.openqa.selenium.By;

import com.training.mercurytours.utils.CommonLib;

public class LogoutModule extends CommonLib {
	
	By btnLogout=By.xpath("//img[contains(@src,'Logout')]");
	By edtUserName=By.name("userName");
	
	public boolean LogOutFromMercuryTours()
	{
		try
		{
			clickElem(btnLogout);
			if(isElemDisplayed(getElem(edtUserName)))
			{
				System.out.println("Logging Out MT Successfully");
				return true;
			}
			else
			{
				takeScreenshot("Logoutfailed.png");
				System.out.println("Logout failed");
				return false;
			}
		}
		catch(Throwable t)
		{
			takeScreenshot("Logoutfailed.png");
			System.out.println("Logout failed becuase of "+t.getMessage());
			return false;
		}
	}


}
