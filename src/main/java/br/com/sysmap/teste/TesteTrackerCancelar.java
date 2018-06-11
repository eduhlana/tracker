package br.com.sysmap.teste;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Get;
import org.apache.tools.ant.taskdefs.Sleep;
import org.apache.tools.ant.types.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.expression.spel.ast.Assign;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
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

public class TesteTrackerCancelar {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLogin login = new TesteTrackerLogin();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	
	@Test
	public void DeveClicarCancelar() throws MalformedURLException, InterruptedException{
		//Capacidades
				
				//Clicar Cancelar
				WebDriverWait wait = new WebDriverWait(driver, 50000);
				//System.out.println("teste4");
				WebDriverWait waittela = new WebDriverWait(driver, 50000);
			   
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text='Cancelar']")));
			   	MobileElement Cancelar = driver.findElement(By.xpath("//*[@text='Cancelar']"));
			   	//System.out.println("teste5");			    
			    Cancelar.click();
			    			    
			    //Mensagem de Atenção
			    WebDriverWait waitAtencao = new WebDriverWait(driver, 10000);
				//System.out.println("teste6");
			    
			    
			   	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("android:id/message")));
			   	MobileElement Atencao = driver.findElement(By.xpath("//*[@text='Ao cancelar a marcação em progresso, o período desde o último início será ignorado. Deseja realmente proceder com a operação?']"));
			   	System.out.println(Atencao.getText());
			   	assertEquals("Ao cancelar a marcação em progresso, o período desde o último início será ignorado. Deseja realmente proceder com a operação?", Atencao.getText());
			   	
			   	//System.out.println("teste7");
			    
			   	WebDriverWait waitSIM = new WebDriverWait(driver, 10000);
			   	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.Button")));
			   	MobileElement SIM = driver.findElement(By.xpath("//*[@class='android.widget.Button'][3]"));
			   	//System.out.println("teste8");
			   	System.out.println(SIM.getText());
			   	SIM.click();
			    
	}
		    	
	 public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
