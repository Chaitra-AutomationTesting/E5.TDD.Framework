package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabase {
	
	public static void main(String[] args) throws SQLException {
		
		//create object of driver --- database -- mysql db
		Driver driverRef = new Driver();
		
		//Step 1: Register the driver/database
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get connection with Database --- database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		
		//Step 3: Issue create statement
		Statement state = con.createStatement();
		
		//Step 4: Execute a query --- table name
		ResultSet result = state.executeQuery("select * from customerinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}	
	
		//Step 5: close the database
		con.close();
		System.out.println("DB closed");
		
		
	}

}
