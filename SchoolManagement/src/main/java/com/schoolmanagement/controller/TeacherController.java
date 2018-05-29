package com.schoolmanagement.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.model.Teacher;
import com.schoolmanagement.service.TeacherService;
import com.schoolmanagement.utility.ResponseMessageUtil;

@Controller
public class TeacherController {
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	private TeacherService teacherService;

	public TeacherService getTeacherService() {
		return teacherService;
	}
	@Autowired
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	@RequestMapping(value = "/teacher", method = RequestMethod.GET)
	public String listTeacher() {
		return "teacher";
	}

	@RequestMapping(value = "/teacher/all", method = RequestMethod.GET)
	public @ResponseBody List<Teacher> listTeacherJson() {
		logger.info("Requested - listTeacherJson");
		try {
			return getTeacherService().getAllTeacher();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value= "/teachera/add", method = RequestMethod.POST)
	public @ResponseBody String addTeacher(@RequestBody  StakeholderDTO stakeholderDTO){
		logger.info("Requested - addTeacher");
		try {
			getTeacherService().addTeacher(stakeholderDTO);
			return ResponseMessageUtil.getCreateSuccessMessage();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseMessageUtil.getCommonErrorMessage(e.getMessage());
		}
	}
	
	@RequestMapping(value= "/teacher/update/", method = RequestMethod.POST)
	public @ResponseBody String updateTeacher(@RequestBody  StakeholderDTO stakeholderDTO){
		logger.info("Requested - updateTeacher");
		try {
			getTeacherService().updateTeacher(stakeholderDTO);
			return ResponseMessageUtil.getUpdateSuccessMessage();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseMessageUtil.getCommonErrorMessage(e.getMessage());
		}
	}
	
	@RequestMapping(value="/teacher/remove/{id}", method = RequestMethod.POST)
    public @ResponseBody String removeTeacher(@PathVariable("id") int id){
		logger.info("Requested - removeTeacher");
        try {
			getTeacherService().removeTeacher(id);
			return ResponseMessageUtil.getDeleteSuccessMessage();
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseMessageUtil.getCommonErrorMessage(e.getMessage());
		}
    }
	
	@RequestMapping(value="/teacher/{id}", method = RequestMethod.GET)
    public @ResponseBody Teacher getTeacherById(@PathVariable("id") int id){
		logger.info("Requested - getTeacherById");
		 try {
				return getTeacherService().getTeacherById(id);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		return null;
    }
}
