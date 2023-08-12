package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import managers.WebDriverManager;
import objectRepository.CreateAccount;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class CreateAccountStepDef {

    TestContext testContext;
    CreateAccount createAccount;
    //private PageObjectManager pageObjectManager;
    //private WebDriverManager webDriverManager;
    //public ExtentReports exReport;
    //public ExtentTest exTest;
    //String reportPath = new File("").getAbsolutePath().toString().trim()+"/Reports";

    public CreateAccountStepDef(TestContext context){
        testContext = context;
        createAccount = testContext.getPageObjectManager().getCreateAccount();
    }

//    @Before
//    public void beforeScenario(){
//        webDriverManager = new WebDriverManager();
//        //pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
//        createAccount = new CreateAccount(webDriverManager.getDriver());
//        //*********** Extent Report Implementation ***********
//        exReport = new ExtentReports(reportPath+this.getClass().getSimpleName()+".html", false);
//        exTest = exReport.startTest("Extent report testing");
//
//    }

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
    public void accountCreatedSuccessfully() throws InterruptedException {
        System.out.println("Entering accountCreatedSuccessfully page");
        Thread.sleep(6000);
        String actual = createAccount.accountCreationSuccess();
        System.out.println("Actual result: " + actual);
        assertEquals(actual, "Thank you for registering with Main Website Store.");
    }

    @And("Browser is closed")
    public void browserIsClosed() {
        System.out.println("Tested successfully");
    }

//    @After
//    public void afterScenario(){
//        webDriverManager.closeDriver();
//    }

}
