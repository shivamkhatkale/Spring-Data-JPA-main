package com.app.shivam.runner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.shivam.entity.Student;
import com.app.shivam.repository.StudentRepository;

@Component
public class StduentTestRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy");
		String s = sdf.format(new Date());
		System.out.println(s);
		
		Student s1 = new Student();
		s1.setStdName("SAM");
		s1.setStdFee(400.0);
		s1.setStdDoj(new Date());
		repo.save(s1);
		
		
	}

}