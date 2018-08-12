package com.peterpig.cms.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 社团分组
 * @author Evan
 *
 */
public class AssociationGroup {
	/** 分组编号 */
	private Integer groupId;
	/** 所属社团 */
	private Association association;
	/** 组号 */
	private Integer groupNumber;
	/** 一个组里面有多个学生 */
	private Set<Student> students=new HashSet<Student>();
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public Integer getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(Integer groupNumber) {
		this.groupNumber = groupNumber;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
		
}
