package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
        glue = {"steps"},
        plugin = {"pretty","json:reports/Report11"},
        dryRun = true,
        monochrome = true,
        tags = "@P1",
        name = {"Logo"}

)
public class TestRunner
{

}
