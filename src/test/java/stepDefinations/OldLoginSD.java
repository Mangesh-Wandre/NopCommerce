package stepDefinations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OldLoginSD {
	ChromeDriver driver;
	@Given ("User is on login page")
	public void navigateToLoginPage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\softCourses\\Trail\\driver\\chromedriver.exe");
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	}
	@Given("User is on login page with {string}")
	public void navigateToLoginPage(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\softCourses\\Trail\\driver\\chromedriver.exe");
		ChromeOptions op= new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get(url);
	}
	@When("User enters email")
	public void setEmailId()
	{
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='Email']"));
		txtEmail.clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
	}
	@When("User enters {string}")
	public void setEmailId(String email)
	{
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	}
	@And("User enters password")
	public void setPassword()
	{
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("admin");
	}
	@And("User enters password as {string}")
	public void setPassword(String pwd)
	{
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
	}
	@And ("User click on login button")
	public void clickLoginBtn()
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("User lands on DashBoard page")
	public void verifyLandingPage()
	{
		String actText = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]")).getText();
		String expText ="Dashboard";
		Assert.assertEquals(expText, actText);
	}
	@Then("User close the Browser")
	public void user_close_the_browser() {
	   driver.close();
	}
	@And("Validate the menu items")
	public void validateMenuItems(DataTable data)
	{
		List<String> expList = data.asList();
		 List<WebElement> actMenuItemList = driver.findElements(By.xpath("(//ul[@role='menu'])[2]/li/a//p"));
		 if(expList.size()==actMenuItemList.size())
		 {
			 for(int i=0 ; i<actMenuItemList.size(); i++)	//WebElement actMenuItem:actMenuItemList
			 {
				 Assert.assertTrue(expList.contains(actMenuItemList.get(i).getText()));
				 System.out.println(actMenuItemList.get(i).getText());
			 }
		 }
	}
}
