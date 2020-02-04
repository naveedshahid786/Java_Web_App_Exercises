package JdbcExercises;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class SimpleStudentListProgram {

	public static void main(String[] args) {
		String username = ConnectionParameters.username;
		String password = ConnectionParameters.password;
		String databaseURL = ConnectionParameters.databaseURL;
		Connection dbConnection = null;
		
		
		// TODO Auto-generated method stub
		System.out.println("=== students Lists ===");
		
		try {
			dbConnection = DriverManager.getConnection(databaseURL, username, password);
			String sqlText = "SELECT firstname, lastname, streetaddress, postcode, postoffice  FROM Student order by lastname";
			Statement statement = dbConnection.createStatement();
			ResultSet resultSet = statement.executeQuery(sqlText);
			boolean rowFound = false;
			while(resultSet.next()) {
				rowFound = true;
				String fname = resultSet.getString("firstname");
				String lname = resultSet.getString("lastname");
				String address = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");
				System.out.println( fname + " " + lname + ", "+ address + ", "+ postcode + " " + postoffice );
				if(rowFound == false) {
					System.out.println("No more name....");
				}
			}
		}catch(SQLException sqle) {
			System.out.println("==== Database Error ==="+ sqle.getMessage());
		}
		finally {
			if(dbConnection != null) {
				try {
					dbConnection.close();
				} catch(SQLException sqle) {
					System.out.println("==== Database Error ==="+ sqle.getMessage());
				}
			}
		}
	}

}
