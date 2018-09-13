package com.mulesoft.training;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mule.api.MuleEvent;
import org.mule.tck.junit4.FunctionalTestCase;

public class HelloMavenTest extends FunctionalTestCase {

	@Test
	public void mavenFlowReturnsHelloMaven() throws Exception {
		runFlowAndExpect("mavenFlow", "Hello World by Yugandhar Reddy");
	}

	@Test
	public void retrieveFlightsAddsAppropriateHeader() throws Exception {
		MuleEvent event = runFlow("retriveFlightsFlow");
		String contentType = event.getMessage().getOutboundProperty("Content-Type");
		assertEquals("application/json", contentType);
	}

	@Override
	protected String getConfigFile() {
		return "maven-project3.xml";
	}

}
