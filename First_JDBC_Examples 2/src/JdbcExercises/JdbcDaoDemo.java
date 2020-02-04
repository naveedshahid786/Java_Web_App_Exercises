// This is just ot practise to understand the written code.

package JdbcExercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class JdbcDaoDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StudentDaos dao = new StudentDaos();
		
		try {
			ArrayList<Student> s1 = dao.getAllStudent();
			
			for(Student s : s1) {
				System.out.println( s.lastname+ " " +s.firstname +  ", " + s.streetaddress +", "+ s.postcode + " " + s.postoffice);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


class StudentDaos {
	private final String username;
	private final String password;
	private final String databaseURL;
	
	public StudentDaos() throws Exception {
		username = ConnectionParameters.username;
		password = ConnectionParameters.password;
		databaseURL = ConnectionParameters.databaseURL;
	
	try {
		Class.forName(ConnectionParameters.jdbcDriver);
	}catch(Exception ex) {
		System.out.println(ex.getMessage());
	}
	}
	
	
	private Connection openConnection() throws SQLException {
		Connection dbConnection = DriverManager.getConnection(databaseURL, username, password);
		return dbConnection;
	}
	
	private void closeConnection(Connection dbConnection) throws SQLException {
		if(dbConnection !=null) {
			dbConnection.close();
		}
	}
	
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
	
	
	
	
//	public Student<Student> getStudent(int id) {
//		ArrayList<Student> studentList = new ArrayList<Student>();
//		Connection dbConnection = null;
//		
//		
//		try {
//			String querry = "SELECT id, firstname, lastname, streetaddress, postcode, postoffice from Student";
//			Student s = new Student(id, querry, querry, querry, querry, querry);
//			s.id = id;
//			Class.forName("org.mariadb.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a1605328", "a1605328", "raMYcb27w");
//			Statement st = con.createStatement();
//			ResultSet rs = st.executeQuery(querry);
//			boolean rowFound = false;
//			while(rs.next()) {
//				rowFound = true;
//				int id2 = rs.getInt("id");
//				
//				s.id = id;
//				s.lastname = lastname;
//				s.firstname = firstname;
//				s.streetaddress = streetaddress;
//				s.postcode = postcode;
//				s.postoffice = postoffice;
//				studentList.add(new Student(id2, lastname, firstname, streetaddress, postcode, postoffice));
//				return s;
//			}
//		
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
//		return null;
//	}
}

//
//class Student {
//	int id;
//	String lastname;
//	String firstname;
//	String streetaddress;
//	String postcode;
//	String postoffice;
//	public Student(int id, String lastname, String firstname, String streetaddress, String postcode,
//			String postoffice) {
//		
//		this.id = id;
//		this.lastname = lastname;
//		this.firstname = firstname;
//		this.streetaddress = streetaddress;
//		this.postcode = postcode;
//		this.postoffice = postoffice;
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getLastname() {
//		return lastname;
//	}
//	public void setLastname(String lastname) {
//		this.lastname = lastname;
//	}
//	public String getFirstname() {
//		return firstname;
//	}
//	public void setFirstname(String firstname) {
//		this.firstname = firstname;
//	}
//	public String getStreetaddress() {
//		return streetaddress;
//	}
//	public void setStreetaddress(String streetaddress) {
//		this.streetaddress = streetaddress;
//	}
//	public String getPostcode() {
//		return postcode;
//	}
//	public void setPostcode(String postcode) {
//		this.postcode = postcode;
//	}
//	public String getPostoffice() {
//		return postoffice;
//	}
//	public void setPostoffice(String postoffice) {
//		this.postoffice = postoffice;
//	}
//	@Override
//	public String toString() {
//		return id + " " + firstname + " " + lastname + " " + streetaddress + " " + postcode + " " + postoffice;
//	}
//	
//	
//	
//	
//}