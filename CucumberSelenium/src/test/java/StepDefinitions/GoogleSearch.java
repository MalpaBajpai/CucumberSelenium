package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearch {

	WebDriver driver = null;

	@Given("^browser is open$")
	public void launchBrowser() {
		// set browser property
		String projectPath = System.getProperty("user.dir");
		System.out.printf("projectPath", projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();// user ctrl + spacebar for auto suggestion
	
	}

	@And("^user is on google search page$")
	public void launchApplication() {
		driver.get("https://www.google.com/");
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().window().maximize();
	}

	@When("^user enters the text in search textbox$")
	public void searchTextbox() {
		driver.findElement(By.name("q")).sendKeys("StepbyStep Automation");
		
	}

	@And("^user press enter$")
	public void pressEnter() {
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("^user navigates to search result$")
	public void searchResult() {
		driver.getPageSource().contains("Online Courses");
	}
	
	@Then("^user closes the browser$")
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
