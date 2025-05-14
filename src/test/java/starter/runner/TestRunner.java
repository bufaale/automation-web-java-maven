package starter.runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "starter.steps,starter.hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, json:target/site/serenity/serenity.json")
public class TestRunner {
}
