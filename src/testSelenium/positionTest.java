package testSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class positionTest {
	
	public String positionT(String username, String password) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\adria\\Universita\\ISPW\\PROGETTO\\Driver\\chromedriver_win32\\chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
    
		driver.get("localhost:8080/DrinkHubFX/");
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"login\"]/fieldset/input")).click();
		
		driver.findElement(By.xpath("//*[@id=\"container\"]/form[5]/input")).click();
		
		WebElement txtBoxContent = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[3]/div/div[4]/div[5]/div/div/div/div/div")); //legge contenuto label
		String h = txtBoxContent.getText();
		driver.close();
		return h;
	}
}
