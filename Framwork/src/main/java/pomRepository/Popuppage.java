package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic_library.webdriver_utility;
/**
 * 
 * @author Ravikiran
 *This is page object module for pop ups page of the application
 */

public class Popuppage {
	
	
	@FindBy(xpath="//button[text()='Next']")
	private WebElement proceedButton;
	
	@FindBy(xpath="//div[text()='Toilet']/preceding-sibling::div/child::div")
	private WebElement clickForProblemAreaCheckbox;
	
	@FindBy(xpath="//button[@data-test='next_button']")
	private WebElement clickNextButton;
	
	@FindBy(xpath="//input[@type='checkbox']/following-sibling::div[text()='Replace']")
	private WebElement clickWhatneedToBeDoneCheckbox;
	
	@FindBy(xpath="//input[@type='checkbox']/following-sibling::div[text()='Leak in a pipe']")
	private WebElement clickWhatProblemCheckbox;
	
	@FindBy(xpath="//button[text()='Skip']")
	private WebElement clickSkipButton;
	
	@FindBy(xpath="//div[text()='On a specific date']/preceding-sibling::div/child::div")
	private WebElement clickRequirePlumberCheckbox;
	
	@FindBy(xpath="//input[@placeholder='Full name (Name & Surname)']")
	private WebElement fullNameTextField;
	
	
	public void selectDate(WebDriver driver, String month, String date, String year) {
		WebElement day = driver.findElement(By.xpath("//button[contains(@aria-label,'"+month+" "+date+", "+year+"')]"));
		day.click();
	}
    
	@FindBy(xpath="//select[@data-test='step_time']")
	private WebElement selectTimeInDropdown;
	
	@FindBy(id="cityId")
	private WebElement selectcity;
	
	@FindBy(xpath="//div[text()='Hyderabad']")
	private WebElement clickOnCity;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	private WebElement emailTextField;

	/* provided getters method for access */ 
	
	public WebElement getProceedButton() {
		return proceedButton;
	}

	public WebElement getClickForProblemAreaCheckbox() {
		return clickForProblemAreaCheckbox;
	}

	public WebElement getClickNextButton() {
		return clickNextButton;
	}

	public WebElement getClickWhatneedToBeDoneCheckbox() {
		return clickWhatneedToBeDoneCheckbox;
	}

	public WebElement getClickWhatProblemCheckbox() {
		return clickWhatProblemCheckbox;
	}

	public WebElement getClickSkipButton() {
		return clickSkipButton;
	}

	public WebElement getClickRequirePlumberCheckbox() {
		return clickRequirePlumberCheckbox;
	}

	public WebElement getSelectTimeInDropdown() {
		return selectTimeInDropdown;
	}

	public WebElement getSelectcity() {
		return selectcity;
	}

	public WebElement getClickOnCity() {
		return clickOnCity;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}
	
	public WebElement getFullNameTextField() {
		return fullNameTextField;
	}
	
	public Popuppage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	/**
	 * This Method will provides a way for user to enter the required data
	 * @param driver
	 * @param month
	 * @param date
	 * @param year
	 * @param text
	 * @param city
	 * @param emailid
	 * @throws Throwable
	 */
	
	public void popuppActions(WebDriver driver, String month,String date,String year, String text,String city,String emailid) throws Throwable {
		
		webdriver_utility wlib=new webdriver_utility();
		wlib.waitForElementToBeVisible(driver, proceedButton);
		proceedButton.click();
		wlib.waitForElementToBeVisible(driver, clickForProblemAreaCheckbox);
		clickForProblemAreaCheckbox.click();
		clickNextButton.click();
		wlib.waitForElementToBeVisible(driver, clickWhatneedToBeDoneCheckbox);
		clickWhatneedToBeDoneCheckbox.click();
		clickNextButton.click();
		wlib.waitForElementToBeVisible(driver, clickWhatProblemCheckbox);
		clickWhatProblemCheckbox.click();
		clickNextButton.click();
		wlib.waitForElementToBeVisible(driver, clickSkipButton);
		clickSkipButton.click();
		wlib.waitForElementToBeVisible(driver, clickRequirePlumberCheckbox);
		clickRequirePlumberCheckbox.click();
		clickNextButton.click();
		wlib.waitForElementToBeVisible(driver, clickNextButton);
		selectDate(driver, month, date, year);
		clickNextButton.click();
		wlib.waitForElementToBeVisible(driver, clickNextButton);
		wlib.selectbyVisibleText(selectTimeInDropdown, text);
		clickNextButton.click();
		wlib.waitForElementToBeVisible(driver,emailTextField);
		emailTextField.sendKeys(emailid);
		clickNextButton.click();
		
		Thread.sleep(2000);
		
	}
	
	/**
	 * This Method will validate whether fullName Text Field is Displayed or not
	 */
	
	public void validation() {
		
		Assert.assertTrue(fullNameTextField.isDisplayed(),"FullName TextField is Not Displayed");
		
	}
}
