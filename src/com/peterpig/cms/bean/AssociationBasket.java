package com.peterpig.cms.bean;
/**
 * 社团篮子
 * @author Evan
 *
 */
public class AssociationBasket {
	/** 作品编号 */
	private Integer workId;
	/** 所属社团 */
	private Association association;
	/** 标题 */
	private String title;
	/** 简介 */
	private String explains;
	/** 源文件 */
	private String sourceFile;
	/** 上传学生 */
	private Student student;
	
	/*----------------------------------GETTER AND SETTER------------------------------------------*/
	
	public Integer getWorkId() {
		return workId;
	}
	public void setWorkId(Integer workId) {
		this.workId = workId;
	}
	public Association getAssociation() {
		return association;
	}
	public void setAssociation(Association association) {
		this.association = association;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getExplains() {
		return explains;
	}
	public void setExplains(String explains) {
		this.explains = explains;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}
