package JdbcExercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentDAO {
	private final String username;
	private final String password;
	private final String databaseURL;
	
	public StudentDAO() throws Exception {
		username = ConnectionParameters.username;
		password = ConnectionParameters.password;
		databaseURL = ConnectionParameters.databaseURL;
		
	// to load the driver
	try {
		Class.forName(ConnectionParameters.jdbcDriver);
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}
	}
	 // to establish the connection
	
	private Connection openConnection() throws SQLException {
		Connection dbConnection = DriverManager.getConnection(databaseURL, username, password);
		return dbConnection;
	}
	
	// to close the connection
	private void closeConnection(Connection dbConnection) throws SQLException {
		if(dbConnection !=null) {
			dbConnection.close();
		}
	}
	
	
	// get all the students Information ============================================
	public ArrayList<Student> getAllStudent() throws SQLException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Connection dbConnection = null;
		try {
			dbConnection = openConnection();
			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice from Student order by lastname";
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");
				studentList.add(new Student(id, firstname, lastname, streetaddress, postcode, postoffice));
				
			}
			return studentList;
		}catch(SQLException sqle) {
			throw sqle;
		}
		finally {
			closeConnection(dbConnection);
		}
	}
	
	
	
	
	
	// get the student's information by Id =====================================
	
	public ArrayList<Student> getStudentById(int id) throws SQLException {
		ArrayList<Student> studentList = new ArrayList<Student>();
		Connection dbConnection = null;
		
		try {
			dbConnection = openConnection();
			
			String sqlText = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice FROM Student WHERE id = ? ORDER BY firstname";
			
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlText);
			preparedStatement.setInt(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int ids = resultSet.getInt("id");
				String firstname = resultSet.getString("firstname");
				String lastname = resultSet.getString("lastname");
				String streetaddress = resultSet.getString("streetaddress");
				String postcode = resultSet.getString("postcode");
				String postoffice = resultSet.getString("postoffice");

				studentList.add(new Student(ids, firstname, lastname, streetaddress, postcode, postoffice));
			}
			
			return studentList;
			
		} catch (SQLException sqle)	{
			throw sqle;  // Let the caller decide what to do with the exception
			
		} finally {
			closeConnection(dbConnection);
		}
	}
	
	
	
	
	
	// Creating a new Student Data using DAO ===========================================
	
	
	public  void insertStudent() {
		
		
		System.out.println("=== Inserting a new ===");
		
		try {
			Connection dbConnection = openConnection();
			Scanner reader = new Scanner(System.in);
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
			System.out.println("Student Data saved successfully.");
		}catch(SQLException sqle) {
			if(sqle.getErrorCode() == ConnectionParameters.PK_VIOLATION_ERROR) {
				System.out.println("can not insert the student. The student is already exists");
			}
			else {
				System.out.println("=== Database Error ===\n" + sqle.getMessage());
			}
		}
		}
	
	
	
	
	
	
	// Get the student data in JSON format =================================================
	
//	public <JSONObject> void getAllStudentsJson(Student student){
//		List<JSONObject> studentList = new ArrayList<JSONObject>();
//		try {
//			ResultSetMetaData rsMeta = Student.getMetaData();
//		}
//	}

	
	
	
	
	
}
