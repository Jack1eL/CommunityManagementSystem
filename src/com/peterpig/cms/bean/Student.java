package com.peterpig.cms.bean;
/**
 * 学生
 * @author Evan
 *
 */
public class Student {
	/** 学生编号 */
	private Integer studentId;
	/** 用户名 */
	private String username;
	/** 密码 */
	private String password;
	/** 所属社团职位 */
	private AssociationPosition position;
	/** 所属社团 */
	private Association association;
	/** 所属分组 */
	private AssociationGroup group;
	/** 学生信息 */
	private StudentInfo studentInfo;
	
	/**
	 * 仅在查询组成员时作用
	 */
	private Integer groupId;
	private String name;
	
	public Student(){
		super();
	}
	
	public Student(Integer studentId,Integer groupId,String name){
		this.studentId=studentId;
		this.groupId=groupId;
		this.name=name;
	}
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	
	public Integer getStudentId() {
		return studentId;
	}
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AssociationPosition getPosition() {
		return position;
	}
	public void setPosition(AssociationPosition position) {
		this.position = position;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public AssociationGroup getGroup() {
		return group;
	}
	public void setGroup(AssociationGroup group) {
		this.group = group;
	}
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
	
}
