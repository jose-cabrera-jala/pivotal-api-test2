package org.fundacionjala.pivotalapi.runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = {"src/test/resources/"},
        glue = {"org.fundacionjala.pivotalapi"})
public class Runner {

}