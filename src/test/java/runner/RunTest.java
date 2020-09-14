package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun=false,  // true olursa testi calistirmadan once terminalde her featurin karsiligi var mi onu gosterir
        features="/Users/Eda/Cucumber_iq/src/test/java/features/login.feature",
       glue="stepDefs",
        tags="@login",
       //tags="@multipleUsers",
        plugin={"pretty","html:target/cucumber.html",
        "json:target/cucumber.json"}

)
public class RunTest {
}
