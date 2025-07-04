package StepDefinition3;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions

(
		features="src/test/java/FeatureFiles2/",
		glue={"StepDefinition3"},
		tags="@test11 or @test12 or @test13 or @test14 or @test16",
				//tags="@test16",
		dryRun=false,
		monochrome=false,
		plugin= {"pretty","html:target/HtmlReport/index.html",				
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		
		
		
	)


public class TestRunner {
	
	

}
