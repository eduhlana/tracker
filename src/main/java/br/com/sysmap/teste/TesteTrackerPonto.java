package br.com.sysmap.teste;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Get;
import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.expression.spel.ast.Assign;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.accessibility.internal.resources.accessibility;
import com.sun.jna.platform.win32.WinUser.LASTINPUTINFO;
import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import org.openqa.selenium.WebDriver;
import br.com.sysmap.teste.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.sysmap.teste.TesteTrackerLoginSemNovaAtividade;

public class TesteTrackerPonto {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLoginSemNovaAtividade login = new TesteTrackerLoginSemNovaAtividade();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	
	@Test
	public void DeveClicarPonto() throws MalformedURLException, InterruptedException{
						
				//Clicar Ponto
			    
			    WebDriverWait waitClicarPonto = new WebDriverWait(driver, 10000);
			    waitClicarPonto.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoClicarPonto = driver.findElements(By.className("android.widget.ImageView"));
			    //System.out.println("Teste10");
			    ElementoClicarPonto.get(7).click();
			    
			    Thread.sleep(3000);
			    java.util.List<MobileElement> ElementoClicarDireita = driver.findElements(By.className("android.widget.ImageView"));
			    //System.out.println("Teste11");
			    ElementoClicarDireita.get(9).click();
			    
			    Thread.sleep(3000);
			    java.util.List<MobileElement> ElementoClicarEsquerda = driver.findElements(By.className("android.widget.ImageView"));
			    //System.out.println("Teste12");
			    ElementoClicarEsquerda.get(8).click();
			    
			    //Scroll down
			    Thread.sleep(2000);
			    scroll(0.95,0.001);
			    scroll(0.95,0.001);
			    
			    Thread.sleep(2000);
			    
			    WebDriverWait waitClicarTracking = new WebDriverWait(driver, 10000);
			    waitClicarTracking.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoClicarTracking = driver.findElements(By.className("android.widget.ImageView"));
			    //System.out.println("Teste10");
			    ElementoClicarTracking.get(6).click();

	}
	public void scroll(double inicio, double fim) {
    	
    	Dimension size = driver.manage().window().getSize();
    	
    	int x = size.width / 2;
    	
    	int start_y = (int) (size.height * inicio);
    	int end_y = (int) (size.height * fim);
    	
    	new TouchAction((driver))
    	.press(x, start_y)
    	.waitAction(Duration.ofMillis(500))
    	.moveTo(x, end_y)
    	.release()
    	.perform();

    	
    }
		    	
	public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
