package com.peterpig.cms.bean;

import java.util.HashSet;
import java.util.Set;

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
	/** 状态表对应社团表中的多个社团 */
	private Set<Association> assocaitions=new HashSet<Association>();
	
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
	public Set<Association> getAssocaitions() {
		return assocaitions;
	}
	public void setAssocaitions(Set<Association> assocaitions) {
		this.assocaitions = assocaitions;
	}
	
}
