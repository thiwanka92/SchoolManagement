package com.schoolmanagement.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.schoolmanagement.dao.StudentDAO;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.utility.BaseDAOSupport;

@Repository
public class StudentDAOImpl extends BaseDAOSupport implements StudentDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudent() {
		List<Student> list = getSession().createQuery("from Student").list();
		return list;
	}

	@Override
	public Student getStudentById(int id) {
		return (Student) getSession().get(Student.class,id);
	}
}
