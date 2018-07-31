package com.peterpig.cms.bean;

import java.util.Date;
/**
 * 社团活动
 * @author Evan
 *
 */
public class AssociationActivity {
	/** 活动编号 */
	private Integer activityId;
	/** 活动名 */
	private String activityName;
	/** 简介 */
	private String explains;
	/** 开始时间 */
	private Date activityBegin;
	/** 结束时间 */
	private Date activityEnd;
	/** 所属社团 */
	private Association association;
	/** 审核状态 */
	private AuditStatus status;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public Date getActivityBegin() {
		return activityBegin;
	}
	public void setActivityBegin(Date activityBegin) {
		this.activityBegin = activityBegin;
	}
	public Date getActivityEnd() {
		return activityEnd;
	}
	public void setActivityEnd(Date activityEnd) {
		this.activityEnd = activityEnd;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public AuditStatus getStatus() {
		return status;
	}
	public void setStatus(AuditStatus status) {
		this.status = status;
	}
	
}
