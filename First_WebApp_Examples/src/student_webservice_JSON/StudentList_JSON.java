package student_webservice_JSON;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import student_database.StudentDAO;
import student_database.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentList_JSON
 */
@WebServlet("/StudentList_JSON")
public class StudentList_JSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		StudentDAO studentDAO = null;
		try {
			studentDAO = new StudentDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Student> studentList = null;
		try {
			studentList = studentDAO.getAllStudent();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String jsonString = null;
		 for(Student student: studentList) {
			 if(jsonString == null) {
				 jsonString = "{\"students\": [";
			 }
			 else {
				 jsonString += ",";
			 }
			 
			 jsonString +=  "{"+ "\"id\": " + student.getId() + ", ";
			 jsonString += "\"firstname\":\"" + student.getFirstname() + "\", ";
			 jsonString +=  "\"lastname\":\"" + student.getLastname() + "\", ";
			 jsonString +=  "\"streetaddress\":\"" + student.getStreetaddress() + "\", ";
			 jsonString +=  "\"postcode\": \" " + student.getPostcode() + "\", ";
			 jsonString +=  "\"postoffice\":\"" + student.getPostoffice() + "\"}";

			 
		 }
		jsonString += "]}";
		out.println(jsonString);
		
	}

}
