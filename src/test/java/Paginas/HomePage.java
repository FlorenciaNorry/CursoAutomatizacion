package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	//elementos de la pagina
	
	@FindBy(id="search_query_top")
	WebElement txtBuscador;
	
	@FindBy(linkText="Sign in")
	WebElement lnkSignIn;
	
	@FindBy(name="submit_search")
	WebElement btnBuscar;
	
	//definir un constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//metodo que representa las acciones de los elements
	public void hacerClickEnSingIn() {
		lnkSignIn.click();
	}
	
	public void escribirPalabra(String palabra) {
		txtBuscador.sendKeys(palabra);
	}
	
	public void hacerBusqueda() {
		btnBuscar.click();
	}
}
