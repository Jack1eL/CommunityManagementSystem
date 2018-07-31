package com.peterpig.cms.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 系部
 * @author Evan
 *
 */
public class Department {
	/** 系编号 */
	private Integer departmentId;
	/** 系名 */
	private String departmentName;
	/** 系专业 */
	private Set<Major> majors=new HashSet<Major>();
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Set<Major> getMajors() {
		return majors;
	}
	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}
	
}
