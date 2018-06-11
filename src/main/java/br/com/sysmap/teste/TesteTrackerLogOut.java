package br.com.sysmap.teste;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Get;
import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.expression.spel.ast.Assign;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.accessibility.internal.resources.accessibility;
import org.openqa.selenium.WebDriver;
import br.com.sysmap.teste.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.sysmap.teste.TesteTrackerLogin;

public class TesteTrackerLogOut {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLogin login = new TesteTrackerLogin();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	
	@Test
	public void DeveFazerLogOut() throws MalformedURLException, InterruptedException{
		//Capacidades
				
		//Clicar LogOut
		WebDriverWait waitPaginaSair = new WebDriverWait(driver, 10000);
	    waitPaginaSair.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
	    java.util.List<MobileElement> ElementoPaginaSair = driver.findElements(By.className("android.widget.ImageView"));
	    ElementoPaginaSair.get(2).click();
	    
	    Thread.sleep(5000);
	    WebDriverWait waitLogOut = new WebDriverWait(driver, 10000);
	    waitLogOut.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
	    java.util.List<MobileElement> ElementoLogOut = driver.findElements(By.className("android.widget.ImageView"));
	    
	    ElementoLogOut.get(5).click();
			    
	}
		    	
	 public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
