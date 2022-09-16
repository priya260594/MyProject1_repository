package vTiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {

	public static void main(String[] args) throws SQLException {
		 Driver driverRef = new Driver();
		 Connection con=null;
		    try {
		    	 // step 1: Register the driver
		      DriverManager.registerDriver(driverRef);
		      
		    //step 2 : get the connection with  database
		      con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		      
		    //step 3: issue create statement
		      Statement state = con.createStatement();
		      
		     //step 4 :execute the query
		      ResultSet result = state.executeQuery("select * from student;");
		      
		      while(result.next()) {
		          System.out.println(result.getString(1)); 
		    	  // System.out.println(result.getString(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4));
		      }
		      
		    } catch (Exception e) {
		      
		       }
		    finally {//step-5: close the connection
		    con.close();
		    System.out.println("connection closed");
		    }
		  }
}
