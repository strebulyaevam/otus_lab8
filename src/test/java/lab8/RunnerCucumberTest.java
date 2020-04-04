package lab8;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features.lab8",
        glue = "lab8",
//        tags = "@Test",
        dryRun = false,
        strict = false
)
public class RunnerCucumberTest {
}
