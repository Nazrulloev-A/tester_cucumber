package CukesRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		tags="@viewOrder",
		features ="/Users/abrahamben/Desktop/test/testersolution.com/src/test/resources",
		glue="StepDefinition",
		dryRun =false
		
		)
public class runners {

}
