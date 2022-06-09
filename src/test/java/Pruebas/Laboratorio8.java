package Pruebas;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Paginas.HomePage;
import Paginas.PaginaLogin;
import Utilidades.DatosExcel;

public class Laboratorio8 {

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
	
	//public Object[][] obtenerDatosExel(){
		//return DatosExel.LeerExel(..\\EducacionIT\\Datos\\datosAProbar.xlsx);
	//}
	
	@Test(dataProvider="Obtener Datos Exel del login")
	public void login(String email, String password) {
		HomePage inicio = new HomePage(driver);
		inicio.hacerClickEnSingIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.completarEmail(email);
		login.completarContrasenia(password);
		login.hacerClicEnLogin();
		
		//comprobar si el ususario pudo iniciar sesion
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", driver.getCurrentUrl());
		
		//si el ususrio pudo iniciar sesion.,cerramos la sesion para poder continuar
		login.hacerClickEnSingOut();
	}
	
	@DataProvider(name="Obtener Datos Exel del login")
	public Object[][] obtenerDatosExel() throws Exception{
		return DatosExcel.leerExcel("..//EducacionIT//Datos//datosAProbar.xlsx","Hoja1");
	}
	
	@DataProvider(name="Datos del login")
	public Object[][] obtenerDatos(){
		Object[][] datos= new Object[3][2];
		
		//comletar las combinaciones de datos para probar el login
		datos[0][0] = "abc@correo.com";
		datos[0][1] = "1234";
		
		datos[1][0] = "def@correo.com";
		datos[1][1] = "qwewqewqr";
		
		datos[2][0] = "ghi@correo.com";
		datos[2][1] = "56hdjdjgdfg";
		
		return datos;
	}
}
