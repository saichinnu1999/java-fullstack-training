package com.capgemini.studentprofile.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.studentprofile.models.Student;

public class StudentProfileDAOImpl implements StudentProfileDAO {

	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentProfileDAOImpl() {
		List<String> courses1 = new ArrayList<String>();
		courses1.add("Java");
		courses1.add("Oracle");
	 	Student student1= new Student(121, "Chinnu", courses1);
	 	
	 	List<String> courses2 = new ArrayList<String>();
		courses2.add("C");
		courses2.add("C++");
	 	Student student2= new Student(122, "Charan", courses2);
	 	
	 	List<String> courses3 = new ArrayList<String>();
		courses3.add("Java");
		courses3.add("C");
	 	Student student3= new Student(123, "Bhargav", courses3);
	 	
	 	studentList.add(student1);
	 	studentList.add(student2);
	 	studentList.add(student3);
	}
	
	
	public void addStudentDetails(Student student) {
		studentList.add(student);
	}

	public Student getStudentByRollNumber(Integer studentRollNumber) {
		Student student1 = null;
		for(Student student: studentList)
		{
			if(student.getStudentRollNumber() == studentRollNumber)
			{
				student1 = student;
			}
		}
		return student1;
	}

	public List<Student> getAllStudents() {
		return studentList;
	}

	public List<Student> getAllStudentsByCourse(String courseName) {
		List<Student> students= new ArrayList<Student>();
		for(Student student: studentList)
		{
			if (student.getStudentCourses().contains(courseName)) {
				students.add(student);
			}
		}
		return students;
	}

}
