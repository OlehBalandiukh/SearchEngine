package core;

public class MainClass {

	public static void main(String[] args) {
 
		FileWorker fw = new FileWorker();
		//fw.updateDir("D://Root");
		MongoConnection mc = new MongoConnection();
		mc.connect();
	}
}
