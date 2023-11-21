package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Instructor;

public interface AppDao {
    void createInstructor(Instructor instructor);
    Instructor findInstructor(int theId);
}
