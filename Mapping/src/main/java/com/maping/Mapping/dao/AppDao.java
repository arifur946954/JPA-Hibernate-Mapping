package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;

public interface AppDao {
    void createInstructor(Instructor instructor);
    Instructor findInstructor(int theId);
    void deleteInstructor(int theId);
    // one to one bidirectional
    void saveInstructorDetailsByInstructor(InstructorDetails instructorDetails);
}
