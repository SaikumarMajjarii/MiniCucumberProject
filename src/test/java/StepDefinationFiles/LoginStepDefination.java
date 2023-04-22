package StepDefinationFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import OpenCartPages.OpenCartLoginPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefination {

	private WebDriver Driver;
	private OpenCartLoginPages LP;

	@Before
	public void LaunchChrome() {

		Driver = new ChromeDriver();

		Driver.manage().window().maximize();
	}

	@After
	public void tearDown() {
		if (Driver != null) {
			Driver.quit();
		}
	}

	@Given("^User Should be On OpenCart Page$")
	public void user_should_be_on_opencart_page() throws Throwable {
		Driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		LP = new OpenCartLoginPages(Driver);
	}
	
	@Given("User Should be Able to Login with Valid {string} and {string}")
	public void user_should_be_able_to_login_with_valid_and(String username, String password) {
		LP.enterEmail(username);
		LP.enterPassword(password);
	}



	@Given("^User Should be Able to Login with inValid (.+) and (.+)$")
	public void user_should_be_able_to_login_with_invalid_and(String username, String password) throws Throwable {

		
		LP.enterEmail(username);
		LP.enterPassword(password);
	}

	@When("^User Should be able to do login$")
	public void user_should_be_able_to_do_login() throws Throwable {
		LP.clickLoginButton();
	}

	@Then("^User Should be able to Logged In Successfully$")
	public void user_should_be_able_to_logged_in_successfully() throws Throwable {

		Assert.assertEquals(LP.checkLogoutLink(), true);
	}

	@Then("^I should see an error message indicating (.+)$")
	public void i_should_see_an_error_message_indicating(String errormessage) throws Throwable {
		Assert.assertEquals(Driver.findElement(By.cssSelector(".alert-danger")).isDisplayed(), true);
	}
	
    @When("I click on the \"Forgotten Password\" link")
    public void i_click_on_the_forgotten_password_link() {
        LP.clickForgottenPasswordLink();
    }

    @Then("I should be redirected to the password reset page")
    public void i_should_be_redirected_to_the_password_reset_page() {
        // Assert that the current URL contains the password reset page route
        Assert.assertTrue(LP.getForgotPwdPageUrl().contains("account/forgotten"));
    }
}
