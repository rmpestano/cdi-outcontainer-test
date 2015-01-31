
package com.cdi.outcontainer;

import com.rs.jug.bean.MyBean;
import org.apache.deltaspike.core.api.config.ConfigProperty;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MyBeanTestOutcontainer {
	private static Weld weld;
	private static WeldContainer weldContainer;
	
	@Inject
	MyBean myBean2;

	@Inject
	@ConfigProperty(name="test")
	String test;

	@BeforeClass
	public static void setupClass() {
		weld = new Weld();
		weldContainer = weld.initialize();
		System.setProperty("test","test");
	}

	@AfterClass
	public static void teardownClass() {
		weld.shutdown();
	}

	@Test
	public void myBeanShouldBeAlive() {
		MyBean myBean = weldContainer.instance().select(MyBean.class).get();
		assertNotNull(myBean);
		assertTrue(myBean.isAlive());
		assertNull(myBean2);//test enrichers - need CDI started before the test (eg: ds-testctrl or arquillian)

	}

	@Test
	public void shouldInjectSystemProperty(){
		MyBean myBean = weldContainer.instance().select(MyBean.class).get();
		assertEquals(myBean.getTestSystemProperty(), "test");
		assertNull(test);//same as myBean2
	}

}
