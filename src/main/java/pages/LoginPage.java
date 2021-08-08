package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
 
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}

	public WebElement username() {
		WebElement username = driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		return username;
	}
	
	public WebElement password() {
		WebElement password = driver.findElement(By.xpath("//input[@id=\"txtPassword\"]"));
		return password;
	}
	
	public WebElement loginbtn() {
		WebElement loginbtn = driver.findElement(By.xpath("//input[@id=\"btnLogin\"]"));
		return loginbtn;
	}
}
