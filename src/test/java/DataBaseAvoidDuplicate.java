import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataBaseAvoidDuplicate {

	@Test
	public void avoidDuplicate() throws InterruptedException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name");
		String name=sc.next();
		Driver dref=new Driver();
		Connection con = null;
		boolean flag=false;
		try {
		
		DriverManager.registerDriver(dref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
		System.out.println("successfully connected to databse");
		Statement stat=con.createStatement();
		
//	    String query1="create table mycreation1(names varchar(30));";
//	    System.out.println("table created");
//		int result1=stat.executeUpdate(query1);
//		System.out.println(result1);
		String query="select * from mycreation1;";
		ResultSet result=stat.executeQuery(query);
		while(result.next()) {
			if(name.equals(result.getString(1))) {
			flag=true;
			break;
			}
		}
		if(flag==true) {
			System.out.println("Data is present");
		}
		else {
			System.out.println("Data is not present");
		String insertQuery="insert into mycreation1 values('"+name+"');";
			int insertResult=stat.executeUpdate(insertQuery);
		    System.out.println(insertResult +"record is inserted");
			}
		
		}
		catch(Exception  e) {
			e.printStackTrace();
		}
	
		finally {
		    con.close();
		    System.out.println("connection closed");
		    }

		
	}
}
