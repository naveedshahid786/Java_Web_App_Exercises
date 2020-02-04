package JdbcExercises;

import java.sql.SQLException;
import java.util.ArrayList;


public class StudentListProgram {

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
