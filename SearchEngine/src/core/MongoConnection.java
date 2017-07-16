package core;

import java.lang.reflect.Array;
import java.util.Arrays;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;

public class MongoConnection {

	private MongoClient mongo = null;
	private DBCollection table = null;

	@SuppressWarnings("deprecation")
	public void connectDB() {
	    MongoCredential mongoCredential = 
	    		MongoCredential.createScramSha1Credential("admin", "admin","admin".toCharArray());
		mongo = new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(mongoCredential));
		
		DBObject ping = new BasicDBObject("ping", "1");
		try {
			mongo.getDB("dbname").command(ping);
			} catch (MongoException e) {
				System.out.println("Connection ERROR");
				e.printStackTrace();
				mongo.close();
			}
	}
	
	@SuppressWarnings("deprecation")
	public void connectTable() {
		DB db = mongo.getDB("test");
		table = db.getCollection("testcoll");
		table.drop();
	}
	
	public void addElement() {
		

		
		BasicDBObject element1 = new BasicDBObject();
		BasicDBObject element2 = new BasicDBObject();
		element1.put("word", "Oleh");
		element1.put("age", "19");
		
		Integer[] a = {1,2,3};
		
		element2.put("word", "Oleh");
		element2.put("age", a);
 		
		table.insert(element1);
		table.insert(element2);
		
		
		//DBObject doc = table.findOne(element2);

		
		DBObject listItem = new BasicDBObject("age", new BasicDBObject("type","quiz").append("score",99));
		DBObject updateQuery = new BasicDBObject("$push", listItem);
		
		table.update(element2, updateQuery);
		
		
		

		
	}
	
	
}
