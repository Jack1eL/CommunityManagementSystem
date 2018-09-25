package com.peterpig.cms.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.StudentInfo;
import com.peterpig.cms.biz.StudentInfoBiz;
import com.peterpig.cms.biz.impl.StudentInfoBizImpl;

public class StudentInfoAction extends ActionSupport implements ModelDriven<StudentInfo> {
	/**班级对象 */
	private StudentInfo studentInfo = new StudentInfo();
	/** 班级逻辑层接口*/
	private StudentInfoBiz studentInfoBiz = new StudentInfoBizImpl();
	/** 班级列表*/
	private ArrayList<StudentInfo> list = new ArrayList<StudentInfo>();
	/** 信息 */
	private String message;
	/** 当前页*/
	private Integer curPage;
	/** 总页数*/
	private Integer totalPage;
	/** 单页包含元素数量*/
	private Integer pageSize;
	/** 查询关键字 */
	private String keyWord;
	/** 排序类型 */
	private String orderType;
	/** 排序字段 */
	private String orderField;
	/** 结果 */
	private String result;
	@Override
	public StudentInfo getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
	public StudentInfoBiz getStudentInfoBiz() {
		return studentInfoBiz;
	}
	public void setStudentInfoBiz(StudentInfoBiz studentInfoBiz) {
		this.studentInfoBiz = studentInfoBiz;
	}
	public ArrayList<StudentInfo> getList() {
		return list;
	}
	public void setList(ArrayList<StudentInfo> list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String addDepartment(){
		if(studentInfoBiz.addStudentInfo(studentInfo)){
			message="添加成功";
			result="addOK";
		}else{
			message="添加失败";
			result="addFAIL";
		}
		return result;
	}
	
	public String remove(){
		if(studentInfoBiz.removeStudentInfo(studentInfo.getStudentId())){
			message="删除成功";
			result = "removeOK";
		}else{
			message="删除失败";
			result="removeFAIL";
		}
		return result;
	}
	public String update(){
		if(studentInfoBiz.updateStudentInfo(studentInfo)){
			message="修改成功";
			result="updateOK";
		}else{
			message="修改失败";
			result="updateFAIL";
		}
		return result;
	}
	
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)studentInfoBiz.getAllCount(keyWord, studentInfo.getStudentId()))/pageSize));
		if(curPage==null || curPage<1){
			curPage=1;
		}
		if(totalPage==0){
			totalPage=1;
		}
		if(curPage>totalPage){
			curPage=totalPage;
		}
		if(orderType=="asc" || orderType=="")
			orderType="desc";
		list = (ArrayList<StudentInfo>) studentInfoBiz.findAllStudentInfo(keyWord, curPage, pageSize, orderType, orderField, studentInfo.getStudentId());
		if(list != null)
			result="findbyjspOK";
		else
			result="findbyjspFAIL";
		return result;
	}
	public String findById(){
		studentInfo = studentInfoBiz.findById(studentInfo.getStudentId());
		if(studentInfo!=null){
			result="findbyidOK";
		}else{
			result="findbyidFAIL";
		}
		return result;
	}
}
