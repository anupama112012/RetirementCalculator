package Runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/Features",
		glue={"stepDefinition"}
		,monochrome=true
		,plugin = {"pretty","html:test-output"}
		,dryRun=false
		//,tags={"@TC03"}
		)

public class Runner {
 
}
