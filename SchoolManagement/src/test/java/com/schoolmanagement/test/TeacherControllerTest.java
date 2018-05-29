package com.schoolmanagement.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.schoolmanagement.controller.TeacherController;
import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.model.Teacher;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/test-servlet-context.xml")
public class TeacherControllerTest {
	
	@Autowired
	private TeacherController teacherController;

	//tested
	@Test
	public void listTeacherTest() {
		List<Teacher> result = teacherController.listTeacherJson();
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}
	
	//tested
	@Test
	public void addTeacherTest() {
		List<Teacher> beforeResult = teacherController.listTeacherJson();
		assertNotNull(beforeResult);
		
		teacherController.addTeacher(getSampleObject());
		
		List<Teacher> afterResult = teacherController.listTeacherJson();
		assertNotNull(afterResult);
		assertTrue(beforeResult.size() < afterResult.size());
	}
	
	//tested
	@Test
	public void getTeacherByIdTest() {
		Teacher teacherNullObject = null;
		assertNull(teacherNullObject);
		
		teacherNullObject = teacherController.getTeacherById(1);
		
		assertNotNull(teacherNullObject);
	}
	
	//tested
	@Test
	public void updateTeacherTest() {
		Teacher beforeObj = teacherController.getTeacherById(1);
		assertNotNull(beforeObj);
		StakeholderDTO dto = teacherToStakeholder(beforeObj);
		dto.setFirstName("updated first name");
		
		teacherController.updateTeacher(dto);
		
		Teacher afterObj = teacherController.getTeacherById(1);
		assertNotNull(afterObj);
		assertTrue(!beforeObj.getFirstName().equals(afterObj.getFirstName()));
	}
	
	//tested
	@Test
	public void removeTeacherTest() {
		Teacher obj = teacherController.getTeacherById(8);
		assertNotNull(obj);
	
		teacherController.removeTeacher(8);
		
		Teacher afterObj = teacherController.getTeacherById(8);
		assertNull(afterObj);
	}
	
	
	private StakeholderDTO getSampleObject() {
		StakeholderDTO dto = new StakeholderDTO();
		dto.setFirstName("fName test");
		dto.setLastName("lName test");
		dto.setEmail("test@mail.com");
		return dto;
	}
	
	private StakeholderDTO teacherToStakeholder(Teacher teacher) {
		StakeholderDTO stakeholderDTO = new StakeholderDTO();
		stakeholderDTO.setTeacherId(teacher.getTeacherId());
		stakeholderDTO.setFirstName(teacher.getFirstName());
		stakeholderDTO.setLastName(teacher.getLastName());
		stakeholderDTO.setEmail(teacher.getEmail());
		stakeholderDTO.setGender(teacher.getGender());
		stakeholderDTO.setDateOfBirth(teacher.getDateOfBirth());
		stakeholderDTO.setContactNumber(teacher.getContactNumber());
		stakeholderDTO.setExperience(teacher.getExperience());
		stakeholderDTO.setDegreeCode(teacher.getDegreeCode());
		return stakeholderDTO;
	}

}