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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.expression.spel.ast.Assign;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.accessibility.internal.resources.accessibility;
import com.sun.jna.platform.win32.WinUser.LASTINPUTINFO;

import org.openqa.selenium.WebDriver;
import br.com.sysmap.teste.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.sysmap.teste.TesteTrackerLogin;

public class TesteTrackerAlmoco {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLogin login = new TesteTrackerLogin();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	
	@Test
	public void DeveClicarAlmoco() throws MalformedURLException, InterruptedException{
				
				//Clicar Almoço
				WebDriverWait wait = new WebDriverWait(driver, 10000);
				//System.out.println("teste4");
			    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Almoço']")));
			   	MobileElement Almoco = driver.findElement(By.xpath("//*[@text='Almoço']"));
			   	//System.out.println("teste5");
			   	System.out.println(Almoco.getText());
			    Almoco.click();
			    
			    //Voltar do Almoço
			    Thread.sleep(10000);
			    WebDriverWait waitAlmocoExecutando = new WebDriverWait(driver, 10000);
			    waitAlmocoExecutando.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")));
			   	MobileElement AlmocoExecutando = driver.findElement(By.xpath("//*[@text='Almoço:']"));
			   	System.out.println(AlmocoExecutando.getText());
			   	assertEquals("Almoço:", AlmocoExecutando.getText());
			   	Thread.sleep(2000);
			   	
			   	WebDriverWait waitVoltarAlmoco = new WebDriverWait(driver, 10000);
			    waitVoltarAlmoco.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoVoltarAlmoco = driver.findElements(By.className("android.widget.ImageView"));
			    ElementoVoltarAlmoco.get(9).click();
			    Thread.sleep(2000);
			  		   	    
	}
	public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
