package Pruebas;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio9b {
	
	String url = "https://demoqa.com/alert";

	String driverPath = "..//EducacionIT//Drivers//chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
		public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);	
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void alerta1() {
		driver.findElement(By.id("alertButton")).click();
		
		//para manejar alertas
		Alert alerta = driver.switchTo().alert();
		alerta.accept();//hacer click en el ok del popup
	}
	
	@Test
	public void alerta2() {
		driver.findElement(By.cssSelector("#timerAlertButton")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alerta2 = driver.switchTo().alert();
		alerta2.accept();
	}
	
	@Test
	public void alerta3() {
		driver.findElement(By.xpath("//button[@id='confirmButton']")).click();
		driver.switchTo().alert().dismiss();
	}
	
	@Test
	public void alerta4() {
		driver.findElement(By.id("promtButton")).click();
		
		Alert alerta = driver.switchTo().alert();
		
		System.out.println(alerta.getText());
		alerta.sendKeys("Clase de Autamizacion");
		alerta.accept();
		
	}

}
