package com.dilip;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student_database.Student;
import student_database.StudentDAO;

/**
 * Servlet implementation class StudentInsertServlet
 */
@WebServlet("/StudentInsertServlet")
public class StudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
		RequestDispatcher rd = request.getRequestDispatcher("StudentInsertPage.jsp");
		rd.forward(request, response);
		
		
		
		
		String id = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String address = request.getParameter("address");
		String postcode = request.getParameter("postcode");
		String postoffice = request.getParameter("postoffice");
		
	

		
		int ids = Integer.parseInt(id);
	
		
		

		
		
		
		

		
		
		
		
		
		
	
		
	
	
		
		StudentDAO studentDAO = null;
		try {
			
			studentDAO  = new StudentDAO();
			studentDAO.insertStudent(ids, fname, lname, address, postcode, postoffice);
			PrintWriter out = response.getWriter();
			out.println("Not able to add");
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("The database is temporarily unavailable. Please try again later. \n");
			System.out.println(e.getMessage());
		}
		
//		
	
		
		
		
		
		// I tried to display the message 
		ArrayList<Student> studentLists = new ArrayList<Student>();
		for(Student s: studentLists ) {
				
				if(ids != s.getId()) {
					request.getRequestDispatcher("display.jsp").forward(request, response);

				}
				
				
			}
		
		
		
		
		
		
		

		
	}
}
