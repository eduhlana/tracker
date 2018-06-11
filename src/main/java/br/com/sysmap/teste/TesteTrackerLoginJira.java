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


public class TesteTrackerLoginJira {
	
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLoginSemNovaAtividade login = new TesteTrackerLoginSemNovaAtividade();
	
	@Before
	public void InicializarAppium() throws MalformedURLException, InterruptedException{
		driver = DriverFactory.getDriver();
		login.InicializarAppium();
		login.DevePreencherCampoLogin();
	}
	
	@Test
	public void DevePreencherLoginJira() throws MalformedURLException, InterruptedException{
		//Capacidades
				
				//escrever login
			    //System.out.println("teste1");
				WebDriverWait wait = new WebDriverWait(driver, 10000);
			    //System.out.println("teste3");
			    
			    //Clicar botão Jira
			    WebDriverWait waitJira = new WebDriverWait(driver, 10000);
			    waitJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoJira = driver.findElements(By.className("android.widget.ImageView"));
			    ElementoJira.get(5).click();
			    
			    
			    //Inserir Login Jira
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.EditText")));
			    java.util.List<MobileElement> ElementosEncontrados = driver.findElements(By.className("android.widget.EditText"));
			    ElementosEncontrados.get(0).sendKeys("Colocar usuario do Jira");
			    ElementosEncontrados.get(1).sendKeys("Colocar senha do Jira");
			   
			    //Clicar no checkbox
			    
			    WebDriverWait waitImagem = new WebDriverWait(driver, 10000);
			    waitImagem.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementosImagem = driver.findElements(By.className("android.widget.ImageView"));
			    ElementosImagem.get(4).click();
			    
		    	//Clicar no Conectar
			    
			    WebDriverWait waitBotaoEntrar = new WebDriverWait(driver, 10000);
			    waitBotaoEntrar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoEntrar = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoEntrar.get(5).click();
			   	Thread.sleep(3000);
			   	
			   	//Verificar se está Conectado
			   	
			   	WebDriverWait waitBotaoJira = new WebDriverWait(driver, 10000);
			    waitBotaoJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoBotaoJira = driver.findElements(By.className("android.widget.ImageView"));
			    ElementoBotaoJira.get(5).click();
			    Thread.sleep(2000);
			    
			   	WebDriverWait waitConectado = new WebDriverWait(driver, 10000);
			   	waitConectado.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")));
			   	MobileElement ConectadoJira = driver.findElement(By.xpath("//*[@text='Filtrar itens']"));
			   	System.out.println(ConectadoJira.getText());
			   	assertEquals("Filtrar itens", ConectadoJira.getText());
			   	Thread.sleep(2000);
			   	
			   	//DesconectarJira
			   	WebDriverWait waitBotaoUsuario = new WebDriverWait(driver, 10000);
			    waitBotaoUsuario.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoBotaoUsuario = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoBotaoUsuario.get(2).click();
			   	Thread.sleep(3000);
			   	
			   	WebDriverWait waitDesconectarJira = new WebDriverWait(driver, 10000);
			    waitDesconectarJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoDesconectar = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoDesconectar.get(7).click();
			   	Thread.sleep(3000);
			   	
			   	/////////////Conectar Jira pela Tela de Usuario////////////////////
			   	
			   	WebDriverWait waitConectarJira = new WebDriverWait(driver, 10000);
			    waitDesconectarJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoConectarJira = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoConectarJira.get(7).click();
			   	
			   	//Inserir Login Jira
			    waitConectarJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.EditText")));
			    java.util.List<MobileElement> ElementosDadosLogin = driver.findElements(By.className("android.widget.EditText"));
			    ElementosDadosLogin.get(0).sendKeys("Colocar usuario do Jira");
			    ElementosDadosLogin.get(1).sendKeys("Colocar senha do Jira");
			   
			    //Clicar no checkbox
			    
			    WebDriverWait waitCheckBox = new WebDriverWait(driver, 10000);
			    waitCheckBox.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementosCheckBox = driver.findElements(By.className("android.widget.ImageView"));
			    ElementosCheckBox.get(4).click();
			    
		    	//Clicar no Conectar
			    
			    WebDriverWait waitEntrar = new WebDriverWait(driver, 10000);
			    waitEntrar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoEntrarJira = driver.findElements(By.className("android.widget.ImageView"));
			   	ElementoEntrarJira.get(5).click();
			   	Thread.sleep(3000);
			   	
			   	///////Verificar se está conectado
			   	
			   	//Clicar Sysmap Tracker
			   	WebDriverWait waitSysmapTracker = new WebDriverWait(driver, 10000);
			    waitSysmapTracker.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='SysMap Tracker']")));
			   	driver.findElement(By.xpath("//*[@text='SysMap Tracker']")).click();
			   	Thread.sleep(3000);
			   	
			   	WebDriverWait waitElementoJira = new WebDriverWait(driver, 10000);
			    waitElementoJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.ImageView")));
			    java.util.List<MobileElement> ElementoJira1 = driver.findElements(By.className("android.widget.ImageView"));
			    ElementoJira1.get(5).click();
			    Thread.sleep(2000);
			    
			    WebDriverWait waitConectadoJira = new WebDriverWait(driver, 10000);
			   	waitConectadoJira.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.TextView")));
			   	MobileElement ConectadoJira1 = driver.findElement(By.xpath("//*[@text='Filtrar itens']"));
			   	System.out.println(ConectadoJira1.getText());
			   	assertEquals("Filtrar itens", ConectadoJira1.getText());
			   	Thread.sleep(2000);
			   	
			   	
			   	
	
	}
		    	
	 public static void Quit() {
		
			    
			    driver.quit();
			   
	}
	
}
