package student.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.dao.AdminDao;
import student.dto.Admin;


@WebServlet("/login")
public class AdminLogin extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
	
	String email =req.getParameter("adminEmail");// getting input by passing key
	String password =req.getParameter("adminPassword");
	
	
	// fetch data based on email from database and validate password
	// and check if it is true or not that is user is present or not
	
	// use query to find data based on email. so create method in admindao to fetch data
	
	Admin admin=new AdminDao().AdminLogin(email,password);// returns a admin obj
	// if that email and password present
	
	if(admin!=null)
		
	{   //before forwarding req and res , send this admindata to savejsp. because to add student to adminlise
		// because admin has stu list. whenever save the stu that stu should present in adm list
		HttpSession session=req.getSession();// getsession() will check if there is any previous session started anywhere
		// before in this project for the particular browser
		// if there is no session found, a new session obj is created or else the existing session obj given
		
		// getsession- singletime obj --that is create one obj is created and if we create new obj also it will return existing obj
		// that is HttpSession will checks if any obj created , if not create only once and that will be used
	
		session.setAttribute("admin", admin);// only once data is set
		// in req --again and again have to set data
		//req.setAttribute("admin", admin);// passing admin obj and then forwarding
		
		req.getRequestDispatcher("Dashboard.jsp").forward(req, res);
	}
	else
	{
		// if no paritucular data found in database, then goes to again signup that is firstsignup and login
		res.sendRedirect("AdminSignUp.jsp");
	}
}
}