package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"features"},
        glue = {"steps","Hooks"},
        plugin = {"pretty","html:reports/Report14.html"},
        dryRun = false,
        monochrome = true,
        tags = "@P356"
        //name = {"Logo"}
)
public class TestRunner
{

}
