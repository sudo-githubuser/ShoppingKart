package managers;

import org.openqa.selenium.WebDriver;
import objectRepository.CreateAccount;

public class PageObjectManager {

    private WebDriver driver;
    private CreateAccount createAccount;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccount getCreateAccount() { return (createAccount == null) ? createAccount = new CreateAccount(driver) : createAccount; }
}
