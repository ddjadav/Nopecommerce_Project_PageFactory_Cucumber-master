package Test_Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by kaival on 29/11/2016.
 */

@RunWith(Cucumber.class)

@CucumberOptions(  monochrome = true,
        tags = "@kavya,@dilip",
        features = "src/test/resources/features",
        format = { "pretty","html:target/cucumber-pretty",
                "json:target/cucumber.json" },
        dryRun = false,
        glue = "Test_Runner/Steps" )
//(strict = false, features = &quot;features&quot;, format = { &quot;pretty&quot;,
//        &quot;html:target/site/cucumber-pretty&quot;,
//        &quot;json:target/cucumber.json&quot; }, tags = { &quot;~@ignore&quot; }
//


public class TestRunner {
}
