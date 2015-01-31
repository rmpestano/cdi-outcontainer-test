
package com.cdi.outcontainer;

import com.rs.jug.bean.MyBean;
import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(CdiTestRunner.class)
public class DSBeanTestOutcontainer {

	@Inject
	MyBean myBean;

	@Inject
	@ConfigProperty(name="test")
	String test;

	@Inject
	@ConfigProperty(name="mykey")
	String propertyFromFile;

	@BeforeClass
	public static void setupClass() {
		System.setProperty("test","test");
	}


	@Test
	public void myBeanShouldBeAlive() {
		assertNotNull(myBean);
		assertTrue(myBean.isAlive());
	}

	@Test
	public void shouldInjectSystemProperty(){
		assertEquals(myBean.getTestSystemProperty(), "test");
		assertEquals(test, "test");
		assertEquals(myBean.getPropertyFromFile(), "test from file");
		assertEquals(propertyFromFile, "test from file");
	}

}
