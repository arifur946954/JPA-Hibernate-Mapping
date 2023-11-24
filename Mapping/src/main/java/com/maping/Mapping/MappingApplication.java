package com.maping.Mapping;

import com.maping.Mapping.dao.AppDao;
import com.maping.Mapping.entity.Course;
import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;
import com.maping.Mapping.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner -> {

			//createInstructor(appDao);
			//findInstructor(appDao);
			//deleteInstructor(appDao);
			//ONE TO ONE BYDIRECTIONAL
			//createInstructorDetails(appDao);

			//ONE TO MANY UNIDIRECTIONAL
			//createCourseByIns(appDao);
			//finCourseById(appDao);
			//findCourseIns(appDao);
			//one to many unidirecironal
			//createReviewWithCrs(appDao);
			removeReview(appDao);
			//removeCourse(appDao);






		};
	}

	private void removeCourse(AppDao appDao) {
		int theId=13;
		appDao.deleteCourseWithReview(theId);
		System.out.println("Done!!!!!");
	}

	private void removeReview(AppDao appDao) {
		int theId=6;
		appDao.delteReview(theId);
		System.out.println("Done!!!!!");
	}

	private void createReviewWithCrs(AppDao appDao) {
		Course tempCourse=new Course("CSE-104");
		Review tempReview1=new Review("Course is just owww");
		Review tempReview2=new Review("Course is so intermidite");
		Review tempReview3=new Review("Course is good");
		  tempCourse.add(tempReview1);
		tempCourse.add(tempReview2);
		tempCourse.add(tempReview3);
		appDao.saveReviewWithCourse(tempCourse);

		System.out.println("Course is :"+tempCourse);
		System.out.println("Review is :"+tempCourse.getReviews());
		System.out.println("Done!!!!!!");

	}

	private void findCourseIns(AppDao appDao) {
		int theId=10;
		List<Course> cr= appDao.findCourseWithIns(theId);
		System.out.println("Course is"+cr);
	}

	private void finCourseById(AppDao appDao) {
		int theId=10;
	Course theCourse=	appDao.findCourseById(theId);
		System.out.println("Course is"+theCourse);
	}

	private void createCourseByIns(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Test08","Tester","test08@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test08@youtube.com","Plaaying");
		tempInstructor.setInstructorDetails(tempInstructorDetails);
		//appDao.createInstructor(tempInstructor);
		Course tempCourse1=new Course("CSE-106");
		Course tempCourse2=new Course("EEE-106");
		Course tempCourse3=new Course("IPE-106 ");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

	    appDao.createInstructor(tempInstructor);


		//appDao.createInstructor(tempInstructor);

		System.out.println("Instructor is :"+tempInstructor);
		System.out.println("Instructor details is :"+tempInstructorDetails);
		System.out.println("Course is "+tempInstructor.getCourses());
		System.out.println("Done!!!!!!!");




	}

	private void createInstructorDetails(AppDao appDao) {
		Instructor tempInstructor=new Instructor("Test03","Tester","test03@gmail.com");
		InstructorDetails tempInstructorDetails=new InstructorDetails("test03@youtube.com","Plaaying");
		   tempInstructorDetails.setInstructor(tempInstructor);
		   appDao.saveInstructorDetailsByInstructor(tempInstructorDetails);
		System.out.println("Instructor Details is: "+tempInstructorDetails);
		System.out.println("Instructor is: "+tempInstructorDetails.getInstructor());
		System.out.println("Done!!!!!!!!");


	}

	private void deleteInstructor(AppDao appDao) {
		int theId=6;
		appDao.deleteInstructor(theId);
		System.out.println("Done!!!!!!!!!");

	}

	private void findInstructor(AppDao appDao) {
		int theId=4;
		 Instructor theInstructor= appDao.findInstructor(theId);
		System.out.println("Instructor is :"+theInstructor);
		List<Course> crs= appDao.findCourseWithIns(theId);
		System.out.println("Course is: "+crs);

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
