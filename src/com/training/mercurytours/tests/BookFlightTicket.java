package com.training.mercurytours.tests;

import java.util.Properties;

import com.training.mercurytours.modules.FlightReservationModule;
import com.training.mercurytours.modules.LoginModule;
import com.training.mercurytours.modules.LogoutModule;
import com.training.mercurytours.utils.CommonLib;
import com.training.mercurytours.utils.Constants;

public class BookFlightTicket extends CommonLib {
	
	
	public static Properties oProp;

	public static void main(String[] args) {
		
		oProp=readDataFromPropertiesFile(Constants.sPropFilePath+"Data.properties");
		openBrowser(oProp.getProperty("browsername"));
		logger.info("Opening browser "+oProp.getProperty("browsername"));
        navigateToURL(oProp.getProperty("url"));
        logger.info("Navigating to url "+oProp.getProperty("url"));
        LoginModule oLogin=new LoginModule();
        if(oLogin.Login(oProp.getProperty("username"), oProp.getProperty("password")))
        {
        	System.out.println("Login is Successful");
        	FlightReservationModule oFlight=new FlightReservationModule();
        	if(oFlight.findFlights(oProp.getProperty("sPasscount"), oProp.getProperty("sDeparture"),oProp.getProperty("sTravelDt"),oProp.getProperty("sArrival"), oProp.getProperty("sRetnDate"),oProp.getProperty("sAirLinesName")))
        	{
        		System.out.println("Find Flights is Successful");
        		if(oFlight.selectFlightsForRoundTrip(oProp.getProperty("sDept"), oProp.getProperty("sArr")))
        		{
        			System.out.println("Select Flight is successful");
        			if(oFlight.enterPassengerDetails(oProp.getProperty("sPassFN"), oProp.getProperty("sPassLN"), oProp.getProperty("sCreditNo")))
        			{
        				System.out.println("Book Flight is Successful");
        				LogoutModule oLogOut=new LogoutModule();
        				if(oLogOut.LogOutFromMercuryTours())
        				{
        					System.out.println("LogOut from Mercury Tours is successful");
        					closeBrowser();
        				}
        				else
        				{
        					System.out.println("Failed to Logout MT");
        				}
        			}
        			else
        			{
        				System.out.println("Unable to enter passenger details");
        			}
        		}
        		else
        		{
        			System.out.println("Select Flights is Failed");
        		}
        	}
        	else
        	{
        		System.out.println("Flight Search is failed");
        	}
        }
        else
        {
        	System.out.println("Login is failed");
        }
        
		

	}

}
