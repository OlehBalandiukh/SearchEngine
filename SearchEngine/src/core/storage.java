package core;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class storage {
	private Map<String, Vector<String>> localStorage = new HashMap<String, Vector<String>>();
	
	public void addFileWords (String [] fileWords){
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		for (int i = 0; i < fileWords.length; i++) {
			if (!hm.containsKey(fileWords[i])) {
				hm.put(fileWords[i], 1);
			} else {
				hm.put(fileWords[i], (Integer) hm.get(fileWords[i]) + 1);
			}
		}
		
		
//		for (int i = 0; i < fileWords.length; i++) {
//			if (!localStorage.containsKey(fileWords[i])) {
//				Vector<String> passes = new Vector<>();
//				passes.addElement("bmw.txt");
//				localStorage.put(fileWords[i], passes);
//			} else {
//				localStorage.put(fileWords[i], (String) hm.get(fileWords[i]) + 1);
//			}
//		}
	}
	
}
