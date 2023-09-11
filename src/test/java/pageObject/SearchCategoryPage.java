package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCategoryPage {
	public WebDriver driver;
	WaitHelper waithelper;
	
	public SearchCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
		
	}
	
	
	
	@FindBy(how=How.XPATH , using="//input[@id='SearchCategoryName']")
	@CacheLookup
	WebElement txtCategoryName;
	
	@FindBy(how=How.XPATH , using="//button[@id='search-categories']")
	@CacheLookup
	WebElement searchCategoryBtn;
	
	@FindBy(how=How.XPATH , using="//table[@id='categories-grid']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;
	
	@FindBy(how=How.XPATH , using="//table[@id='categories-grid']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;
	
	public void enterCategoryName(String ctgname) {
		txtCategoryName.sendKeys(ctgname);
	}
	
	public void clickOnCategorySearchBtn() {
		searchCategoryBtn.click();
	}
	
	
    public int getNoOfRows() {
    	return (tableRows.size());
    }
    
    public int getNoOfColumns() {
    	return (tableColumns.size());
    }
    
    //fetching/searching the category name from the table 
    
    public boolean searchCategoryByName(String name) {
    	boolean flag = false;
    	
    	for(int i=1;i<=getNoOfRows();i++) {
    		String Name = driver.findElement(By.xpath("//table[@id='categories-grid']/tbody/tr[" + i + "]/td[2]")).getText();
    		System.out.println(Name);
    		if(Name.equalsIgnoreCase(name)) {
    			flag=true;
    			break;
    		}
    	}
    	
    	return flag;
    	
    	
    }

}
