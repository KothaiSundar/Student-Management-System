package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.dto.Admin;
import student.dto.Student;
import student.dao.StudentDAO;


@WebServlet("/viewstudent")
public class GetAllStudents extends HttpServlet
{
 @Override
 //doget is used because fetching data from server
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
 {     HttpSession session=req.getSession();
 Admin admin=(Admin)session.getAttribute("admin");
 if(admin!=null)
 {
 
 
	 List<Student> students=new StudentDAO().getallstudent(admin);
	 System.out.println("students from db " + students);
	 req.setAttribute("students", students);// to view students---can change"studentslist" in double quotes..anyting in doublequote
	
	 
	 //reqdispatcher----carries req and res from server to jsp
	 //forward method to send or store it in another variable and send
	 req.getRequestDispatcher("viewstudent.jsp").forward(req, resp);
}
 else
 {
	 resp.sendRedirect("AdminLogin.jsp");
 }
 }
}
