package com.maping.Mapping;

import com.maping.Mapping.dao.AppDao;
import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {

			//createInstructor(appDao);
			findInstructor(appDao);






		};
	}

	private void findInstructor(AppDao appDao) {
		int theId=7;
		 Instructor theInstructor= appDao.findInstructor(theId);
		System.out.println("Instructor is :"+theInstructor);
		System.out.println("Instructor Detials is: "+theInstructor.getInstructorDetails());
		System.out.println("Done!!!!");
	}

	private void createInstructor(AppDao appDao) {

		Instructor tempInstructor=new Instructor("Test02","Tester","test02@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test02@youtube.com","Plaaying");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		appDao.createInstructor(tempInstructor);
		System.out.println("Instructor Is "+tempInstructor);
		System.out.println("Instructor Details is: "+tempInstructor.getInstructorDetails());
		System.out.println("Done");
	}


}
