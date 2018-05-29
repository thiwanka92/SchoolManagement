package com.schoolmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolmanagement.dao.StakeholderDAO;
import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private StakeholderDAO stakeholderDAO;
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}
	@Autowired
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	public StakeholderDAO getStakeholderDAO() {
		return stakeholderDAO;
	}
	@Autowired
	public void setStakeholderDAO(StakeholderDAO stakeholderDAO) {
		this.stakeholderDAO = stakeholderDAO;
	}
	
	@Override
	@Transactional
	public void addStudent(StakeholderDTO stakeholderDTO) throws Exception {
		Student student = new Student();
		student.setFirstName(stakeholderDTO.getFirstName());
		student.setLastName(stakeholderDTO.getLastName());
		student.setEmail(stakeholderDTO.getEmail());
		student.setGender(stakeholderDTO.getGender());
		student.setDateOfBirth(stakeholderDTO.getDateOfBirth());
		student.setContactNumber(stakeholderDTO.getContactNumber());
		student.setParentContactNumber(stakeholderDTO.getParentContactNumber());
		student.setGrade(stakeholderDTO.getGrade());
		
		getStakeholderDAO().addStakeholder(student);
		
	}
	
	@Override
	@Transactional
	public void updateStudent(StakeholderDTO stakeholderDTO) throws Exception {
		Student student = new Student();
		student.setStudentId(stakeholderDTO.getStudentId());
		student.setFirstName(stakeholderDTO.getFirstName());
		student.setLastName(stakeholderDTO.getLastName());
		student.setEmail(stakeholderDTO.getEmail());
		student.setGender(stakeholderDTO.getGender());
		student.setDateOfBirth(stakeholderDTO.getDateOfBirth());
		student.setContactNumber(stakeholderDTO.getContactNumber());
		student.setParentContactNumber(stakeholderDTO.getParentContactNumber());
		student.setGrade(stakeholderDTO.getGrade());
		
		getStakeholderDAO().updateStakeholder(student);
	}
	
	
	@Override
	@Transactional
	public void removeStudent(int studentId) throws Exception {
		Student student = new Student();
		student.setStudentId(studentId);
		getStakeholderDAO().removeStakeholder(student);
		
	}
	
	@Override
	@Transactional
	public List<Student> getAllStudent() {
		return getStudentDAO().getAllStudent();
	}
	
	@Override
	@Transactional
	public Student getStudentById(int studentId) {
		return getStudentDAO().getStudentById(studentId);
	}
}
