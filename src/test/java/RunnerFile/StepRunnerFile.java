package RunnerFile;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/ResourcesFeatureFiles", glue = { "StepDefinationFiles" },

		plugin = { "pretty", "html:target/cucumber.html" },monochrome = true

)

public class StepRunnerFile extends AbstractTestNGCucumberTests {
	
	
	@Override
	@DataProvider(parallel =  true)
	public Object[][] scenarios()
	{	
		return super.scenarios();
	}

}
