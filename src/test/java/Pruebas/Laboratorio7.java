package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.HomePage;
import Paginas.PaginaLogin;

public class Laboratorio7 {
	String url = "http://automationpractice.com";
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
	public void login() {
		HomePage inicio = new HomePage(driver);
		inicio.hacerClickEnSingIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.completarEmail("correo01@mailinator.com");
		login.completarContrasenia("1q2w3e4r5t");
		login.hacerClicEnLogin();
	}
	
	@Test
	public void buscarPalabra() {
		HomePage inicio = new HomePage(driver);
		inicio.escribirPalabra("skirt");
		inicio.hacerBusqueda();
	}
	
}
