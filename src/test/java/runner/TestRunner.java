package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",		//feature file address in project
		glue="stepDefinations",					//step defination address
		tags="@Test070523",							//scenario which to be run
		stepNotifications=true,					//to know the status of steps as pass/fail/skip in junit report
		monochrome=true,						//---> Clean console report
		plugin= {"pretty","json:target/cucumber.json","html:target/cucumber.html"}	//master thought reporting		//"junit:target/aspire.xml"  "html:target/cucumber.html"
		//plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		//plugin= {"pretty","json:target/json-report/cucumber.json","html:target/cucumber.html"}
		)
public class TestRunner {

}
