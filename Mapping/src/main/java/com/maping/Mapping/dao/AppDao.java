package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Instructor;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInsuni(int theId);
    void deleteInsUni(int theId);
    Instructor updateInstructorUni(Instructor theInstructor);
}
