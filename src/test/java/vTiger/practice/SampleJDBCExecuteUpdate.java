package vTiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {
		Driver dref=new Driver();
		Connection con=null;
		try {
		//1.register the driver
		DriverManager.registerDriver(dref);
		//2. connection to database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		//3. issue create statement
		Statement statement = con.createStatement();
		//4. execute the query
		String query="insert into student values('ravi',7,90,'Bengaluru')";
		int result = statement.executeUpdate(query);
		System.out.println(result);
		
		String query2="update student set roll_no=2 where name='aishu'";
		int result3=statement.executeUpdate(query2);
		System.out.println(result3);
		
		
		//String query3="delete from student where name='cindrella'";
       // int result5=statement.executeUpdate(query3);
        
		ResultSet result4=statement.executeQuery("select * from student;");
		while(result4.next()) {
			System.out.println(result4.getString(1));
		}
		
		
		} catch(Exception e) {
			
		}
		finally {
		//5. close the connection
			con.close();
			System.out.println("connection closed");
	}
		}

}
