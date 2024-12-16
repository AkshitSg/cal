package com.example.cla;

import com.example.cla.Dao.StudentDao;
import com.example.cla.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class ClaApplication {
	@Autowired
	StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(ClaApplication.class, args);
	}
	@Bean
	public CommandLineRunner clr(StudentDao studentDao){
		return runner->{

			System.out.println("Command line runner app started...");
			System.out.println("Starting student creation process...");
			// creating students
			createStudent(studentDao);
		};
	}
	private void createStudent(StudentDao studentDao){

		Student s1=new Student("Akshit","Sagar","sagarakshit@yahoo.com");
		Student s2=new Student("Amritesh","Singh","singhamritesh@yahoo.com");
		Student s3=new Student("Drishti","Dabral","dabraldrishti@yahoo.com");

		System.out.println("Saving students in database.");

		saveStudentsInDB(studentDao,s1);
		saveStudentsInDB(studentDao,s2);
		saveStudentsInDB(studentDao,s3);

		List<Student> allStudents= new ArrayList<>();
		allStudents=studentDao.findAll();

//		allStudents.add(readStudent(studentDao,s1.getId()));
//		allStudents.add(readStudent(studentDao,s2.getId()));
//		allStudents.add(readStudent(studentDao,s3.getId()));

//		Read student by lastname
		List<Student>filteredStudents=studentDao.findByLastName(s1.getLastName());
		for (Student s:filteredStudents){
			System.out.println("found student with last name: "+s1.getLastName()+ ": "+s);
		}

		for(Student student:allStudents){
			System.out.println(student);
		}
	}
	private void saveStudentsInDB(StudentDao studentDao, Student student){
		studentDao.save(student);
		System.out.println("Student saved with id:"+student.getId());
	}
	private Student readStudent(StudentDao studentDao, Integer studentid){
		return studentDao.findById(studentid);
	}

}
