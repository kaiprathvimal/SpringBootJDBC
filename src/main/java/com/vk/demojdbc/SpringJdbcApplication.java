package com.vk.demojdbc;

import com.vk.demojdbc.model.Student;
import com.vk.demojdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		Student st = context.getBean(Student.class);
		st.setRollNo(101);
		st.setName("Vimal");
		st.setMarks(60);
//		System.out.println("Roll NO: " + st.getRollNo());
//		System.out.println("Name : " + st.getName());
//		System.out.println("Mark : " + st.getMarks());
		StudentService ss = context.getBean(StudentService.class);
		ss.addStudent(st);
		List<Student> students = ss.getStudents();
		System.out.println(students);

	}

}
