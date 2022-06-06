package pomRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Ravikiran
 * This is page object module for professionals near you page of the application
 */

public class professionalsNearYou {

	@FindBy(name="postal_code_input")
	private WebElement whereTextField;
	
	@FindBy(xpath="//button[contains(text(),'Go')]")
	private WebElement goButton;

	/* provide getter method for access */
	
	public WebElement getWhereTextField() {
		return whereTextField;
	}

	public WebElement getGoButton() {
		return goButton;
	}
	
	public professionalsNearYou(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This Method allow to select the Particular city 
	 * @param driver
	 * @param city
	 */
	public void selectCityName(WebDriver driver, String city) {
		whereTextField.sendKeys(city);
		List<WebElement> cityDD = driver.findElements(By.xpath("//div[@class='autocomplete-suggestion']"));
		for (WebElement ele : cityDD) 
		{
			if (ele.getText().equalsIgnoreCase(city))
			{
			ele.click();
			break;
			}
		
		}

	}
		
}
