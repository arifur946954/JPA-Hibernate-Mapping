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
    public void createInstructor(Instructor instructor) {
        entityManager.persist(instructor);

    }

    @Override
    public Instructor findInstructor(int theId) {
     Instructor theInstructor=   entityManager.find(Instructor.class,theId);
        return theInstructor;
    }
}
