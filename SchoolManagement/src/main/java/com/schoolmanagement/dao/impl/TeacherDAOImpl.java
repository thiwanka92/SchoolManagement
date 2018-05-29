package com.schoolmanagement.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagement.dao.TeacherDAO;
import com.schoolmanagement.model.Teacher;
import com.schoolmanagement.utility.BaseDAOSupport;

@Repository
public class TeacherDAOImpl extends BaseDAOSupport implements TeacherDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAllTeacher() {
		List<Teacher> list = getSession().createQuery("from Teacher").list();
		return list;
	}

	@Override
	public Teacher getTeacherById(int id) {
		return (Teacher) getSession().get(Teacher.class,id);
	}
}
	