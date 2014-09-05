package net.qualifier.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import net.qualifier.model.Student;

public class StudentBean {

	@Autowired
	@Qualifier("student2")
	private Student student;

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public void printStudent(){
		System.out.println("student Name : "+student.getName()+" "+"Age : "+student.getAge());
		
	}

}
