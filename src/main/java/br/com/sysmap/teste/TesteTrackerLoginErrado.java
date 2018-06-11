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


public class TesteTrackerLoginErrado {
	public static AndroidDriver<MobileElement> driver;
	
	@Before
	public void InicializarAppium () {
	driver = DriverFactory.getDriver();
	}
	
	@Test
	public void DevePreencherCampoLoginErrado() throws MalformedURLException, InterruptedException{
		//Capacidades
				
				//escrever login
			    //System.out.println("teste1");
				WebDriverWait wait = new WebDriverWait(driver, 10000);
			    allowAppPermission(wait);
			    //System.out.println("teste3");
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.EditText")));
			    java.util.List<MobileElement> ElementosEncontrados = driver.findElements(By.className("android.widget.EditText"));
			    //for(MobileElement elemento: ElementosEncontrados) {
			    	//System.out.println(elemento.getText());
			    
			    ElementosEncontrados.get(0).sendKeys("Colocar usuario errado");
			    ElementosEncontrados.get(1).sendKeys("Colocar senha errada");
			  
			    //Clicar no checkbox
			    
			    WebDriverWait waitImagem = new WebDriverWait(driver, 10000);
			    waitImagem.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementosImagem = driver.findElements(By.className("android.widget.ImageView"));
			    ElementosImagem.get(5).click();
		    	
		    	//Clicar no Entrar
			    
			    WebDriverWait waitBotaoEntrar = new WebDriverWait(driver, 10000);
			    waitBotaoEntrar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")));
			    java.util.List<MobileElement> ElementoEntrar = driver.findElements(By.className("android.widget.TextView"));
			   	ElementoEntrar.get(1).click();
			   	Thread.sleep(5000);
			   	
			   	//Mensagem de Login Errado 
			   	WebDriverWait waitLoginErrado = new WebDriverWait(driver, 10000);
			   	waitLoginErrado.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
			   	MobileElement LoginErrado = driver.findElement(By.xpath("//*[@text='O usuário e/ou senha informados são inválidos!']"));
			   	System.out.println(LoginErrado.getText());
			   	assertEquals("O usuário e/ou senha informados são inválidos!", LoginErrado.getText());
			   	Thread.sleep(5000);
			   	
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
