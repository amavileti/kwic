package edu.csudh.cs.se.p1.applet;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementing custom comparator to sort two strings based on
 * given specification
 * @author Aruna Sri
 *
 */
public class KWComparator implements Comparator<String> {
	
	//Dictionary to be used for comparison
	private Map<Character, Integer> dictionary;
	
	public KWComparator(){
		dictionary = new HashMap<Character, Integer>();
		int i = 10;
		char c1, c2;
		//Populate dictionary map to be used by comparator
		for(c1 = 'a', c2='A'; c1<='z' && c2<='Z'; c1++,c2++,i+=10){
			dictionary.put(c1, i);
			dictionary.put(c2, i+2);
		}
		dictionary.put(' ', 3);
		dictionary.put('-', 5);
	}
	
	public int compare(String o1, String o2) {
		for(int i = 0, j = 0; i < o1.length() && j < o2.length(); i++, j++){
			int i1 = dictionary.get(o1.charAt(i));
			int i2 = dictionary.get(o2.charAt(j));
			if(i1<i2){
				return -1;
			}else if(i1==i2){
				continue;
			}else{
				return 1;
			}
		}
		return 0;
	}

}
