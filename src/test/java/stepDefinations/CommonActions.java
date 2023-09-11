package stepDefinations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonActions extends BaseClass //Hook class
{
	WebDriver driver;
	@Before 
	public void setup() throws IOException
	{
		//Logger steps
		logger = Logger.getLogger("nopCommerce"); //added logger
		PropertyConfigurator.configure("log4j.properties");	
		 logger.setLevel(Level.DEBUG);
		//Logger steps done
		 
		//Loading Config.properties file steps
		configProp = new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties");
		configProp.load(configPropFile);
		//Loading Config.properties file is done
	
        String br=configProp.getProperty("browser");

        //Check if browser passed from config.properties file is 'firefox'
        
        if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }
        
      //Check if browser passed from config.properties file is 'chrome'

        else if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
    		ChromeOptions op= new ChromeOptions();
    		op.addArguments("--remote-allow-origins=*");
												    		/*   "--verbose",
												    		   "--headless",
												    		   "--disable-web-security",
												    		   "--ignore-certificate-errors",
												    		   "--allow-running-insecure-content",
												    		   "--allow-insecure-localhost",
												    		   "--no-sandbox",
												    		   "--disable-gpu"  */
    		driver= new ChromeDriver(op);
        }

      //Check if browser passed from config.properties file is 'ie'
        
        else if (br.equals("ie")) {
            System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
            driver = new InternetExplorerDriver();
        }
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		 //cookies and cache clear
	}
	@After(order = 1)
	public void takeScraenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
		//String screenshotName = scenario.getName().replaceAll(" ", "_");
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] sourcePath = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", "screenshot");	
//		scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

	@After(order = 0)
	public void tearDown() {
	driver.quit();
	}
	public WebDriver getDriver() 
	{
		return driver;
	}
	
}
