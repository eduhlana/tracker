package br.com.sysmap.teste;

import static org.junit.Assert.assertEquals;

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

public class TesteTrackerParar {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLogin login = new TesteTrackerLogin();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	
	@Test
	public void DevePararAtividade() throws MalformedURLException, InterruptedException{
		//Capacidades
				
				//Clicar Almoço
				WebDriverWait waitParar = new WebDriverWait(driver, 10000);
				//System.out.println("teste4");
			    
				waitParar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoParar = driver.findElements(By.className("android.widget.ImageView"));
			    ElementoParar.get(10).click();
			    
			    waitParar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("android:id/message")));
			   	MobileElement Atencao = driver.findElement(By.xpath("//*[@text='Ao parar a marcação em progresso, o Tracker de OCIOSIDADE será iniciado automaticamente. Deseja realmente proceder com a operação?']"));
			   	System.out.println(Atencao.getText());
			   	assertEquals("Ao parar a marcação em progresso, o Tracker de OCIOSIDADE será iniciado automaticamente. Deseja realmente proceder com a operação?", Atencao.getText());
			   	
			   	//System.out.println("teste7");
			    
			   	WebDriverWait waitSIM = new WebDriverWait(driver, 10000);
			   	waitSIM.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.Button")));
			   	MobileElement SIM = driver.findElement(By.xpath("//*[@class='android.widget.Button'][3]"));
			   	//System.out.println("teste8");
			   	System.out.println(SIM.getText());
			   	SIM.click();
			   	
			  //Clicar Atividade
			    Thread.sleep(5000);			   	
			   	WebDriverWait waitClicarAtividade = new WebDriverWait(driver, 10000);
			    waitClicarAtividade.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoClicarAtividade = driver.findElements(By.className("android.widget.ImageView"));
			    ElementoClicarAtividade.get(15).click();
			    Thread.sleep(2000);
			    
	}
		    	
	 public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
