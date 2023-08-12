package objectRepository;

import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

    WebDriver driver;
    ConfigFileReader configFileReader;

    public CreateAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        configFileReader = new ConfigFileReader();
    }

    @FindBy(how = How.XPATH, using = "//a[text()='Create an Account']")
    private WebElement createAccount;

    @FindBy(how = How.XPATH, using = "//input[@name='firstname']")
    private WebElement firstName;

    @FindBy(how = How.XPATH, using = "//input[@name='lastname']")
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    private WebElement email;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//input[@name='password_confirmation']")
    private WebElement confirmPassword;

    @FindBy(how = How.XPATH, using = "(//*[@type='submit'])[2]")
    private WebElement submit;

    @FindBy(how = How.XPATH, using = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    private WebElement accountCreationAssert;
    //div[contains(@class,'message-success success')]//div[1]

    public void launchURL(){
        driver.navigate().to(FileReaderManager.getInstance().getConfigReader().getApplicationURL());
    }

    public void createAccount(){
        createAccount.click();
    }

    public void enterFirstName(String fName) {
        firstName.sendKeys(fName);
    }
    public void enterLastName(String lName){
        lastName.sendKeys(lName);
    }
    public void enterEmail(String emailID){
        email.sendKeys(emailID);
    }
    public void enterPassword(String pwd){
        password.sendKeys(pwd);
    }
    public void enterConfirmPassword(String cPwd) { confirmPassword.sendKeys(cPwd); }
    public void submit() { submit.click(); }
    public String accountCreationSuccess(){
        return accountCreationAssert.getText();
    }
}
