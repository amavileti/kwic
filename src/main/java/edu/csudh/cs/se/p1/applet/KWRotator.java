package edu.csudh.cs.se.p1.applet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class KWRotator {
	private static final Pattern space = Pattern.compile("\\s+");
	
	public List<String> rotate(String s) throws IllegalArgumentException {
		if (s == null) {
			throw new IllegalArgumentException("Invalid input " + s);
		}
		List<String> result = new ArrayList<String>();
		if (!s.trim().equalsIgnoreCase(KWUtils.EMPTY)) {
			String[] elements = space.split(s.trim());
			List<String> elementsList = new LinkedList<String>();
			for (String str : elements) {
				elementsList.add(str);
			}
			int i = 0;
			while (i < elements.length) {
				elementsList.add(elementsList.remove(0));
				result.add(KWUtils.joinList(elementsList, false));
				i += 1;
			}
		}
		return result;
	}
}
