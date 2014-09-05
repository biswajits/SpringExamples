package net.qualifier.main;

import net.qualifier.bean.StudentBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		StudentBean bean = (StudentBean) context.getBean("studentbean");
		bean.printStudent();
	}
}
