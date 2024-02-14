package courseManagementSystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import courseManagementSystem.Dblogin.LoginResult;

public class DataBaseExtension {

//	"DELETE FROM course WHERE `course`.`id` = 5"
	
	
	public static void main(String[] args) {
	}
	
	
	
		// Creating course 
		 public static boolean addCourse( String courseName, String seats, String batch, String year) {
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
        		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            String query = " CREATE DATABASE IF NOT EXISTS sms";           
		            stmt.executeUpdate(query);

		            String createTable = "CREATE TABLE IF NOT EXISTS sms.course "
		            		+ "(id INT AUTO_INCREMENT PRIMARY KEY, "		            		
		            		+ "coursename varchar(100),"	            		
							+ "seats varchar(100),"
							+ "batch varchar(100),"																					
		            		+ "year varchar(100))";
		            
		            
//		          Execute the SQL statement to create the table
		            stmt.executeUpdate(createTable);
		            
		            String data = "INSERT INTO sms.course (coursename, seats, batch, year  ) VALUES('" + courseName + "','" +seats + "','" + batch +"', '" + year + "')";          
		            stmt.executeUpdate(data);
	   
		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            return true;
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return false;
		        }
		        		        
	}
		 
		 // edit course data
		 public static int editCourse( String courseId,String courseName, String seats, String batch, String year) {
			 
			 
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
     		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();

		            String query = " CREATE DATABASE IF NOT EXISTS sms";           
		            stmt.executeUpdate(query);

		            String createTable = "CREATE TABLE IF NOT EXISTS sms.course "
		            		+ "(id INT AUTO_INCREMENT PRIMARY KEY, "		            		
		            		+ "coursename varchar(100),"	            		
							+ "seats varchar(100),"
							+ "batch varchar(100),"																					
		            		+ "year varchar(100))";
		            
		            
//		          Execute the SQL statement to create the table
		            stmt.executeUpdate(createTable);
		            
		            String updateQuery = "UPDATE sms.course SET "
		                    + "coursename = '" + courseName + "', "
		                    + "seats = '" + seats + "', "
		                    + "batch = '" + batch + "', "
		                    + "year = '" + year + "' "
		                    + "WHERE id = " + courseId;


		            int res = stmt.executeUpdate(updateQuery);
		            		            
	   
		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            return res;
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return 0;
		        }
			 
		 }
		 
		 // Check email exist or not in database
		 public static boolean checkEmail(String email,  String userType) {
		       String url = "jdbc:mysql://localhost"; 
		       String username = "root";
		       String password = "";
			
		          boolean check = false;   
		      
		       try {
		           Connection con = DriverManager.getConnection(url, username, password);	           
		           Statement stmt = con.createStatement();	           
		           String query = "select * from sms." + userType;
		           ResultSet rs = stmt.executeQuery(query);
  	   
		           while(rs.next()) {

		        	   String demail = rs.getString(3);


		        	   if(demail.equals(email) ) { 	   
		            	  
	            	   check = true;
	                   break;  
		  
		        	   }
		           }

		           if (check) {
		        	   System.out.println("email exists");
		        	   return true;
		        	  
		           } else {
		               
		        	   System.out.println("email NOt exists");
		           return false;
		              
		           }
		       }
				
				catch (SQLException e) {

					 System.out.println("email NOt exists");
		           e.printStackTrace();
		           return false;
		       }

		       
			 }
		 
		 
		 
		 // delete course 
		 public static boolean deleteCourse(String id) {
			 
		        String url = "jdbc:mysql://localhost"; 
		        String username = "root";
		        String password = "";
     		        
		        try {
		            Connection con = DriverManager.getConnection(url, username, password);
		            
		            Statement stmt = con.createStatement();


		            
		            String data = "DELETE FROM sms.course WHERE id = '" + id + "'";

		           int res =  stmt.executeUpdate(data);
		            

	   
		            System.out.println("\nsuccessfully"); 
		            		           
		            stmt.close();
		            con.close();
		            
		            if(res == 1) {
		            	return true;
		            }
		            else {
		            	return false;
		            }
		         
		            
		        } catch (SQLException e) {
		        	
		            e.printStackTrace();
		            return false;
		        }

		 }


}
