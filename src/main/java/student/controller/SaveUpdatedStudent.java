package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.dao.StudentDAO;
import student.dto.Student;
import student.dto.Admin;
@WebServlet("/saveUpdatedStudent")
public class SaveUpdatedStudent extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{HttpSession session=req.getSession();
	Admin admin=(Admin)session.getAttribute("admin");
	if(admin!=null)
	{

		
		
		int studentId=Integer.parseInt(req.getParameter("studentId"));
	
	String studentName=req.getParameter("studentName");
	String studentEmail=req.getParameter("studentEmail");
	long studentPhoneNumber=Long.parseLong(req.getParameter("studentPhoneNumber"));
	long studentFee=Long.parseLong(req.getParameter("studentFee"));
	
	
	Student student=new Student();
	student.setStudentId(studentId);
	student.setStudentName(studentName);
	student.setStudentPhoneNumber(studentPhoneNumber);
	student.setStudentEmail(studentEmail);
	student.setStudentFee(studentFee);
	student.setAdmin(admin);
	
	new StudentDAO().updateStudent(student);
    List<Student> students=new StudentDAO().getallstudent(admin);
    req.setAttribute("students", students);
	
	req.getRequestDispatcher("viewstudent.jsp").forward(req,resp);
	
}else
{
	 resp.sendRedirect("AdminLogin.jsp");
}
}}