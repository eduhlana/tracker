package br.com.sysmap.teste.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class DriverFactory {
	
	public static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
	
		if(driver == null) {
			//createDriver();
			createTestObjectDriver();
		}
		return driver;
	}
	
	private static void createDriver() {
	//Capacidades
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); //Para completar, coloca o cursor no final de DesiredCapabilities "ctrl" + "espaço"
		    desiredCapabilities.setCapability("platformName", "Android");
		    desiredCapabilities.setCapability("deviceName", "emulator-5554");
		    desiredCapabilities.setCapability("automationName", "uiautomator2");
		    desiredCapabilities.setCapability("appPackage", "com.sysmaptracker");
		    desiredCapabilities.setCapability("appActivity", "com.sysmaptracker.MainActivity");
		    
		    try {
				driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} //Driver de conexao - Para inicializar, código pós "="
		    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS );
		
	}
	private static void createTestObjectDriver() {
		//Capacidades
				DesiredCapabilities desiredCapabilities = new DesiredCapabilities(); //Para completar, coloca o cursor no final de DesiredCapabilities "ctrl" + "espaço"
			    desiredCapabilities.setCapability("platformName", "Android");
			    desiredCapabilities.setCapability("testobject_api_key", "e5651120-ea65-4e6b-8eb6-4ec990c52c85");
			    desiredCapabilities.setCapability("appiumVersion", "1.8.0");
			    desiredCapabilities.setCapability("automationName", "uiautomator2");
			  			    
			    try {
					driver = new AndroidDriver<MobileElement>(new URL("https://appcenter.ms/users/Mesquita/apps/TRACKER/test/runs/new"), desiredCapabilities);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS );
			    

	}
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		
		}
	}
}
