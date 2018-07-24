package com.peterpig.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 社团职位
 * @author Evan
 *
 */
public class AssociationPosition {
	/** 社团职位标号 */
	private Integer positionId;
	/** 社团职位名称 */
	private String positionName;
	/** 学生 */
	private Set<Student> students=new HashSet<Student>();
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
}
