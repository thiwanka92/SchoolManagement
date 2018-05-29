package com.schoolmanagement.service;

import java.util.List;

import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.model.Teacher;

public interface TeacherService {
	public void addTeacher(StakeholderDTO stakeholderDTO) throws Exception;
	public void updateTeacher(StakeholderDTO stakeholderDTO) throws Exception;
	public List<Teacher> getAllTeacher() throws Exception;
	public Teacher getTeacherById(int teacherId) throws Exception;
	public void removeTeacher(int teacherId) throws Exception;
}
