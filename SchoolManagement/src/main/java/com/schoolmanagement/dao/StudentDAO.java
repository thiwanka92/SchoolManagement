package com.schoolmanagement.dao;

import java.util.List;

import com.schoolmanagement.model.Student;

public interface StudentDAO {
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
}
