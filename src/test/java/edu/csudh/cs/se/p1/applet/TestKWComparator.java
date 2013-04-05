package edu.csudh.cs.se.p1.applet;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestKWComparator {

	private KWComparator comparator;
	
	@Before
	public void setUp(){
		comparator = new KWComparator();
	}
	
	@Test
	public void compareScenario1(){
		String s1 = "aB";
		String s2 = "Ab";
		assertTrue(comparator.compare(s1, s2)==-1);
	}
	
	@Test
	public void compareScenario2(){
		String s1 = "aaA";
		String s2 = "Aaa";
		List<String> container = new ArrayList<String>();
		container.add(s2);
		container.add(s1);
		Collections.sort(container, comparator);
		assertNotNull(container);
		assertTrue(container.size() == 2);
		assertEquals(container.get(0), s1);
		assertEquals(container.get(1), s2);
	}
}
