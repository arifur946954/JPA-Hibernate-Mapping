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
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return  runner->{
			//One To One Unidirectional mapping
			//createInstructor(appDao);
			//findInstuctorById(appDao);
			//deleInstructor(appDao);
			//updateInstructor(appDao);

			//OnwToOneBiDirectional Mapping
			//findInstructorDetails(appDao);
			deleteInstructroDetails(appDao);


		};
	}

	private void deleteInstructroDetails(AppDao appDao) {
		int theId=6;
		appDao.deleteInstDetBi(theId);
	}

	private void findInstructorDetails(AppDao appDao) {
		int theId=5;
	InstructorDetails tempInstructorDetail=	appDao.findInsDetBi(theId);
		System.out.println("InstructorDrtails is:"+tempInstructorDetail);
		System.out.println("Instructor is :"+tempInstructorDetail.getInstructor());
		System.out.println("Done!!!!!!!!");

	}

	private void updateInstructor(AppDao appDao) {
		int theId=6;
		Instructor tempInstructor=new Instructor("update","updated","update@gmail.com");
		appDao.updateInstructorUni(tempInstructor);
		System.out.println(tempInstructor);
	}

	private void deleInstructor(AppDao appDao) {
		int theId=7;
		appDao.deleteInsUni(theId);
		System.out.println("done!!!!");
	}

	private void findInstuctorById(AppDao appDao) {
		int theId=1;
	Instructor tempInstructor=	appDao.findInsuni(theId);
		System.out.println("Instructor is :"+tempInstructor);
		System.out.println("Instructor details is :"+tempInstructor.getInstructorDetails());


	}

	private void createInstructor(AppDao appDao) {
		Instructor theInstructor=new Instructor("Test5","Testr","test5@gmail.com");
		InstructorDetails theInstructorDetails=new InstructorDetails("test5@youtube.com","playing");
		theInstructor.setInstructorDetails(theInstructorDetails);
		appDao.save(theInstructor);
		System.out.println("Instructor is: "+theInstructor);
		System.out.println("instructor Details is: "+theInstructor.getInstructorDetails());
	}

}
