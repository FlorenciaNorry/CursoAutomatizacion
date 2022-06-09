package Edit.EducacionIT;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5 {
	String url= "http://automationpractice.com/index.php";
	String driverPath = "..//EducacionIT//Drivers//chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
	
	driver = new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	}
	

	/*@BeforeSuite
		@BeforeClass
		 @BeforeTest
		 	@BeforeMethod
		 		@Test
		 	@BeforeMethod
		 @BeforeTest
		@BeforeClass*/
		 
	@Test(priority= 1, description= "validar el buscador de palabra", enabled=true)
	//es para dar prioridad de ejecucion, o qualgo de debaejecutar primero
	//enable = false significa que no se va a ejecutar
	public void buscarPalabra() {
	
		WebElement txtBuscador = driver.findElement(By.cssSelector("#search_query_top"));
		txtBuscador.sendKeys("shirt");
		txtBuscador.sendKeys(Keys.ENTER);
		
		//validacion de resltado esperado 
		String urlEsperada = "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=shirt&submit_search=\r\n";
		String tituloEsperado = "Search - My Store";
		
		Assert.assertEquals(urlEsperada, driver.getCurrentUrl());
		Assert.assertEquals(tituloEsperado, driver.getTitle());
		
		/*
		 * *AssertNOequals(1, 2)
		 * assertTrue()
		 * assertFalse()
		 * assertNull()
		 * assertNotNull();
		 */
	}
	
	
	public void contactanos() {
		driver.findElement(By.linkText("Contact Us")).click();

		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		driver.findElement(By.id("email")).sendKeys("maflorencia.norry@gmail.com");
		driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\maflo\\OneDrive\\Escritorio");
		driver.findElement(By.id("message")).sendKeys("comentario");
		
		driver.findElement(By.id("submitMessage")).click();

}
	
	@AfterSuite
	public void cerrarPagina() {
		driver.close();
	}
	
}
