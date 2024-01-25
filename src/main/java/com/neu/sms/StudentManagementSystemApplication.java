package com.neu.sms;

import com.neu.sms.dao.StudentDao;
import com.neu.sms.models.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{
/* https://www.youtube.com/watch?v=Ku3gsv7_bCc&t=2176s - Reference video */

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	StudentDao studentRepository;

	public StudentManagementSystemApplication(StudentDao studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("Shashikar", "Anthoniraj", "shashiantonydbz@gmail.com");
//		studentRepository.save(student1);
//
//		Student student2 = new Student("Emilia", "Clarke", "emilyC@gmail.com");
//		studentRepository.save(student2);
//
//		Student student3 = new Student("Lucy","Heartfilla","LucyHeart@hotmail.com");
//		studentRepository.save(student3);
	}
}
