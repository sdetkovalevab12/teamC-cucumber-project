package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ConfigReader;
import utils.DBUtils;
import utils.Driver;

import java.time.Duration;

public class Hooks {

    @Before ("@DB")
    public  void setupScenarioDB()  {
        DBUtils.createConnection();
    }

    @After ("@DB")
    public  void tearDownScenarioDB()  {
        DBUtils.close();
    }

    @Before("not @db_only")
    public  void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait"))));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @After
    public  void tearDownScenario(Scenario scenario){

        if(scenario.isFailed()){
            byte[] screenshotFile = ((TakesScreenshot) (Driver.getDriver())).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotFile, "image/png", "screenshot" );
        }

        Driver.quitDriver();
    }
}
