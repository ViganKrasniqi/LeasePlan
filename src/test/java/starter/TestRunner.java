package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"starter.stepdefinitions"},
        tags = "@Leaseplan_TaskID_1009341",
        features = "src/test/resources/features"
)
public class TestRunner {
}
