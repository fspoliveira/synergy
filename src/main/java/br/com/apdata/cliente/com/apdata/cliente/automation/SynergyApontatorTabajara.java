package br.com.apdata.cliente.com.apdata.cliente.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
	
public class SynergyApontatorTabajara {

	private static WebDriver driver;

	private static final String MICROSOFT = "https://login.microsoftonline.com/";
	private static final String SYNERGY = "https://synergy.wipro.com";
	private static final String EMAIL = "email@email.com";
	private static final String SENHA = "XXXXXXX";

	public static void main(String[] args) throws InterruptedException {

		String currentDir = System.getProperty("user.dir");
		System.out.println("Current dir using System:" + currentDir);

		System.out.println("Setting webdriver for Google Chrome, find file chromedriver.exe in directory" + currentDir);
		System.setProperty("webdriver.chrome.driver", currentDir.concat("\\chromedriver.exe"));

		driver = new ChromeDriver();

		// Login
		System.out.println("Login in main page");
		driver.get(MICROSOFT);

		moveToLastWindowsHandle();

		Thread.sleep(5000);

		driver.findElement(By.id("i0116")).sendKeys(EMAIL);

		driver.findElement(By.id("idSIButton9")).click();

		Thread.sleep(5000);

		driver.findElement(By.id("i0118")).sendKeys(SENHA);

		Thread.sleep(5000);
		driver.findElement(By.id("idSIButton9")).click();
	
		//Aguarda chegada da senha por sms
		Thread.sleep(30000);

		 ((JavascriptExecutor) driver).executeScript("window.open('https://synergy.wipro.com','_blank');");
		 
		 
		 Thread.sleep(15000);	 
		
		
		Thread.sleep(100000000);

		driver.quit();
	}

	public static void moveToLastWindowsHandle() {
		driver.switchTo().window(
				driver.getWindowHandles().stream().skip(driver.getWindowHandles().size() - 1).findFirst().get());
	}
}
