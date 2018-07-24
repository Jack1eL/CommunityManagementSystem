package com.peterpig.bean;

import java.util.Date;
/**
 * 签到
 * @author Evan
 *
 */
public class SignIn {
	/** 签到编号 */
	private Integer signinId;
	/** 签到的社团活动 */
	private AssociationActivity activity;
	/** 签到的学生 */
	private Student student;
	/** 签到类型 */
	private SignInType type;
	/** 签到时间 */
	private Date signinTime;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getSigninId() {
		return signinId;
	}
	public void setSigninId(Integer signinId) {
		this.signinId = signinId;
	}
	public AssociationActivity getActivity() {
		return activity;
	}
	public void setActivity(AssociationActivity activity) {
		this.activity = activity;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public SignInType getType() {
		return type;
	}
	public void setType(SignInType type) {
		this.type = type;
	}
	public Date getSigninTime() {
		return signinTime;
	}
	public void setSigninTime(Date signinTime) {
		this.signinTime = signinTime;
	}
	
}
