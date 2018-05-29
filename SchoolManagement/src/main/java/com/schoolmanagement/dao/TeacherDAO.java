package com.schoolmanagement.dao;

import java.util.List;

import com.schoolmanagement.model.Teacher;

public interface TeacherDAO {
	public List<Teacher> getAllTeacher();
	public Teacher getTeacherById(int id);
}
