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
import student.dto.Admin;
import student.dto.Student;
@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet

{@Override
protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException 
{ HttpSession session=req.getSession();
Admin admin=(Admin)session.getAttribute("admin");
if(admin!=null)
{


	//you have to find existing Student from database
	//then sent student to jsp file
	//then get data from jsp and save it
	String StudentId=(String)req.getParameter("studentId");
	//get paramter in string format so storing in string..getting paramter from url so using get parameter method is used
	int id=Integer.parseInt(StudentId);//changing string to int
	StudentDAO dao=new StudentDAO();// creating obj for studentdao class
	Student s=dao.getStudent(id); // creating obj for stu class and calling getstudent method of dao class
	Student student=new Student();
	student.setStudentId(id);
	//System.out.println("1st id"+student.getStudentId());
	
	dao.deleteStudent(s);
	
	//System.out.println("2nd id"+student.getStudentId());
	//System.out.println("inside");
		List<Student> students=dao.getallstudent(admin);
	req.setAttribute("students", students);
	req.getRequestDispatcher("viewstudent.jsp").forward(req, resp);
} else
{
	 resp.sendRedirect("AdminLogin.jsp");
}
} 
}

