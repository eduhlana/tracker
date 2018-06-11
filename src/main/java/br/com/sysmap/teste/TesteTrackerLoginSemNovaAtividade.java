package br.com.sysmap.teste;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.ArrayList;
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


public class TesteTrackerLoginSemNovaAtividade {
	public static AndroidDriver<MobileElement> driver;
	public static TesteTrackerLerDadosCSV lerDados = new TesteTrackerLerDadosCSV();
	ArrayList<TesteTrackerUsuario> usuarios;
	
	@Before
	public void InicializarAppium () {
	driver = DriverFactory.getDriver();
	usuarios = lerDados.retornaUsuario();
	}
	
	@Test
	public void DevePreencherCampoLogin() throws MalformedURLException, InterruptedException{
		//Capacidades
				
				//escrever login
			    //System.out.println("teste1");
				WebDriverWait wait = new WebDriverWait(driver, 10000);
			    allowAppPermission(wait);
			    //System.out.println("teste3");
			    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("android.widget.EditText")));
			    java.util.List<MobileElement> ElementosEncontrados = driver.findElements(By.className("android.widget.EditText"));
			    
			    ElementosEncontrados.get(0).sendKeys(usuarios.get(0).getLogin());
			    ElementosEncontrados.get(1).sendKeys(usuarios.get(0).getSenha());
			  
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
	
	}
		    	
	 public void allowAppPermission(WebDriverWait wait) throws MalformedURLException{
			// TODO Auto-generated method stub
		 	//System.out.println("teste2");
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
