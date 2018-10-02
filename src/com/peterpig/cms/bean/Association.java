package com.peterpig.cms.bean;

import java.util.HashSet;
import java.util.Set;
/**
 * 社团
 * @author Evan
 *
 */
public class Association {
	/** 社团编号 */
	private Integer associationId;
	/** 社团名 */
	private String name;
	/** 社团简介 */
	private String explains;
	
	private String image;
	private Set<AssociationGroup> associationGroup=new HashSet<AssociationGroup>();
	/** 社团内的学生 */
	private Set<Student> students=new HashSet<Student>();
	/** 审核状态 */
	private AuditStatus status;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getAssociationId() {
		return associationId;
	}
	public void setAssociationId(Integer associationId) {
		this.associationId = associationId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public AuditStatus getStatus() {
		return status;
	}
	public void setStatus(AuditStatus status) {
		this.status = status;
	}
	public Set<AssociationGroup> getAssociationGroup() {
		return associationGroup;
	}
	public void setAssociationGroup(Set<AssociationGroup> associationGroup) {
		this.associationGroup = associationGroup;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
