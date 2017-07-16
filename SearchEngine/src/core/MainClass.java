package core;

import java.io.File;
import java.util.Vector;

public class MainClass {

	public static void main(String[] args) {
 
		DirrWorker dw = new DirrWorker("D://Root2");
		FileWorker fw = new FileWorker();
		
		Vector<File> files = dw.getFiles();
		int i = 0;
		for (File file : files) {
			System.out.println(i);
			i++;
			System.out.println(file.getName());
			System.out.println(file.getPath());
			System.out.println(fw.processFile(file));
			
			System.out.println();
			System.out.println(fw.processFile(file).get("fiat"));
		}
	}
	
}
