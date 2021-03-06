package com.peterpig.cms.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.Department;
import com.peterpig.cms.biz.DepartmentBiz;
import com.peterpig.cms.biz.impl.DepartmentBizImpl;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	/**系部对象 */
	private Department department = new Department();
	/** 系部逻辑层接口*/
	private DepartmentBiz departmentBiz = new DepartmentBizImpl();
	/** 系部列表*/
	private ArrayList<Department> list = new ArrayList<Department>();
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
	
	
	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public DepartmentBiz getDepartmentBiz() {
		return departmentBiz;
	}


	public void setDepartmentBiz(DepartmentBiz departmentBiz) {
		this.departmentBiz = departmentBiz;
	}


	public ArrayList<Department> getList() {
		return list;
	}


	public void setList(ArrayList<Department> list) {
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


	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
 
	public String addDepartment(){
		if(departmentBiz.addDepartment(department)){
			message="添加成功";
			result="addOK";
		}else{
			message="添加失败";
			result="addFAIL";
		}
		return result;
	}
	
	public String remove(){
		if(departmentBiz.removeDepartment(department.getDepartmentId())){
			message="删除成功";
			result = "removeOK";
		}else{
			message="删除失败";
			result="removeFAIL";
		}
		return result;
	}
	public String update(){
		if(departmentBiz.updateDepartment(department)){
			message="修改成功";
			result="updateOK";
		}else{
			message="修改失败";
			result="updateFAIL";
		}
		return result;
	}
	
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)departmentBiz.getAllCount(keyWord, department.getDepartmentId()))/pageSize));
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
		list = (ArrayList<Department>) departmentBiz.findAllDepartment(keyWord, curPage, pageSize, orderType, orderField, department.getDepartmentId());
		if(list != null)
			result="findbyjspOK";
		else
			result="findbyjspFAIL";
		return result;
	}
	public String findById(){
		department = departmentBiz.findById(department.getDepartmentId());
		if(department!=null){
			result="findbyidOK";
		}else{
			result="findbyidFAIL";
		}
		return result;
	}
}
