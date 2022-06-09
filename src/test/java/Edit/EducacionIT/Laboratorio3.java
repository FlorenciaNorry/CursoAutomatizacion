package Edit.EducacionIT;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio3 {
	String url="http://automationpractice.com/index.php?controller=authentication&back=my-account	";
	String driverPath="..//EducacionIT//Drivers//chromedriver.exe";
	
	@Test
	public void registrarUsusario() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		//para hacer que se abra en modo incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		
		/*
		 * Arumentos de chrome options
		 * 1) incognito
		 * 2) start-maximized(ya lo inica maximizado)
		 * 3) disable-extensions
		 * 4) disable-popup-blocking
		 * 5) headless(se hace la ejecucion sin abrir el navegador, para ahorrar recursos)
		 * 6) 
		 * */
		
		WebDriver driver = new ChromeDriver(options);	
		driver.navigate().to(url);
		
		driver.manage().window().maximize();
		
		WebElement singin = driver.findElement(By.xpath("//input[@id='email_create']"));
		singin.sendKeys("correo11demayode2022"+ Math.random() +"@gmail.com");
		
		driver.findElement(By.cssSelector("#SubmitCreate")).click();
		
		//se agrega espera explicita para que si avanza rapido siga o si no qeu espere
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		driver.findElement(By.id("id_gender1")).click();
		
		driver.findElement(By.id("customer_firstname")).sendKeys("Florencia");
		driver.findElement(By.name("customer_lastname")).sendKeys("Norry");
		driver.findElement(By.cssSelector("#passwd")).sendKeys("Cosmi310932");
		
		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByValue("23");
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByVisibleText("April ");
		Select year = new Select(driver.findElement(By.name("years")));
		year.selectByIndex(30);
		
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.name("optin")).click();
		
		driver.findElement(By.cssSelector("#company")).sendKeys("Mi Empresa");
		driver.findElement(By.cssSelector("#address1")).sendKeys("mi Direccion");
		driver.findElement(By.cssSelector("#address2")).sendKeys("otra direccion");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Tucuman");
		
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByVisibleText("California");
		
		driver.findElement(By.id("postcode")).sendKeys("90210");
		
		driver.findElement(By.name("other")).sendKeys("usuario registrado por medio de un script");
		driver.findElement(By.cssSelector("#phone")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("12234345");
		
		//borramos el campo y luego escribimos 
		WebElement txtAlias = driver.findElement(By.name("alias"));
		txtAlias.clear();
		txtAlias.sendKeys("Mi Casa");
		
		driver.findElement(By.id("submitAccount")).click();
		
		

	}

}
