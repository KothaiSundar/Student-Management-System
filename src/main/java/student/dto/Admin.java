package student.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
 
//to maintain records of students---one person is maintaing all records

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int adminId;
	private String adminName;
	@Column(unique=true)// making email as unique
	private String adminEmail;
	private String adminPassword;
	
	@OneToMany(mappedBy = "admin", fetch=FetchType.LAZY)
	// admin maintaing many stud records so one to many
	
	
	List<Student> students;
	public List<Student> getStudent() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
}
