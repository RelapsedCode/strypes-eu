package strypes;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@strypes",
        plugin = {"pretty", "html:target/strypes-cucumber-report.html", "json:target/strypes-cucumber-report2.json"},
        features = "src/test/features/strypes",
        glue = "strypes.steps")

public class StrypesTestRunner {

}
