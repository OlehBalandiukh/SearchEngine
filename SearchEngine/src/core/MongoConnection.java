package core;

import java.rmi.UnknownHostException;
import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	public void connect() {
//		//connect to DB server
//		MongoClient mongoClient = new MongoClient ("locachost", 27017);
//		System.out.println("Server connection successfuly done");	
//		
//		//connect to DB
//		MongoDatabase db = mongoClient.getDatabase("test");
//		System.out.println(db.getName());
//		
//		//get all DBs names
//		List<String> dbNanes = mongoClient.getDatabaseNames();
//		System.out.println(dbNanes);
		
		Mongo mongo = null;
		DB db = null;
		DBCollection table = null;
		
		try{
			mongo = new Mongo("locachost", 27017);
		} catch(UnknownHostException e){
			e.printStackTrace();			
		}
		
		db = mongo.getDB("test");
		table = db.getCollection("testcoll");
		
		table.drop();
		
	}
}
