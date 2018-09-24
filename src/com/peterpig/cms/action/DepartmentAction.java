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

}
