package com.peterpig.bean;
/**
 * 管理员
 * @author Evan
 *
 */
public class Admin {
	/** 管理员编号 */
	private Integer adminId;
	/** 管理员用户名 */
	private String username;
	/** 管理员密码 */
	private String password;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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
	
}
