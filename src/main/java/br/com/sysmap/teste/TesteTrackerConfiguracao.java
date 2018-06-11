package br.com.sysmap.teste;

import static org.junit.Assert.assertEquals;

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

public class TesteTrackerConfiguracao {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLoginSemNovaAtividade login = new TesteTrackerLoginSemNovaAtividade();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	
	@Test
	public void DeveClicarConfig() throws MalformedURLException, InterruptedException{
						
				//Clicar Configuração
			    
			    WebDriverWait waitClicarConfig = new WebDriverWait(driver, 10000);
			    waitClicarConfig.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoClicarConfig = driver.findElements(By.className("android.widget.ImageView"));
			    //System.out.println("Teste13");
			    ElementoClicarConfig.get(3).click();
			    
			    waitClicarConfig.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")));
			   	MobileElement Atencao = driver.findElement(By.xpath("//*[@text='Esta funcionalidade não está implementada!']"));
			   	System.out.println(Atencao.getText());
			   	assertEquals("Esta funcionalidade não está implementada!", Atencao.getText());
			   	Thread.sleep(2000);
			   	DeveClicarFora(100,150);
			   	//System.out.println("teste7");
			   	Thread.sleep(3000);
			   	
			   	WebDriverWait waitBotaoUsuario = new WebDriverWait(driver, 10000);
			    waitBotaoUsuario.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoBotaoUsuario = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoBotaoUsuario.get(2).click();
			   	Thread.sleep(3000);
			   	
			  //Clicar Configuração
			   	WebDriverWait waitClicarConfig1 = new WebDriverWait(driver, 10000);
			    waitClicarConfig1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoClicarConfig1 = driver.findElements(By.className("android.widget.ImageView"));
			    //System.out.println("Teste13");
			    ElementoClicarConfig1.get(2).click();
			    
	}
	public void DeveClicarFora(int x, int y) {
    	new TouchAction(driver).tap(x, y).perform();
    	    	
    }
		    	
	public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
