package com.schoolmanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.schoolmanagement.dao.StakeholderDAO;
import com.schoolmanagement.dao.TeacherDAO;
import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.model.Teacher;
import com.schoolmanagement.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
	private StakeholderDAO stakeholderDAO;
	private TeacherDAO teacherDAO;
	
	public TeacherDAO getTeacherDAO() {
		return teacherDAO;
	}
	@Autowired
	public void setTeacherDAO(TeacherDAO teacherDAO) {
		this.teacherDAO = teacherDAO;
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
	public void addTeacher(StakeholderDTO stakeholderDTO) throws Exception {
		Teacher teacher = new Teacher();
		teacher.setFirstName(stakeholderDTO.getFirstName());
		teacher.setLastName(stakeholderDTO.getLastName());
		teacher.setEmail(stakeholderDTO.getEmail());
		teacher.setGender(stakeholderDTO.getGender());
		teacher.setDateOfBirth(stakeholderDTO.getDateOfBirth());
		teacher.setContactNumber(stakeholderDTO.getContactNumber());
		teacher.setExperience(stakeholderDTO.getExperience());
		teacher.setDegreeCode(stakeholderDTO.getDegreeCode());
		
		getStakeholderDAO().addStakeholder(teacher);
		
	}
	
	@Override
	@Transactional
	public void updateTeacher(StakeholderDTO stakeholderDTO) throws Exception {
		Teacher teacher = new Teacher();
		teacher.setTeacherId(stakeholderDTO.getTeacherId());
		teacher.setFirstName(stakeholderDTO.getFirstName());
		teacher.setLastName(stakeholderDTO.getLastName());
		teacher.setEmail(stakeholderDTO.getEmail());
		teacher.setGender(stakeholderDTO.getGender());
		teacher.setDateOfBirth(stakeholderDTO.getDateOfBirth());
		teacher.setContactNumber(stakeholderDTO.getContactNumber());
		teacher.setExperience(stakeholderDTO.getExperience());
		teacher.setDegreeCode(stakeholderDTO.getDegreeCode());
		
		getStakeholderDAO().updateStakeholder(teacher);
	}
	
	@Override
	@Transactional
	public void removeTeacher(int teacherId) throws Exception {
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		getStakeholderDAO().removeStakeholder(teacher);
		
	}
	
	@Override
	@Transactional
	public List<Teacher> getAllTeacher() {
		return getTeacherDAO().getAllTeacher();
	}
	
	@Override
	@Transactional
	public Teacher getTeacherById(int teacherId) {
		return getTeacherDAO().getTeacherById(teacherId);
	}
}
