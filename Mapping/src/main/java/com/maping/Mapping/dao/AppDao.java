package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;
import jakarta.persistence.criteria.CriteriaBuilder;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInsuni(int theId);
    void deleteInsUni(int theId);
    Instructor updateInstructorUni(Instructor theInstructor);
    InstructorDetails findInsDetBi(int theId);
    void deleteInstDetBi(int theId);
}
