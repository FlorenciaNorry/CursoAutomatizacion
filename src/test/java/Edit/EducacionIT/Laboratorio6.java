package Edit.EducacionIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Laboratorio6 {
	
	String url= "http://automationpractice.com/index.php";
	String driverPath = "..//EducacionIT//Drivers//chromedriver.exe";
	String firefoxDriverPath = "..//EducacionIT//Drivers//geckodriver.exe";
	WebDriver driver;
	
	@BeforeTest
	@Parameters("navegador")
	public void abrirPagina(String navegador) {
		if(navegador.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		}else if(navegador.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(priority=0, description="validar el formulario de contactanos")
	public void contactanos() {
		driver.findElement(By.linkText("Contact us")).click();

		Select selSubject = new Select(driver.findElement(By.id("id_contact")));
		selSubject.selectByVisibleText("Webmaster");
		
		driver.findElement(By.id("email")).sendKeys("maflorencia.norry@gmail.com");
		driver.findElement(By.id("fileUpload")).sendKeys("D:\\Florencia\\Curso SeleniumWebDriver\\prueba1.txt");
		driver.findElement(By.id("message")).sendKeys("comentario");
		
		driver.findElement(By.id("submitMessage")).click();

}
	
	@AfterSuite
	public void cerrarPagina() {
		//driver.close();
	}
	


}
