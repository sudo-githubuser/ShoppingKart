package stepDefinitions;

import com.aventstack.extentreports.model.ScreenCapture;
import cucumber.TestContext;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    TestContext testContext;
    public Hooks (TestContext context) { testContext = context; }
    @Before
    public void setUp(){
        //WebDriver Initialization
    }

    @After
    public void tearDown(){ testContext.getWebDriverManager().closeDriver(); }
//    public void tearDown(Scenario scenario){
//        if(scenario.isFailed()) {
//            final byte[] screenShot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenShot, "image/png", scenario.getName());
//        }
//        testContext.getWebDriverManager().closeDriver();
//    }

    @BeforeStep
    public void beforeStep(){}

    @AfterStep
    public void getScreenshot(Scenario scenario){
        final byte[] screenShot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenShot, "image/png", scenario.getName());
        if(scenario.isFailed()){
            scenario.log("Fail");
        } else { scenario.log("Pass");}
    }
}
