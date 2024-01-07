package mongoJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
//import com.mongodb.client.MongoClients;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class javamongo { 
	
	  static final String DB_URL = "jdbc:mysql://localhost:3306/abhi";
	   static final String USER = "root";
	   static final String PASS = "abhi123";
	   
   public static void main( String args[] ) {  
      
      // Creating a Mongo client 
	   try {
	   MongoClient mongo = MongoClients.create("mongodb://localhost:27017");  
	   System.out.println("MongoDB Connection is succesfully");
	   MongoDatabase database = mongo.getDatabase("myDb");
	   
//	   Connection mysqlConnection = (Connection) DriverManager.getConnection(
//               "jdbc:mysql://localhost:3306/mySQLDatabase", // Replace with your MySQL database URL
//               "root", // Replace with your MySQL username
//               "abhi123" // Replace with your MySQL password
//       );

	      // Get the collection
	      MongoCollection<Document> collection = database.getCollection("mangoJava");

	      Document document = new Document("First_Name", "Mahesh")
	         .append("Last_Name", "Parashar")
	         .append("Date_Of_Birth", "1990-08-21")
	         .append("e_mail", "mahesh_parashar.123@gmail.com")
	         .append("phone", "9034343345");

	      collection.insertOne(document);
	      
	      System.out.println("Documents inserted.");
	      
	      
//	      collection.updateOne(Filters.eq("First_Name","Mahesh"),
//	    	      Updates.set("e_mail", "maheshparashar@gmail.com"));
//	    	      System.out.println("Document Updated.");
//	    	      System.out.println("***Updated Document***");
	      
	            try{		      
	    	         // Execute a query
	            	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            	System.out.println("MySQL Connection is succesfully");
	    	         System.out.println("Inserting records into the table...");          
	    	         String sql = "Insert into students(rollno,name) values(101,'Ram')";
	    	         Statement stmt = (Statement) conn.createStatement();
	    	         stmt.execute(sql);
	    	         System.out.println("Inserted records into the table...");   	  
	    	      }catch (Exception e) {
	    	           e.printStackTrace();
	    	       }  	      
	    	      
	   } catch (Exception e) {
           e.printStackTrace();
       }
   } 
}