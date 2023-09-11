package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitHelper {
	
	public WebDriver driver;
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
		
	}
	// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	
	public void WaitForElement(WebElement element , Duration timeOutInSeconds) {	
		WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void fluentWaitElement(WebElement element , Duration timeOutInSeconds, Duration pollingTime, String xpath)
	{
		WebDriverWait wait =  (WebDriverWait) new WebDriverWait(driver, timeOutInSeconds)
				.ignoring(NoSuchElementException.class)
				.pollingEvery(pollingTime)
				.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
	}

}
