package StepDefinations;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(
features="src/test/resources/Feature/deals.feature", 
glue= {"StepDefinations"},
tags = "@instance_1",
plugin = {"pretty","html:target/cucumber-html-report.html"},
dryRun = false, //check whether all the steps from feature files has got methods and implemented or no in Step Definition File
monochrome = true
) 

public class TestRunner {

}
