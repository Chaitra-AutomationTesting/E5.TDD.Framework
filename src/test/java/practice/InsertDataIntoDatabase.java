package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoDatabase {

	public static void main(String[] args) throws SQLException {

		// create object of driver --- database -- mysql db
		Driver driverRef = new Driver();

		// Step 1: Register the driver/database
		DriverManager.registerDriver(driverRef);

		// Step 2: Get connection with Database --- database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");

		// Step 3: Issue create statement
		Statement state = con.createStatement();

		// Step 4: Execute a query --- table name
		String query = "insert into customerinfo values('Chaitra',15,'Banglore');";
		int result = state.executeUpdate(query);
		if(result == 1)
		{
			System.out.println("Data insertion successfull");
		}
		else
		{
			System.out.println("Data not inserted");
		}

		// Step 5: close the database
		con.close();
		System.out.println("DB closed");

	}
	
	
	//insert data
	// validate whether data is inserted thru query

}
