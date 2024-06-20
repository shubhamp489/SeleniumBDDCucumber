package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features"},
		glue= {"steps"},
		plugin= {"pretty","html:target/cucumber-reports"},
		dryRun = false,
		
		monochrome=true    //basically use for the display output in better way
		,tags= "@P2"
		
		)



public class TestRunner {
}
//strict = true means its is compulsory to have step defination file