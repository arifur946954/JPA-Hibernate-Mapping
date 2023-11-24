package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Course;
import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;
import com.maping.Mapping.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDaoImp implements AppDao{
    private EntityManager entityManager;
    @Autowired

    public AppDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void createInstructor(Instructor instructor) {
        entityManager.persist(instructor);

    }

    @Override
    public Instructor findInstructor(int theId) {
     Instructor theInstructor=   entityManager.find(Instructor.class,theId);
        return theInstructor;
    }

    @Override
    @Transactional
    public void deleteInstructor(int theId) {
      Instructor tempInstructor=  entityManager.find(Instructor.class,theId);
      entityManager.remove(tempInstructor);

    }

    @Override
    @Transactional
    public void saveInstructorDetailsByInstructor(InstructorDetails instructorDetails) {
        entityManager.persist(instructorDetails);

    }



    @Override
    public Course findCourseById(int theId) {
      Course tempCourse=  entityManager.find(Course.class,theId);
        return tempCourse;

    }


    @Override
    public List<Course> findCourseWithIns(int theId) {
        TypedQuery<Course> query=entityManager.createQuery(
                "from Course where instructor.id=:data", Course.class);
        query.setParameter("data",theId);
        List<Course> courses=query.getResultList();
        return courses;


    }

    @Override
    public Instructor findInstructorWithCourse(int theId) {
        TypedQuery<Instructor> query=entityManager.createQuery(
                """
                        
                select i from Instructor i 
                JOIN FETCH i.course
                where i.id=:data
        
                """ , Instructor.class);
        query.setParameter("data",theId);
        Instructor instructor=query.getSingleResult();



        return instructor;
    }

    @Override
    @Transactional
    public void saveReviewWithCourse(Course theCourse) {
        entityManager.persist(theCourse);

    }


}
