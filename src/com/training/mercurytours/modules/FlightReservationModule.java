package com.training.mercurytours.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.training.mercurytours.utils.CommonLib;

public class FlightReservationModule extends CommonLib{
	
	By lstPassngr=By.name("passCount");
	By lstDept=By.name("fromPort");
	By lstTrvlDate=By.name("fromDay");
	By lstArrival=By.name("toPort");
	By lstRtnDate=By.name("toDay");
	By radioClass=By.xpath("//input[@value='Business']");
	By lstAirlines=By.name("airline");
	By elemSelectFlight=By.xpath("//img[contains(@src,'selectflight')]");
	By btnFindFlights=By.name("findFlights");
	By NoOfTrvlFlights=By.xpath("//input[@name='outFlight']");
	By NoOfRtnFlights=By.xpath("//input[@name='inFlight']");
	By btnReserveFlght=By.name("reserveFlights");
	By edtUserFirstName=By.name("passFirst0");
	By edtUserLastName=By.name("passLast0");
	By edtCreditNo=By.name("creditnumber");
	By btnBuyFlights=By.name("buyFlights");
	By elemFlightConfirm=By.xpath("//img[contains(@src,'mast_confirmation')]");
	
	
	public boolean findFlights(String sPasscount,String sDeparture, String sTravelDt,String sArrival,String sRetnDate,String sAirLinesName)
	{
		try
		{
			selectValFromListbox(getElem(lstPassngr), sPasscount);
			selectValFromListbox(getElem(lstDept), sDeparture);
			selectValFromListbox(getElem(lstTrvlDate), sTravelDt);
			selectValFromListbox(getElem(lstArrival), sArrival);
			selectValFromListbox(getElem(lstRtnDate), sRetnDate);
			clickElem(radioClass);
			selectValFromListbox(getElem(lstAirlines), sAirLinesName);
			clickElem(btnFindFlights);
			if(isElemDisplayed(getElem(elemSelectFlight)))
			{
				System.out.println("Searching flights is successful");
				return true;
			}
			else
			{
				takeScreenshot("FlightSearchFailed");
				System.out.println("Flight search is failed");
				return false;
			}
			
		}
		catch(Throwable t)
		{
			System.out.println("Failed to search for flights");
			return false;
		
		}
	}
	
	
	public boolean selectFlightsForRoundTrip(String sDeptAirlines,String sRtnAirlines)
	{
		
		try
		{
			clickOnElemByusingName(getElems(NoOfTrvlFlights), sDeptAirlines);
			clickOnElemByusingName(getElems(NoOfRtnFlights), sRtnAirlines);
			clickElem(btnReserveFlght);
			if(isElemDisplayed(getElem(edtUserFirstName)))
			{
				System.out.println("Flight selection is successful");
				return true;
			}
			else
			{
				takeScreenshot("Flight selection failed");
				System.out.println("Flight selection failed");
				return false;
			}
		}
		catch(Throwable t)
		{
			takeScreenshot("Flight selection failed");
			System.out.println("Flight selection failed because of "+t.getMessage());
			return false;
		}
	}
	
	public boolean enterPassengerDetails(String sPassFN, String sPassLN,String sCreditNo) {
		try {
			enterText(edtUserFirstName, sPassFN);
			enterText(edtUserLastName, sPassLN);
			enterText(edtCreditNo, sCreditNo);
			clickElem(btnBuyFlights);
			if (isElemDisplayed(getElem(elemFlightConfirm)))
			{
				System.out.println("Entered Passenger details successfully");
				return true;

			} else {
				System.out.println("Error occurred while entering passenger details");
				takeScreenshot("FailedPasgr.png");
				return false;
			}
		} catch (Throwable t) {
			System.out.println("Failed while entering passenger details");
			takeScreenshot("FailedPasgr.png");
			return false;
		}
	}
}

