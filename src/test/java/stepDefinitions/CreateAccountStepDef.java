package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepository.CreateAccount;

import static org.testng.Assert.assertEquals;

public class CreateAccountStepDef {

    TestContext testContext;
    CreateAccount createAccount;

    public CreateAccountStepDef(TestContext context){
        testContext = context;
        createAccount = testContext.getPageObjectManager().getCreateAccount();
    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        createAccount.launchURL();
    }

    @When("User clicks on create an account")
    public void userClicksOnCreateAnAccount() {
        createAccount.createAccount();
    }

    @And("Enter first name {string}")
    public void enterFirstName(String fName) {
        createAccount.enterFirstName(fName);
    }

    @And("Enter last name {string}")
    public void enterLastName(String lName) {
        createAccount.enterLastName(lName);
    }

    @And("Enter email {string}")
    public void enterEmail(String mail) {
        createAccount.enterEmail(mail);
    }

    @And("Enter password {string}")
    public void enterPassword(String pwd) {
        createAccount.enterPassword(pwd);
    }

    @And("Confirm password {string}")
    public void confirmPassword(String cPwd) throws InterruptedException {
        createAccount.enterConfirmPassword(cPwd);
        Thread.sleep(4000);
    }

    @And("Submit")
    public void submit() { createAccount.submit(); }

    @Then("Account created successfully")
    public void accountCreatedSuccessfully() {
        System.out.println("Assertion step entered");
        String actual = createAccount.accountCreationSuccess();
        System.out.println("Actual result: " + actual);
        assertEquals(actual, "Thank you for registering with Main Website Store.");
        System.out.println("Assertion step exited");
    }

    @And("Browser is closed")
    public void browserIsClosed() {
        System.out.println("Tested successfully");
    }
}
