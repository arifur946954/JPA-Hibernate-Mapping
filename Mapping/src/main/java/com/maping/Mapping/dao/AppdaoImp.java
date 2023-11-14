package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public class AppdaoImp implements AppDao{
    private EntityManager entityManager;
    @Autowired

    public AppdaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void CreateInstructor(Instructor theInstructor) {
        entityManager.persist(theInstructor);

    }

    @Override
    public Instructor findInstructorById(int theId) {
      Instructor tempInstructor=  entityManager.find(Instructor.class,theId);
        return tempInstructor;
    }

    @Override
    @Transactional
    public void deleteInstructroById(int theID) {
      Instructor tempInstructor=  entityManager.find(Instructor.class,theID);
      entityManager.remove(tempInstructor);


    }
}
