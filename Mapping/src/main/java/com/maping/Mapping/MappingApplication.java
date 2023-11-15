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
			//one to one uniDirectional
			//saveInstructor(appDao);
			//findInstructorbyId(appDao);
			//deletenstructor(appDao);
			//biDirectional mapping
			//findInstrctorDetails(appDao);
			createInstructorDetails(appDao);


		};
	}

	private void createInstructorDetails(AppDao appDao) {
		InstructorDetails tempInsDetails=new InstructorDetails("shahin@youtube.com","singing");
		Instructor tempInstructor=new Instructor("shahin","Afridi","shahin@gmail.com");
		tempInsDetails.setInstructor(tempInstructor);
		appDao.CreateInstructorDetails(tempInsDetails);
		System.out.println("Instructor Details is: "+tempInsDetails);
		System.out.println("Instructor Detail is: "+tempInsDetails.getInstructor());
		System.out.println("Done!!!!!!");

	}

	private void findInstrctorDetails(AppDao appDao) {
		int theId=2;
	InstructorDetails tempInsDetails=	appDao.findInstructorDetailsById(theId);
		System.out.println("Instructor Details is "+tempInsDetails);
		System.out.println("instructor is: "+tempInsDetails.getInstructor());
		System.out.println("Done");
	}

	private void deletenstructor(AppDao appDao) {
		int theId=5;
		appDao.deleteInstructroById(theId);
		System.out.println("delete successfully");
	}

	private void findInstructorbyId(AppDao appDao) {
		int theId=2;
	Instructor theInstructor=	appDao.findInstructorById(theId);
		System.out.println("Instructor is: "+theInstructor);
		System.out.println("Instructor Details is :"+theInstructor.getInstructorDetails());
	}

	private void saveInstructor(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Test3","Rahman","tes3@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test3@youtube.com","football");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		appDao.CreateInstructor(tempInstructor);
		System.out.println("Instructor is:"+tempInstructor);
		System.out.println("Instructor detials is :"+tempInstructor.getInstructorDetails());
		System.out.println("Done!!!!!");
	}


}
