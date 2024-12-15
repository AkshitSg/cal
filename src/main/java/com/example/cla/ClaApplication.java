package com.example.cla;

import com.example.cla.Dao.StudentDao;
import com.example.cla.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			System.out.println("command line runner app started...");

			// creating student
			Student newstudent=new Student("Akshit","Sagar","sagarakshit@yahoo.com");
			studentDao.save(newstudent);
			System.out.println("student created with generated id: "+newstudent.getId());
		};
	}

}
