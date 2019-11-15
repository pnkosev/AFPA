package com.pn.mongo;

import java.util.List;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDemo {

	public static void main(String[] args) throws Exception {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			@SuppressWarnings("deprecation")
			DB db = mongoClient.getDB("test");
			System.out.println("Connected to DB");
			System.out.println("DB name " + db.getName());
			
			List<String> dbNames = mongoClient.getDatabaseNames();
			System.out.println(dbNames);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Server is ready");
	}

}
