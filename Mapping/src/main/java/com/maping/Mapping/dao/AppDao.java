package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;

public interface AppDao {
    void CreateInstructor(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructroById(int theID);
    //One to one bidirectional
    InstructorDetails findInstructorDetailsById(int theId);
    void CreateInstructorDetails(InstructorDetails tempInsDetails);
}
