package stepDefinations;

import java.time.Duration;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class NewLoginSD extends BaseClass{
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		logger.info("*********launching the Browser*************");
		lp = new LoginPage(driver);
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("*********Opening URL*************");
	    driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("********* Proving user info ***************");
		lp.setUserName(email);
		lp.setPassword(password);
	}
	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	   lp.clickLogin();
	   Thread.sleep(5000);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
	
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			logger.info("*********Login Failed ***************");
			driver.close();
			Assert.assertTrue(false);
		}
		else {
			logger.info("*********Login successfull ***************");
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(5000);
	}

	@When("User click on Logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		logger.info("*********Logout from application***************");
	   Thread.sleep(5000);
	   lp.clickLogout();
	   Thread.sleep(5000);
	}

	@Then("close browser")
	public void close_browser() {
	 logger.info("*********Closing application ***************");
	  driver.quit();
	}
}
