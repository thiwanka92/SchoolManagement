package com.schoolmanagement.enumeration;

import java.util.Arrays;
import java.util.List;

public enum StudentGradeEnum {
	GRADE_1(1,"Grade 1"),
	GRADE_2(2,"Grade 2"),
	GRADE_3(3,"Grade 3"),
	GRADE_4(4,"Grade 4"),
	GRADE_5(5,"Grade 5"),
	GRADE_6(6,"Grade 6"),
	GRADE_7(7,"Grade 7"),
	GRADE_8(8,"Grade 8"),
	GRADE_9(9,"Grade 9"),
	GRADE_10(10,"Grade 10"),
	GRADE_11(11,"Grade 11"),
	GRADE_12(12,"Grade 12");
	
	private int id;
	private String code;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private StudentGradeEnum(int id, String code) {
		this.id = id;
		this.code = code;
	}
	
	public static List<StudentGradeEnum> getAllStudentGrade() {
		return Arrays.asList(StudentGradeEnum.values());
	}
	
	public static StudentGradeEnum getEnumById(int id) {
		StudentGradeEnum returnEnum = null;
		for (StudentGradeEnum en : StudentGradeEnum.values()) {
			if(id==en.getId()) {
				returnEnum = en;
				break;
			}
		}
		return returnEnum;
	}
}
