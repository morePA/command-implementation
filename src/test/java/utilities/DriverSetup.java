package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	WebDriver driver;
	public Properties prop;
	public WebDriver intializeBrowser() throws IOException {
		
		prop= new Properties();
		String propPath = System.getProperty("user.dir")+"\\src\\main\\java\\utilities\\data.properties";
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		String browserName =prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("IE")) {
			
			WebDriverManager.iedriver().setup();
			 driver = new InternetExplorerDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("Output will be shown in output.txt file in test output folder");
		String propPath1 = System.getProperty("user.dir")+"\\test output\\output.txt";
		System.setOut(new PrintStream(new FileOutputStream(propPath1)));
		
		return driver;
}
}