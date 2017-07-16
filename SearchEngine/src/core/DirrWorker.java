package core;

import java.io.File;
import java.util.Vector;

public class DirrWorker {
	
	private String dirPath;
	private Vector<File> files = new Vector<>();

	public void updateFiles() {
		files.clear();
		update(dirPath);
	}

	public Vector<File> getFiles() {
		return files;
	}

	public DirrWorker(String dirPath) {
		this.dirPath = dirPath;
		updateFiles();
	}

	private void update(String dirPath) {
		File dir = new File(dirPath);
		if (dir.isDirectory()) {
			for (File item : dir.listFiles()) {
				if (item.isFile()) {
					files.add(item);
				} else {
					update(item.getPath());
				}
			}
		}
	}
}