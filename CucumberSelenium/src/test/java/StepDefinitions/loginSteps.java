package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginSteps {

	public void verifyLoginPage() {

	}

	@Given("^User want to launch the amazon application$")
	public void user_want_to_launch_the_application() {
		System.out.println("inside launch step");
		//throw new io.cucumber.java.PendingException();
	}

	@And("I wil verify if application launched sucessfully")
	public void i_wil_verify_if_application_launched_sucessfully() {
		System.out.println("step2");
		//throw new io.cucumber.java.PendingException();
	}

	@When("I enter name1 and password1")
	public void i_enter_name1_and_password1() {
		System.out.println("step3");
		//throw new io.cucumber.java.PendingException();
	}

	@And("I click on login button")
	public void i_click_on_login_button() {
		System.out.println("step4");
		//throw new io.cucumber.java.PendingException();
	}

	@Then("I validate login email address")
	public void i_validate_login_email_address() {
		System.out.println("step5");
		//throw new io.cucumber.java.PendingException();
	}

}
