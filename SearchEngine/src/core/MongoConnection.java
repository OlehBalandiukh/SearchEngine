package core;

import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	public void connect() {
		//connect to DB server
		MongoClient mongoClient = new MongoClient ("locachost", 27017);
		System.out.println("Server connection successfuly done");	
		
		//connect to DB
		MongoDatabase db = mongoClient.getDatabase("test");
		System.out.println(db.getName());
		
		//get all DBs names
		List<String> dbNanes = mongoClient.getDatabaseNames();
		System.out.println(dbNanes);
		
	}
}
