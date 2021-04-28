package com.capgemini.studentprofile.service;

import java.util.List;

import com.capgemini.studentprofile.models.Student;

public interface IStudentProfileService {

	void addStudentDetails(Student student);
	Student getStudentByRollNumber(Integer studentRollNumber);
	List<Student> getAllStudents();
	List<Student> getAllStudentsByCourse(String courseName);
	
}
