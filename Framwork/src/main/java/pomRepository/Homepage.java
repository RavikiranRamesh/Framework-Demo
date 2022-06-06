package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import generic_library.webdriver_utility;

public class Homepage{
	webdriver_utility wlib= new webdriver_utility();
	
	@FindBy(id="service_form_section-service")
	private WebElement searchInput;
	
	@FindBy(xpath="//span[text()='Get started']")
	private WebElement getStartedButton;
	
	/* provided getter method to access */
	
	public WebElement getsearchinput() {
		return searchInput;
	}
	
	public WebElement getstarted() {
		return getStartedButton;
	}
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	/* business logic for home page actions*/
	
	public void homepagestart(WebDriver driver,String service) {
		driver.findElement(By.xpath("//div[text()='"+service+"']")).click();
	}

}
