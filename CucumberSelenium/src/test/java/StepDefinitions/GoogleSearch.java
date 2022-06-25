package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		driver.get("https://p7185168c1prd-admin.occa.ocs.oraclecloud.com/occs-agent/apc#!/redirect?redirectURL=agentHome");
		driver.manage().timeouts().getImplicitWaitTimeout();
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().window().maximize();
	}

	@When("^user enters the text in search textbox$")
	public void searchTextbox() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("cc-loginForm-CC-propertyEditor-shortText-login-field")).clear();
		driver.findElement(By.id("cc-loginForm-CC-propertyEditor-shortText-login-field")).sendKeys("joshi.akshay@sleepcountry.ca");
		Thread.sleep(2000);
		driver.findElement(By.id("cc-loginForm-CC-propertyEditor-password-password-field")).sendKeys("@Malpa123");
		Thread.sleep(2000);
		//driver.findElement(By.name("q")).sendKeys("joshi.akshay@sleepcountry.ca");
		
	}


	@And("^user press enter$")
	public void pressEnter() {
		driver.findElement(By.id("cc-login-btn")).click();
		//driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("^user navigates to search result$")
	public void searchResult() throws InterruptedException {
		
		WebElement order = driver.findElement(By.xpath("//a[@title='Orders']"));
		WebElement failedStatus = driver.findElement(By.id("cc-search-criteria-orderstatus"));
		WebElement searchBtn = driver.findElement(By.id("cc-search-button"));

		    WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(200000));
			wait.until(ExpectedConditions.visibilityOf(order));
			
		    order.click();
		    
		    wait.until(ExpectedConditions.visibilityOf(failedStatus));
			Select status = new Select(failedStatus);
			status.selectByVisibleText("Failed");
			
			wait.until(ExpectedConditions.visibilityOf(searchBtn));
			searchBtn.click();
			
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,4000)");
			
			WebElement Element = driver.findElement((By.xpath("//*[@id='cc-paginated-controls-bottom']//a[5]")));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) Element));
    		Element.click();
    		
    		Thread.sleep(2000);
    		
    		
		//driver.getPageSource().contains("Online Courses");
	}
	


	@Then("^user closes the browser$")
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
