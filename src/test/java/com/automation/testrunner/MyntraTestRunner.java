package com.automation.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:Feature",
		glue = "com.automation.stepdefs",
		tags = "@search3",
		plugin = {"pretty",
				"html: target/html/htmlrepo.html",
                 "json: target/json/file.json",	
		},
		publish=true,
		dryRun = false
		)

public class MyntraTestRunner {
	
	

}
