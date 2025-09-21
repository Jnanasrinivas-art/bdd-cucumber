package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
        glue = {"steps","Hooks"},
        plugin = {"pretty","json:target/json-report/cucumber.json"},
        dryRun = false,
        monochrome = true,
        tags = "@P1"
        //name = {"Logo"}
)
public class TestRunner
{

}
