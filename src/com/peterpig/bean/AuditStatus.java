package com.peterpig.bean;
/**
 * 审核状态
 * @author Evan
 *
 */
public class AuditStatus {
	/** 审核状态编号 */
	private Integer statusId;
	/** 审核状态名 */
	private String statusName;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
}
