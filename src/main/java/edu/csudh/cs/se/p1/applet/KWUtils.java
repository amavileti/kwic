package edu.csudh.cs.se.p1.applet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class KWUtils {

	private static KWComparator comparator = new KWComparator();
	static final String SPACE = " ";
	static final String EMPTY = "";
	static final String NEW_LINE = "\n";
	private static List<Character> acceptableCharacters = new ArrayList<Character>();
	static{
		
		for(char a='a', b='A'; a<='z'&& b<='Z'; a++,b++){
			acceptableCharacters.add(a);
			acceptableCharacters.add(b);
		}
		acceptableCharacters.add(' ');
		acceptableCharacters.add('-');
		acceptableCharacters.add('\n');
	}

	
	public static String joinList(List<String> elements, boolean newLine) {
		if (elements == null || elements.size() == 0) {
			return EMPTY;
		} else {
			StringBuilder result = new StringBuilder();
			if (newLine) {
				Collections.sort(elements, comparator);
			}
			for (int i = 0; i < elements.size(); i++) {
				result.append(elements.get(i));
				if (i < elements.size() - 1) {
					if (newLine) {
						result.append(NEW_LINE);
					} else {
						result.append(SPACE);
					}
				}
			}
			return result.toString();
		}
	}
	
	public static boolean isAlpha(CharSequence cs) {
	        if (cs == null || cs.length() == 0) {
	            return false;
	        }
	        int sz = cs.length();
	        for (int i = 0; i < sz; i++) {
	            if (!acceptableCharacters.contains(cs.charAt(i))) {
	                return false;
	            }
	        }
	        return true;
	    }
}
