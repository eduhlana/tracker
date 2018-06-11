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


public class TesteTrackerLoginSemDados {
	public static AndroidDriver<MobileElement> driver;
	
	@Before
	public void InicializarAppium () {
	driver = DriverFactory.getDriver();
	}
	
	@Test
	public void DeveClicarNoEntrarSemDados() throws MalformedURLException, InterruptedException{
		//Capacidades
				
				
				WebDriverWait wait = new WebDriverWait(driver, 10000);
			    allowAppPermission(wait);
			    System.out.println("teste3");
			   		    	
		    	//Clicar no Entrar sem dados preenchidos
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")));
			    java.util.List<MobileElement> ElementoEntrar = driver.findElements(By.className("android.widget.TextView"));
			   	ElementoEntrar.get(1).click();
			   	Thread.sleep(5000);
			   	
			   	//Mensagem de Login sem dados 
			   	WebDriverWait waitLoginSemDados = new WebDriverWait(driver, 10000);
			   	waitLoginSemDados.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
			   	MobileElement LoginSemDados = driver.findElement(By.xpath("//*[@text='Os campos usuário e senha são obrigatórios!']"));
			   	System.out.println(LoginSemDados.getText());
			   	assertEquals("Os campos usuário e senha são obrigatórios!", LoginSemDados.getText());
			   				   	
			   	WebDriverWait waitBotaoOK = new WebDriverWait(driver, 10000);
			   	waitBotaoOK.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
			   	MobileElement BotaoOK = driver.findElement(By.xpath("//*[@text='OK'][1]"));
			    System.out.println(BotaoOK.getText());
			    BotaoOK.click();
			    
	}
		    	
	 public void allowAppPermission(WebDriverWait wait) throws MalformedURLException{
			// TODO Auto-generated method stub
		 System.out.println("teste2");
		   	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.Button")));

			//while (driver.findElements(MobileBy.xpath("//*[@class='android.widget.Button'][1]")).size()>0)
		    //{
		    	driver.findElement(MobileBy.xpath("//*[@class='android.widget.Button'][1]")).click();
		    //}
	    }
	 
	 public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
