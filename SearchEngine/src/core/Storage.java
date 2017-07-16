package core;


import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Storage {
	public HashMap<String, Vector<String>> items = new HashMap<>();
	
	public void addItem(Map.Entry<String, String> entry) {
		
		if(items.get(entry.getKey())== null){
			Vector<String> temp = new Vector<>();
			temp.addElement(entry.getValue());
			items.put(entry.getKey(),temp);
		}
		else {
			
			items.get(entry.getKey()).add(entry.getValue());
		}
		
	}
	
	public void getItemByWord() {
		
	}
	
	public void getItemByPath() {
		
	}
	
}
