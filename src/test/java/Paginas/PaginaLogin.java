package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	
	@FindBy(css="#email")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement txtContrasenia;
	
	@FindBy(name="SubmitLogin")
	WebElement btnLogin;
	
	@FindBy(linkText="Sign out")
	WebElement lnkSingOut;
	
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void completarEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void completarContrasenia(String contrasenia) {
		txtContrasenia.sendKeys(contrasenia);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void completarCredenciales(String email, String contrasenia) {
		txtEmail.sendKeys(email);
		txtContrasenia.sendKeys(contrasenia);
		btnLogin.click();
	}
	
	public void hacerClickEnSingOut() {
		lnkSingOut.click();
	}
}
