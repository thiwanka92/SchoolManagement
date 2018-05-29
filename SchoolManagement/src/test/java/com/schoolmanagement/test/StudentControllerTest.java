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

import com.schoolmanagement.controller.StudentController;
import com.schoolmanagement.dto.StakeholderDTO;
import com.schoolmanagement.model.Student;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/test-servlet-context.xml")
public class StudentControllerTest {
	
	@Autowired
	private StudentController studentController;

	//tested
	@Test
	public void listStudentTest() {
		List<Student> result = studentController.listStudentJson();
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}
	
	//tested
	@Test
	public void addStudentTest() {
		List<Student> beforeResult = studentController.listStudentJson();
		assertNotNull(beforeResult);
		
		studentController.addStudent(getSampleObject());
		
		List<Student> afterResult = studentController.listStudentJson();
		assertNotNull(afterResult);
		assertTrue(beforeResult.size() < afterResult.size());
	}
	
	//tested
	@Test
	public void getStudentByIdTest() {
		Student studentNullObject = null;
		assertNull(studentNullObject);
		
		studentNullObject = studentController.getStudentById(1);
		
		assertNotNull(studentNullObject);
	}
	
	//tested
	@Test
	public void updateStudentTest() {
		Student beforeObj = studentController.getStudentById(1);
		assertNotNull(beforeObj);
		StakeholderDTO dto = studentToStakeholder(beforeObj);
		dto.setFirstName("updated first name");
		
		studentController.updateStudent(dto);
		
		Student afterObj = studentController.getStudentById(1);
		assertNotNull(afterObj);
		assertTrue(!beforeObj.getFirstName().equals(afterObj.getFirstName()));
	}
	
	//tested
	@Test
	public void removeStudentTest() {
		Student obj = studentController.getStudentById(10);
		assertNotNull(obj);
	
		studentController.removeStudent(10);
		
		Student afterObj = studentController.getStudentById(10);
		assertNull(afterObj);
	}
	
	
	private StakeholderDTO getSampleObject() {
		StakeholderDTO dto = new StakeholderDTO();
		dto.setFirstName("fName test");
		dto.setLastName("lName test");
		dto.setEmail("test@mail.com");
		return dto;
	}
	
	private StakeholderDTO studentToStakeholder(Student student) {
		StakeholderDTO stakeholderDTO = new StakeholderDTO();
		stakeholderDTO.setStudentId(student.getStudentId());
		stakeholderDTO.setFirstName(student.getFirstName());
		stakeholderDTO.setLastName(student.getLastName());
		stakeholderDTO.setEmail(student.getEmail());
		stakeholderDTO.setGender(student.getGender());
		stakeholderDTO.setDateOfBirth(student.getDateOfBirth());
		stakeholderDTO.setContactNumber(student.getContactNumber());
		stakeholderDTO.setParentContactNumber(student.getParentContactNumber());
		stakeholderDTO.setGrade(student.getGrade());
		return stakeholderDTO;
	}

}