package plumbing;

import org.testng.annotations.Test;
import generic_library.Baseclass;
import generic_library.Excel_utility;
import pomRepository.Homepage;
import pomRepository.Popuppage;
import pomRepository.professionalsNearYou;
/**
 * 
 * @author Ravikiran
 * 
 * Manual Test steps
 * 
 * step1:  launch browser with application url - "Home page" is displayed
 * Step2:  Click on "plumber" service in home page - "plumbers near you" page is displayed
 * Step3:  select "Hyderabad" by entering into "where" text field - "few question" pop up is displayed
 * Step4:  Click "Next" Button on "few question" pop up - "problem area" pop up is displayed
 * Step5:  Click on "Toilet" Check box and then click on "Next" button - "What you need" pop up is displayed
 * Step6:  Click on "Replace" Check box and then click on "Next" button - "What problem" pop up is displayed
 * Step7:  Click on "Leak in a pipe" check box and then click on "Next" button - "anything else" pop up is displayed
 * Step8:  Click on "skip" button - "when do you require plumber" pop up is displayed
 * Step9:  Select on "Specific date" radio button and then click on "Next" button - "on what date" pop up and "calendar" is displayed
 * Step10: Select "date" on "calendar" and then click on "Next" button - "what time you need" pop up and select time text field is displayed
 * Step11: select "Time" from the select time drop down and then click on "Next" button - "Email id" pop up with email id Text field is displayed
 * Step12: Enter email id in email Text field and then click on "Next" button - "please introduce yourself" pop up is displayed
 * Step13: validate whether "FullName" Text field is present in "please introduce yourself" pop up.
 * Step14: Quit from the application.
 * */
public class PlumbingTest extends Baseclass {
	/**
	 * Test Script used to Validate End to End Scenario in StarOfService application mentioned in Manual Test Steps
	 * @throws Throwable
	 */
@Test
public void plumbingTest() throws Throwable {
	Excel_utility elib=new Excel_utility();
	
	String service=elib.getExceldata("Sheet1", 1, 0);
	String month = elib.getExceldata("Sheet1", 1, 1);
	String date=elib.getExceldata("Sheet1", 1, 2);
	String year=elib.getExceldata("Sheet1", 1, 3);
	String time=elib.getExceldata("Sheet1", 1, 4);
	String city=elib.getExceldata("Sheet1", 1, 5);
	String emailid=elib.getExceldata("Sheet1", 1, 6);
	
	/* Navigate to Plumber Page from Homepage */
	Homepage hp=new Homepage(driver);
	hp.homepagestart(driver, service);
	
	/* Select Particular City and Navigates to Popups */
	professionalsNearYou gp = new professionalsNearYou(driver);
	gp.selectCityName(driver, city);
	
	/* User provides required datas for the particular popups */
	Popuppage pop= new Popuppage(driver);
	pop.popuppActions(driver,month, date, year, time, city, emailid);
	
	/* Validates whether FullName TextField is Displayed or not */
	pop.validation();
		
	}
}
