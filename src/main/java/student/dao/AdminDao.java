package student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import student.dto.Admin;
public class AdminDao {

	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sigma");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public void AdminSignUp(Admin admin)
	{
		et.begin();
		em.persist(admin);
		et.commit();
	}
	
	public Admin AdminLogin(String email, String password)
	{// try catch - used---if wrong email and password is used goes to catch and retrun null
		try
		{Query query=em.createQuery("select a from Admin a where a.adminEmail=?1 and a.adminPassword=?2");
		// can write anything instead of a 
		//?=placeholder , 1 is index value
		// storing it in query obj of type Query
		query.setParameter(1,email);// cmg in method as arguments
		query.setParameter(2, password);// cmg in method as arguments
		//password to confirm that user that is to validate
		
		Admin admin=(Admin) query.getSingleResult();//gives particular obj in particular query-fetching single result
		//getresult list- getting data in list form and have one partiular data and iterate it
		return admin;
		}
		catch(Exception e)
		{return null;
}
	}

	public void updateStudentList(Admin admin) {
		et.begin();
		em.merge(admin);
		et.commit();
	}
		
	
}