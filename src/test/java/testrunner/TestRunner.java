package testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features", glue={"pagesteps"}, tags = {"@addproducttocart"},
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml",
        "html:target/cucumber-reports" }, monochrome = true
)

public class TestRunner {

}
