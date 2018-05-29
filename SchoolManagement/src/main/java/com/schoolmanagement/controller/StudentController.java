package com.schoolmanagement.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.enumeration.StudentGradeEnum;
import com.schoolmanagement.model.Student;
import com.schoolmanagement.service.StudentService;
import com.schoolmanagement.utility.ResponseMessageUtil;

@Controller
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	private StudentService studentService;
	
	public StudentService getStudentService() {
		return studentService;
	}
	@Autowired()
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String listStudent(Model model) {
		logger.info("Requested - listStudent");
		model.addAttribute("gradeList",StudentGradeEnum.getAllStudentGrade());
		return "student";
	}
	
	@RequestMapping(value = "/student/all", method = RequestMethod.GET)
	public @ResponseBody List<Student> listStudentJson() {
		logger.info("Requested - listStudentJson");
		try {
			return getStudentService().getAllStudent();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value= "/student/add", method = RequestMethod.POST)
	public @ResponseBody String addStudent(@RequestBody  StakeholderDTO stakeholderDTO){
		logger.info("Requested - addStudent");
		try {
			getStudentService().addStudent(stakeholderDTO);
			return ResponseMessageUtil.getCreateSuccessMessage();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseMessageUtil.getCommonErrorMessage(e.getMessage());
		}
	}
	
	@RequestMapping(value= "/student/update/", method = RequestMethod.POST)
	public @ResponseBody String updateStudent(@RequestBody  StakeholderDTO stakeholderDTO){
		logger.info("Requested - updateStudent");
		try {
			getStudentService().updateStudent(stakeholderDTO);
			return ResponseMessageUtil.getUpdateSuccessMessage();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseMessageUtil.getCommonErrorMessage(e.getMessage());
		}
	}
	
	@RequestMapping(value="/student/remove/{id}", method = RequestMethod.POST)
    public @ResponseBody String removeStudent(@PathVariable("id") int id){
		logger.info("Requested - removeStudent");
        try {
			getStudentService().removeStudent(id);
			return ResponseMessageUtil.getDeleteSuccessMessage();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseMessageUtil.getCommonErrorMessage(e.getMessage());
		}
    }
	
	@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
    public @ResponseBody Student getStudentById(@PathVariable("id") int id){
		logger.info("Requested - getStudentById");
		 try {
				return getStudentService().getStudentById(id);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		return null;
    }
}
