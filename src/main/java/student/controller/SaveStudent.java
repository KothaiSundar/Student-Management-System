package student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.dto.Student;
import student.dao.StudentDAO;
import student.dto.Admin;
import student.dao.AdminDao;

@WebServlet("/save")
public class SaveStudent extends HttpServlet{
@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{// name of variable should in same in .java file and .jsp file in input
	
	HttpSession session=req.getSession();
	 Admin admin=(Admin) session.getAttribute("admin");
	 if(admin!=null)
	 {
	String name=req.getParameter("studentName");
	String StringPhoneNumber=req.getParameter("studentPhoneNumber");
	String email=req.getParameter("studentEmail");
	
	long PhoneNumber=Long.parseLong(StringPhoneNumber);
	
	ServletContext context=getServletContext();
	String fee=context.getInitParameter("StudentFee");
	
	long studentFee=Long.parseLong(fee);
	// fee same for all so given in context-param in web.xml
	
	Student student=new Student();
	student.setStudentName(name);
	student.setStudentPhoneNumber(PhoneNumber);
	student.setStudentEmail(email);
	student.setStudentFee(studentFee);
	//before saving student setting  admin for students
	student.setAdmin(admin);
	
	
	new StudentDAO().saveStudent(student);
	//after saving student assign student to related admin
	//send redirect is used because we are not sending any data to dashboard.
	//getting preexisting students list from admin
	List<Student> students=admin.getStudent();
	//new student added to same list
	students.add(student);
	new AdminDao().updateStudentList(admin);
	resp.sendRedirect("Dashboard.jsp");
	}
	
else
{
resp.sendRedirect("AdminLogin.jsp");	
	
}
}
}