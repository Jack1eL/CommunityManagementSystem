package com.peterpig.cms.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 专业
 * @author Evan
 *
 */
public class Major {
	/** 专业编号 */
	private Integer majorId;
	/** 专业名 */
	private String majorName;
	/** 年级 */
	private Integer grade;
	/** 所属系 */
	private Department department;
	/** 班级 */
	private Set<Classes> classes=new HashSet<Classes>();
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getMajorId() {
		return majorId;
	}
	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Classes> getClasses() {
		return classes;
	}
	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}
	
}
