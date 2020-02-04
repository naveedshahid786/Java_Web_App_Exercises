package JdbcExercises;
import java.util.Scanner;
import java.sql.*;
public class SimpleStudentInsertProgram {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		String username = ConnectionParameters.username;
		
		String password = ConnectionParameters.password;
		String databaseURL = ConnectionParameters.databaseURL;
		Connection dbConnection = null;
		
		System.out.println("=== Inserting a new ===");
		
		try {
			dbConnection = DriverManager.getConnection(databaseURL, username, password);
			String sqlText = "INSERT INTO Student (id, firstname, lastname, streetaddress, postcode, postoffice) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			System.out.println("Enter Student data");
			System.out.print("Id: ");
			int id = reader.nextInt();
			
			System.out.print("First name: ");
			String firstname = reader.next();
			System.out.print("Last name: ");
			String lastname = reader.next();
			System.out.print("Street: "); 
			String streetaddress = reader.next();
			reader.next();
			System.out.print("Postcode: ");
			String postcode = reader.next();
			reader.nextLine();
			
			System.out.print("postoffice: ");
			String postoffice = reader.next();
			
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, firstname);
			preparedStatement.setString(3, lastname);
			preparedStatement.setString(4, streetaddress);
			preparedStatement.setString(5, postcode);
			preparedStatement.setString(6, postoffice);
			
			preparedStatement.executeUpdate();
			System.out.println("The student data is successfully inserted.");
			
		}catch(SQLException sqle) {
			if(sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("can not insert the student. The student is already exists");
			}
			else {
				System.out.println("=== Database Error ===\n" + sqle.getMessage());
			}
		}finally {
			if(dbConnection != null) {
				try {
					dbConnection.close();
				}catch(SQLException sqle) {
					System.out.println("\nClose Connection failed \n" + sqle.getMessage());
				}
				
			}
		}
		
		// TODO Auto-generated method stub

	}

}
