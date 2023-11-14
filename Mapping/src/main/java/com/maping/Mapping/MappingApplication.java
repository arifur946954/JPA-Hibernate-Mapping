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
			saveInstructor(appDao);

		};
	}

	private void saveInstructor(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Arifur","Rahman","arif@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("arif@youtube.com","cricket");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		appDao.CreateInstructor(tempInstructor);
		System.out.println("Instructor is:"+tempInstructor);
		System.out.println("Instructor detials is :"+tempInstructor.getInstructorDetails());
		System.out.println("Done!!!!!");
	}


}
