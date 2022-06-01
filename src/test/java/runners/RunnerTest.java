package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features",
        glue = "src/test/java/tests/test_task1/stepDefinitions",
        tags = "@all",
        dryRun = false
)
public class RunnerTest {
}
