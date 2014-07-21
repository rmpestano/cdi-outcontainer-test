
package com.cdi.outcontainer;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.rs.jug.bean.MyBean;

@RunWith(JUnit4.class)
public class MyBeanTestOutcontainer {
	private static Weld weld;
	private static WeldContainer weldContainer;
	
	@Inject
	MyBean myBean2;

	@BeforeClass
	public static void setupClass() {
		weld = new Weld();
		weldContainer = weld.initialize();
	}

	@AfterClass
	public static void teardownClass() {
		weld.shutdown();
	}

	@Test
	public void dummyTest() {
		MyBean myBean = weldContainer.instance().select(MyBean.class).get();
		assertNotNull(myBean);
		assertTrue(myBean.isAlive());
		assertNull(myBean2);//test enrichers
	}

}
