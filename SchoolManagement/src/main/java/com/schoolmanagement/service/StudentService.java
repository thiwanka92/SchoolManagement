package com.schoolmanagement.service;

import java.util.List;

import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.model.Student;

public interface StudentService {
	public void addStudent(StakeholderDTO stakeholderDTO) throws Exception;
	public void updateStudent(StakeholderDTO stakeholderDTO) throws Exception;
	public List<Student> getAllStudent() throws Exception;
	public Student getStudentById(int studentId) throws Exception;
	public void removeStudent(int studentId) throws Exception;
}
