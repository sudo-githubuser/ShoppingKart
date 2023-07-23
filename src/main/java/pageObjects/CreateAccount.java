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


}
