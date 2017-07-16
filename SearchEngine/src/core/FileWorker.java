package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileWorker {

	private Scanner sc;

	public String validate(String entity) {
		entity = entity.toLowerCase().replaceAll("[']", "");
		entity = entity.toLowerCase().replaceAll("[^\\w]", "");
		return entity;
	}

	public HashMap<String, String> processFile(File entity) {
		HashMap<String, String> fileWords = new HashMap<>();
		try {
			sc = new Scanner(entity);
			while (sc.hasNext()) {
				fileWords.put(validate(sc.next()), entity.getPath());
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
			e.printStackTrace();
		}
		return fileWords;
	}

}