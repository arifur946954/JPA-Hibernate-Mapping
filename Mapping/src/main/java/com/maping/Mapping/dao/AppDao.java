package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Course;
import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;

import java.util.List;

public interface AppDao {
    void createInstructor(Instructor instructor);
    Instructor findInstructor(int theId);
    void deleteInstructor(int theId);
    // one to one bidirectional
    void saveInstructorDetailsByInstructor(InstructorDetails instructorDetails);
    //one to many bidirectional
    List<Course> findCourseWithIns(int theId);
    Course findCourseById(int theId);
    Instructor findInstructorWithCourse(int theId);


}
