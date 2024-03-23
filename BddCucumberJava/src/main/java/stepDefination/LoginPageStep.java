package stepDefination;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LoginPageStep {
	
	WebDriver driver;
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\sayal\\eclipse-workspace\\cucumberjava\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    driver.get("https://www.facebook.com/");
	}
	@When("User Enter EmailID")
	public void user_enter_email_id() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("asdf@gmail.com");
	}
	@And("User Enter Password")
	public void user_enter_password() {
		 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("abc@123");
	}
	@And("User Click on Login button")
	public void user_click_on_login_button() {
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
	@Then("User should be on HomePage")
	public void user_should_be_on_home_page() {
		 String acttitle=driver.getTitle();
		   String exptitle="Log in to Facebook";
		   Assert.assertEquals(exptitle, acttitle);
	}
	@And("User closes browser")
	public void User_closes_browser() throws InterruptedException {
		
		Thread.sleep(5000);
		driver.close();
	}
	@When("User Enter {string} as EmailID")
	public void user_enter_as_email_id(String Emailid) {
		System.out.println(Emailid);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Emailid);
	}
	@When("User Enter {string} as Password")
	public void user_enter_as_password(String Passwd) {
		System.out.println(Passwd);
		 driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Passwd);
	}
	@When("User Enter credentials email and password")
	public void user_enter_credentials_email_and_password(DataTable data) {
	   List<List<String>> d = data.asLists();
	   //outer list--->rows
	   //inner list--->columns/cells
	   String value=d.get(1).get(0);
	   driver.findElement(By.xpath("//input[@id='email']")).sendKeys(d.get(1).get(0));
	   driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(d.get(1).get(1));
	}
	@When("User Enter {string}")
	public void user_enter(String string) {
	   
	}
	//convert string number to actual number format
//@And("User send number {string}")      //use thid method for convert string
//	public void user_enter_number(String s)
//	{
//		int a=Integer.parseInt(s);
//		System.out.println(s+10);
//	}


}
