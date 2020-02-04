package JdbcExercises;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class SimpleStudentSearchProgram {

	public static void main(String[] args) {
		String username = ConnectionParameters.username;
		String password = ConnectionParameters.password;
		String databaseURL = ConnectionParameters.databaseURL;
		Connection dbConnection = null;
		
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter Student id: ");
		int x = reader.nextInt(); 
		try {
			dbConnection = DriverManager.getConnection(databaseURL, username, password);
			String sqlText = "SELECT id, firstname, lastname, streetaddress, postoffice, postcode FROM Student where id = ?";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1,x);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			boolean rowfound = false;
			while(resultSet.next()) {
				rowfound = true;
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");
				System.out.println( id + " "+ firstname + " "+ lastname + ", "+ streetaddress+ ", "+ postcode + " " + postoffice );
			}
		}
		catch(SQLException sqle) {
			System.out.println("===Database Error ===" + sqle.getMessage());
		} finally {
			if(dbConnection != null) {
				try {
					dbConnection.close();
				} catch(SQLException sqle) {
					System.out.println("\nClose connection failed \n"+ sqle.getMessage());
				}
			}
		}
	}

}
