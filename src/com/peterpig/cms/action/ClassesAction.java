package com.peterpig.cms.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.Classes;
import com.peterpig.cms.biz.ClassesBiz;
import com.peterpig.cms.biz.impl.ClassesBizImpl;

public class ClassesAction extends ActionSupport implements ModelDriven<Classes> {
	/**班级对象 */
	private Classes classes = new Classes();
	/** 班级逻辑层接口*/
	private ClassesBiz classesBiz = new ClassesBizImpl();
	/** 班级列表*/
	private ArrayList<Classes> list = new ArrayList<Classes>();
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
	public Classes getModel() {
		// TODO Auto-generated method stub
		return classes;
	}
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	public ClassesBiz getClassesBiz() {
		return classesBiz;
	}
	public void setClassesBiz(ClassesBiz classesBiz) {
		this.classesBiz = classesBiz;
	}
	public ArrayList<Classes> getList() {
		return list;
	}
	public void setList(ArrayList<Classes> list) {
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
		if(classesBiz.addClasses(classes)){
			message="添加成功";
			result="addOK";
		}else{
			message="添加失败";
			result="addFAIL";
		}
		return result;
	}
	
	public String remove(){
		if(classesBiz.removeClasses(classes.getClassId())){
			message="删除成功";
			result = "removeOK";
		}else{
			message="删除失败";
			result="removeFAIL";
		}
		return result;
	}
	public String update(){
		if(classesBiz.updateClasses(classes)){
			message="修改成功";
			result="updateOK";
		}else{
			message="修改失败";
			result="updateFAIL";
		}
		return result;
	}
	
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)classesBiz.getAllCount(keyWord, classes.getClassId()))/pageSize));
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
		list = (ArrayList<Classes>) classesBiz.findAllClasses(keyWord, curPage, pageSize, orderType, orderField, classes.getClassId());
		if(list != null)
			result="findbyjspOK";
		else
			result="findbyjspFAIL";
		return result;
	}
	public String findById(){
		classes = classesBiz.findById(classes.getClassId());
		if(classes!=null){
			result="findbyidOK";
		}else{
			result="findbyidFAIL";
		}
		return result;
	}
}
