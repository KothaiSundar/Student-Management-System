package student.dao;



	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityManagerFactory;
	import javax.persistence.EntityTransaction;
	import javax.persistence.Persistence;
	import javax.persistence.Query;

import student.dto.Student;
import student.dto.Admin;
	public class StudentDAO {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sigma");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		public void saveStudent(Student student)
		{
			et.begin();
			em.persist(student);
			et.commit();
		}
		
		public void updateStudent(Student student) 
		{
	       
	        
	        et.begin();
	        em.merge(student);
	        et.commit();
	      }
		
		public Student getStudent(int id)
		{
			return em.find(Student.class,id);
		}
		public List<Student> getallstudent(Admin admin)
	
		{// every schooladmin have diff students- so to get one admin belonging to that studdnts alone
			//admin is varible in stu dto
			//in jpql--?-placeholder 1 is index value
			
			//query.setParameter(1,adminId);--wrong
			//admin is obj(non primitive) cannot compare to primitive
			//so compare it with admin obj not with id
			Query query=em.createQuery("select i from Student i where i.admin=?1");
			query.setParameter(1,admin);//index value=1
			List student=query.getResultList();
			return student;
		}
		public void deleteStudent(Student student)
		{
			et.begin();
			em.remove(student);
			et.commit();
	}
		//or can have delete student method in this format 
		//	public void deleteStudent(Student id)
		//{
//			et.begin();
//			em.remove(em.find(Student.class,id)); finding id by using find method of em obj and passing directly in remove
//			et.commit();
//	}
		// if we use this type of deletestu method i.e passing id alone, then in delete student.java
		
		//String StudentId=(String)req.getParameter("studentId");
		//int id=Integer.parseInt(StudentId);
		//StudentDAO dao=new StudentDAO();
		//dao.deleteStudent(id);  //deleteing id
		//List<Student> students=dao.getallstudents(); //storing in students variable
		//req.setAttribute("students",students);   //setting that is passing students
		//req.getRequestDIspatcher("viewstudents.jsp").forward(req,resp);//sending to viewstu.jsp
	}	
		
		
	

