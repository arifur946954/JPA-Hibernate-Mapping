package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AppDaoImp implements AppDao{
    private EntityManager entityManager;
    @Autowired

    public AppDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Instructor theInstructor) {
         entityManager.persist(theInstructor);



    }

    @Override
    public Instructor findInsuni(int theId) {
     Instructor tempInstructor=   entityManager.find(Instructor.class,theId);
        return tempInstructor;
    }

    @Override
    @Transactional
    public void deleteInsUni(int theId) {
      Instructor tempInstructor=  entityManager.find(Instructor.class,theId);
      entityManager.remove(tempInstructor);


    }

    @Override
    @Transactional
    public Instructor updateInstructorUni(Instructor theInstructor) {
        entityManager.merge(theInstructor);

        return null;
    }
}
