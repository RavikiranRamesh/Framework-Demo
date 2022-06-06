package generic_library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

/**
 * 
 * @author Ravikiran
 * 
 *It contains WebDriver specific reusable actions
 *
 */
public class webdriver_utility {
	/**
	 * this method is used to select drop down based on index
	 * @param element
	 * @param index
	 */
	
	public void selectbyIndex(WebElement element,int index) {
		Select select=new Select(element);
	    select.selectByIndex(index);
		
	}
	/**
	 * this method is used to select drop down based on visible text
	 * @param driver
	 * @param target
	 */
   public void selectbyVisibleText(WebElement element,String Text) {
	   Select select=new Select(element);
	   select.selectByVisibleText(Text);
   }
  /**
   * this method is used to perform using mouse overing
   * @param driver
   * @param target
   */
   public void mouseOveron(WebDriver driver,WebElement target) {
	   Actions action=new Actions(driver);
	   action.moveToElement(target).perform();
   }
  /**
   * This method is used to wait until page get loaded
   * @param driver
   */
   public void WaitforpagetoLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   }
  /**
   * This method is used to Maximize the window(fullScreen)
   * @param driver
   */
   public void maximizeWindow(WebDriver driver) {
	   driver.manage().window().maximize();
   }
   /**
    *This method is used to wait until the required element is to be visible 
    * @param driver
    * @param ele
    */
   public void waitForElementToBeVisible(WebDriver driver,WebElement ele) {
	   WebDriverWait wait = new WebDriverWait(driver, 20);
	   wait.until(ExpectedConditions.elementToBeClickable(ele));
   }
}
