package Pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio9 {
	
	String url = "https://demo.guru99.com/test/table.html";
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
	public void imprimirValoresTabla() {
		String valor1 = driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println("Primera  Fila, primera columna: " + valor1);
		
		valor1 = driver.findElement(By.xpath("//tbody/tr[2]/td[2]")).getText();
		System.out.println("Segunda Fila, segunda columna: " + valor1);
		
		valor1 = driver.findElement(By.xpath("//tbody/tr[4]/td[2]")).getText();
		System.out.println("cuarta  Fila, segunda columna: " + valor1);
		
	}
}

