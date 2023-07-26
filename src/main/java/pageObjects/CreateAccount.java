package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import elementsLibrary.ElementIdentifiers;

public class CreateAccount {

    WebDriver driver;

    public CreateAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ElementIdentifiers ei = new ElementIdentifiers();
    @FindBy(how = How.XPATH, using = ei.createAccount)
    private WebElement createAccount;

    @FindBy(how = How.XPATH, using = ei.firstName)
    private WebElement firstName;

    @FindBy(how = How.XPATH, using = ei.lastName)
    private WebElement lastName;

    @FindBy(how = How.XPATH, using = ei.email)
    private WebElement email;

    @FindBy(how = How.XPATH, using = ei.password)
    private WebElement password;

    @FindBy(how = How.XPATH, using = ei.confirmPassword)
    private WebElement confirmPassword;

    @FindBy(how = How.XPATH, using = ei.submit)
    private WebElement submit;

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
    public void enterConfirmPassword(String cPwd){
        confirmPassword.sendKeys(cPwd);
    }
    public void submit(){
        submit.click();
    }
}
