package student.dao;




import java.util.Scanner;


import student.dto.Student;

import student.dao.StudentDAO;

public class Driver {
public static void main(String[] args) {
	
	
//	Student student=new Student();
//	student.setStudentId(102);
//	student.setStudentName("Kothai");
//	student.setStudentPhoneNumber(98765468);
//	student.setStudentEmail("ko@gmail");
//    student.setStudentFee(8000);	
	
	//inserting
//	Student student=new Student();
	StudentDAO dao=new StudentDAO();
//	
//	
//	Scanner sc=new Scanner(System.in);
//	System.out.println("enter id");
//	int id=sc.nextInt();
//	System.out.println("enter name");
//	String name=sc.next();
//	System.out.println("enter phonono");
//	long phoneno=sc.nextLong();
//	System.out.println("enter email");
//     String email=sc.next();
//	
//	System.out.println("enter fee");
//	int fee=sc.nextInt();
//	
//	
//	
//	student.setStudentId(id);
//	student.setStudentName(name);
//	student.setStudentPhoneNumber(phoneno);
//	student.setStudentEmail(email);
//   student.setStudentFee(fee);	
//	
//	
//    dao.saveStudent(student);
	
	//fetching one data
    
    
    
	Student student=new Student();
	Scanner sc1=new Scanner(System.in);
	System.out.println("enter id to be fetched");
	int id1=sc1.nextInt();
	student.setStudentId(id1);
	Student i=dao.getStudent(id1);
	System.out.println(i.getStudentName());
	
//	updating data
//	Item user3 =new Item();
//	Scanner sc2=new Scanner(System.in);
//	System.out.println("enter id to be updated");
//	int id2=sc2.nextInt();
//	System.out.println("enter name");
//	String name2=sc2.next();
//	System.out.println("enter quantity");
//	int quantity2=sc2.nextInt();
//	user3.setId(id2);
//	user3.setName(name2);
//	user.setQuantity(quantity2);
//	dao.updateQuantity(user3);
//	
//	
//	//deleting data
//	Item user4 =new Item();
//	Scanner sc3=new Scanner(System.in);
//	System.out.println("enter id to be deleted");
//	int id3=sc3.nextInt();
//	user4.setId(id3);
//	dao.deleteitem(user4);
//	
//}
}
}
