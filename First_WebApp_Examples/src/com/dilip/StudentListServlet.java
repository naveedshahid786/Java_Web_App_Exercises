 package com.dilip;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import student_database.Student;
import student_database.StudentDAO;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		// this is the another way to list all the students without using StudentDAO.
//		try {
//			response.setContentType("text/html");
//			Class.forName("org.mariadb.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a1605328", "a1605328", "raMYcb27w");
//			PreparedStatement ps = con.prepareStatement("Select * from Student");
//			ResultSet rs = ps.executeQuery();
//			PrintWriter out = response.getWriter();
//			out.println("<html><body><table border='1px solid' ><tr><td>id</td><td>firstname</td><td>lastname</td><td>streetaddress</td><td>postcode</td><td>postoffice</td>");
//			while(rs.next()) {
//				out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
//			
//			
//			}
//			out.println("</table></body></html>");
//		
//		
//		}
//		catch(Exception e) {
//			e.getMessage();
//		}
		

		
		List<Student> studentList = null;
		try {
			StudentDAO studentDAO = new StudentDAO();
			studentList = studentDAO.getAllStudent();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("studentList", studentList);
		req.getRequestDispatcher("StudentList.jsp").forward(req, res);
		//RequestDispatcher rd = req.getRequestDispatcher("DeleteStudentServlet");
		//rd.forward(req, res);
		
	
	 
	
}
	
}
