package Edit.EducacionIT;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratorio2 {
	
	String url="http://automationpractice.com";
	String chromeDriverPath="..\\EducacionIT\\Drivers\\chromedriver.exe";
	String FirefoxDriverPath="..\\EducacionIT\\Drivers\\geckodriver.exe";
	
	@Test
	public void hacerBusquedaEnChrome() {
		//1) Indicar donde esta el driver a utilizar
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		//2) Acceder a pagina que vamos a probar
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		//maximixzr pantalla
		driver.manage().window().maximize();

		//3) Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//4) Hacer la busqueda 
		txtBuscador.sendKeys(Keys.ENTER);
		
		System.out.println("getTitle(): " + driver.getTitle());
		System.out.println("getTitle(): " + driver.getCurrentUrl());
		System.out.println("getTitle(): " + txtBuscador.isDisplayed());
		System.out.println("getTitle(): " + txtBuscador.isEnabled());
		
	}
	
	@Test
	public void hacerBusquedaEnFirefox() {
		//1) Indicar donde esta el driver a utilizar
		System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
		//2) Acceder a pagina que vamos a probar
		WebDriver driver = new FirefoxDriver();
		driver.get(url);
		//3) Escribir la palabra a buscar
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		//4) Hacer la busqueda 
		txtBuscador.sendKeys(Keys.ENTER);
		
	}

}
