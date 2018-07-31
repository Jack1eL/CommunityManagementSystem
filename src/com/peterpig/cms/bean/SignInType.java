package com.peterpig.cms.bean;
/**
 * 签到类型
 * @author Evan
 *
 */
public class SignInType {
	/** 签到类型编号 */
	private Integer typeId;
	/** 签到类型名 */
	private String typeName;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
