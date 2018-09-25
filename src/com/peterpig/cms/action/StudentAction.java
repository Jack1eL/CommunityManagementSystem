package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.Student;
import com.peterpig.cms.biz.StudentBiz;
import com.peterpig.cms.biz.impl.StudentBizImpl;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {
	/**学生对象 */
	private Student student = new Student();
	/** 学生逻辑层接口*/
	private StudentBiz studentBiz = new StudentBizImpl();
	/** 学生列表*/
	private ArrayList<Student> list = new ArrayList<Student>();
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
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public StudentBiz getStudentBiz() {
		return studentBiz;
	}
	public void setStudentBiz(StudentBiz studentBiz) {
		this.studentBiz = studentBiz;
	}
	public ArrayList<Student> getList() {
		return list;
	}
	public void setList(ArrayList<Student> list) {
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
	
	
	public String login(){
		student = studentBiz.login(student); 
		if(student!=null){
			Map<String,Object> session = ActionContext.getContext().getSession();
			ActionContext.getContext().getValueStack().push(student);
			session.put("Student", student);
			result = "loginOK";
		}else{
			message = "用户名或密码错误";
			result = "loginFAIL";
		}
		return result;
	}
	
	public String logout(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		ActionContext.getContext().getValueStack().push(student);
		session.remove("Student");
		result = "logoutOK";
		return result;
	}
	
	public String regist(){
		if(studentBiz.addStudent(student)){
			message="注册成功";
			result="registOK";
		}else{
			message="注册失败";
			result="registFAIL";
		}
		return result;
	}
	public String update(){
		if(studentBiz.updateStudent(student)){
			message="修改成功";
			result="updateOK";
		}else{
			message="修改失败";
			result="updateFAIL";
		}
		return result;
	}
	public String remove(){
		if(studentBiz.removeStudent(student.getStudentId())){
			message="删除成功";
			result="removeOK";
		}else{
			message="删除失败";
			result="removeFAIL";
		}
		return result;
	}
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)studentBiz.getAllCount(keyWord, student.getStudentId()))/pageSize));
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
		list = (ArrayList<Student>) studentBiz.findAllStudent(keyWord, curPage, pageSize, orderType, orderField, student.getStudentId());
		if(list != null)
			result="findbyjspOK";
		else
			result="findbyjspFAIL";
		return result;
	}
	public String findById(){
		student = studentBiz.findById(student.getStudentId());
		if(student!=null){
			result="findbyidOK";
		}else{
			result="findbyidFAIL";
		}
		return result;
	}
}
