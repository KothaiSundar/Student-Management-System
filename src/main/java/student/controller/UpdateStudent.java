package student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dto.Student;
import student.dao.StudentDAO;

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet

{@Override
protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException 
{
	//you have to find existing Student from database
	//then sent student to jsp file
	//then get data from jsp and save it
	String id=req.getParameter("studentId");
	StudentDAO studentDto =new StudentDAO();
	Student student = studentDto.getStudent(Integer.parseInt(id));
	
	
	req.setAttribute("student", student);
	req.getRequestDispatcher("UpdateStudent.jsp").forward(req, resp);
}
}
