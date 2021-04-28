package com.capgemini.studentprofile.dao;

import java.util.List;

import com.capgemini.studentprofile.models.Student;

public interface StudentProfileDAO {

	void addStudentDetails(Student student);
	Student getStudentByRollNumber(Integer studentRollNumber);
	List<Student> getAllStudents();
	List<Student> getAllStudentsByCourse(String courseName);
	
}
