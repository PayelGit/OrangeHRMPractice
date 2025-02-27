package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/java/features",
        glue="stepDefinitions",
        plugin = {"pretty","html:target/htmlreport.html"},
        monochrome = true, dryRun = true
        )
class TestNGRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios()
        {
                return super.scenarios();
        }


}
