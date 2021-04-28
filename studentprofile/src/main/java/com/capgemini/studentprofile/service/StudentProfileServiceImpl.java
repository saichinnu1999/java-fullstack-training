package com.capgemini.studentprofile.service;

import java.util.List;

import com.capgemini.studentprofile.dao.StudentProfileDAO;
import com.capgemini.studentprofile.dao.StudentProfileDAOImpl;
import com.capgemini.studentprofile.models.Student;

public class StudentProfileServiceImpl implements IStudentProfileService{

	private StudentProfileDAO dao= new  StudentProfileDAOImpl();
	
	public void addStudentDetails(Student student) {
		 dao.addStudentDetails(student);
	}

	public Student getStudentByRollNumber(Integer studentRollNumber) {
		return dao.getStudentByRollNumber(studentRollNumber);
	}

	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}

	public List<Student> getAllStudentsByCourse(String courseName) {
		
		return dao.getAllStudentsByCourse(courseName);
	}
	

}
