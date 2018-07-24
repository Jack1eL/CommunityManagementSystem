package com.peterpig.bean;

import java.util.Date;
/**
 * 学生信息
 * @author Evan
 *
 */
public class StudentInfo {
	/** 学生编号 */
	private Integer studentId;
	/** 姓名 */
	private String name;
	/** 性别 */
	private String sex;
	/** 出生日期 */
	private Date borndate;
	/** 地址 */
	private String address;
	/** 手机号码 */
	private String phone;
	/** 简介 */
	private String explains;
	/** 班级 */
	private Classes classes;
	/** 学生 */
	private Student student;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBorndate() {
		return borndate;
	}
	public void setBorndate(Date borndate) {
		this.borndate = borndate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
