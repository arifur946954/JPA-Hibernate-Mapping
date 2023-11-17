package com.maping.Mapping.dao;

import com.maping.Mapping.entity.Course;
import com.maping.Mapping.entity.Instructor;
import com.maping.Mapping.entity.InstructorDetails;
import com.maping.Mapping.entity.Review;

public interface AppDao {
    void CreateInstructor(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructroById(int theID);
    //One to one bidirectional
    InstructorDetails findInstructorDetailsById(int theId);
    void CreateInstructorDetails(InstructorDetails tempInsDetails);

    //oneToMany Unidirectional
  void  instructorByCourse(Instructor instructor);
  Course findCourseByInstructor(int theId);
  void   deleteCourseByIns(int theID);

  void reviewByCourse(Review review);
}
