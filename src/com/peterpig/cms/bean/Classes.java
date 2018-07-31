package com.peterpig.cms.bean;
/**
 * 班级
 * @author Evan
 *
 */
public class Classes {
	/** 班级编号 */
	private Integer classId;
	/** 班级号 */
	private Integer classNumber;
	/** 所属专业 */
	private Major major;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(Integer classNumber) {
		this.classNumber = classNumber;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	
}
