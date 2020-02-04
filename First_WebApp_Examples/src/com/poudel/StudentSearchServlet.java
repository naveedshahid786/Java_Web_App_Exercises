package com.poudel;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_database.Student;
import student_database.StudentDAO;

/**
 * Servlet implementation class StudentSearchServlet
 */
@WebServlet("/StudentSearchServlet")
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int givenId = -1;
		
		// to retrieve the student Id from User
		
		String ids = request.getParameter("studentId");
		
		if(ids != null) {
			try {
				givenId = Integer.parseInt(ids);
			} catch (Exception ex) { }
			
		}
		
		List<Student> studentList = null;
		
		if (givenId > 0) {
			StudentDAO studentDAO = null;
			try {
				studentDAO = new StudentDAO();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				studentList = studentDAO.getStudentById(givenId);
				// this is just to check the data is picked up or not as student in console.
				System.out.println(studentList);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		
		
	
		request.setAttribute("studentList", studentList);
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("StudentSearch.jsp").forward(request, response);

		
		
		
		
	}

}
