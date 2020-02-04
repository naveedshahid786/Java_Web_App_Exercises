package JdbcExercises;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentSearchProgram {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		StudentDAO dao = new StudentDAO();
		System.out.print("Enter student id: ");
		Scanner reader = new Scanner(System.in);
		int x = reader.nextInt();
		try {
			ArrayList<Student> s1 = dao.getStudentById(x);
			
			for(Student s : s1) {
				System.out.println(s.id +", "+ s.lastname+ " " +s.firstname +  ", " + s.streetaddress +", "+ s.postcode + " " + s.postoffice);
			}
			if(s1.isEmpty()) {
				System.out.print("Unknown Student id (" + x + ")");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

}

