package core;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

public class MainClass {

	public static void main(String[] args) {

		DirrWorker dw = new DirrWorker("D://Root2");
		FileWorker fw = new FileWorker();

		Vector<File> files = dw.getFiles();
		//int i = 0;
		// for (File file : files) {
		// System.out.println(i);
		// i++;
		// System.out.println(file.getName());
		// System.out.println(file.getPath());
		// System.out.println(fw.processFile(file));
		//
		// System.out.println();
		// System.out.println(fw.processFile(file).get("fiat"));
		// }

		Storage st = new Storage();

		for (File file : files) {

			Map<String, String> words = fw.processFile(file);

			for (Map.Entry<String, String> entry : words.entrySet()) {
				// String key = entry.getKey();
				// String value = entry.getValue();

				st.addItem(entry);
			}
		}
		
		for (Entry<String, Vector<String>> entry : st.items.entrySet()) {
			 String key = entry.getKey();
			 Vector<String> value = entry.getValue();
			 
			 System.out.println(key);
			 System.out.println(value);
			 System.out.println();
			 

		}
	}

}
