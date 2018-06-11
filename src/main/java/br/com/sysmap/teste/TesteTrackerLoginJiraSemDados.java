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


public class TesteTrackerLoginJiraSemDados {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLoginSemNovaAtividade login = new TesteTrackerLoginSemNovaAtividade();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	@Test
	public void DeveLoginJiraSemDados() throws MalformedURLException, InterruptedException{
		//Capacidades
				
				//escrever login
			    //System.out.println("teste1");
				WebDriverWait wait = new WebDriverWait(driver, 10000);
			    System.out.println("teste3");
			    
			    //Clicar botão Jira
			    WebDriverWait waitJira = new WebDriverWait(driver, 10000);
			    waitJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoJira = driver.findElements(By.className("android.widget.ImageView"));
			    ElementoJira.get(5).click();
			    
			    
			    //Clicar no Conectar sem dados de Login preenchidos
			    
			    WebDriverWait waitBotaoEntrar = new WebDriverWait(driver, 10000);
			    waitBotaoEntrar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoEntrar = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoEntrar.get(5).click();
			   	Thread.sleep(3000);
			   	
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
			    
			    WebDriverWait waitFechar = new WebDriverWait(driver, 10000);
			    waitFechar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoFechar = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoFechar.get(0).click();
			   	Thread.sleep(3000);
			   	
			   	WebDriverWait waitBotaoUsuario = new WebDriverWait(driver, 10000);
			    waitBotaoUsuario.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoBotaoUsuario = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoBotaoUsuario.get(2).click();
			   	Thread.sleep(3000);
			   	
			   	/////////////Conectar Jira pela Tela de Usuario////////////////////
			   	
			   	WebDriverWait waitConectarJira = new WebDriverWait(driver, 10000);
			    waitConectarJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoConectarJira = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoConectarJira.get(7).click();
			   				    
		    	//Clicar no Conectar
			    
			    WebDriverWait waitEntrar = new WebDriverWait(driver, 10000);
			    waitEntrar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoEntrarJira = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoEntrarJira.get(5).click();
			   	Thread.sleep(3000);
			   	
			  //Mensagem de Login sem dados 
			   	WebDriverWait waitLoginSemDados1 = new WebDriverWait(driver, 10000);
			   	waitLoginSemDados1.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
			   	MobileElement LoginSemDados1 = driver.findElement(By.xpath("//*[@text='Os campos usuário e senha são obrigatórios!']"));
			   	System.out.println(LoginSemDados1.getText());
			   	assertEquals("Os campos usuário e senha são obrigatórios!", LoginSemDados1.getText());
			   				   	
			   	WebDriverWait waitBotaoOK1 = new WebDriverWait(driver, 10000);
			   	waitBotaoOK1.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
			   	MobileElement BotaoOK1 = driver.findElement(By.xpath("//*[@text='OK'][1]"));
			    System.out.println(BotaoOK1.getText());
			    BotaoOK1.click();
			    
			    WebDriverWait waitFechar1 = new WebDriverWait(driver, 10000);
			    waitFechar1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoFechar1 = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoFechar1.get(0).click();
			   	Thread.sleep(3000);
			   	
			   	
			   	
			   	
			   	
			   	
	
	}
		    	
	 public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
