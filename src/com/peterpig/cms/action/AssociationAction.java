package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.Association;
import com.peterpig.cms.biz.AssociationBiz;
import com.peterpig.cms.biz.impl.AssociationBizImpl;

public class AssociationAction extends ActionSupport implements
		ModelDriven<Association> {
	/** 社团类属性 */
	private Association association=new Association();
	/** 社团类泛型的列表 */
	private List<Association> associationList=new ArrayList<Association>();
	/** 执行结果的保存  */
	private boolean flag;
	/** 添加社团时获取的学生的id  */
	private Integer studentId;
	/** 社团类业务逻辑层   */
	private AssociationBiz biz=new AssociationBizImpl();
	/** 关键字  */
	private String keyWord;
	/** 返回的消息 */
	private String message;
	/** 当前页数 (分页操作) */
	private Integer curPage;
	/** 排序类型  */
	private String orderType;
	/** 排序字段   */
	private String orderField;
	/** 每页的数据量(分页操作) */
	private Integer pageSize;
	/** 总页数(分页操作) */
	private Integer totalPage;
	
	@Override
	public Association getModel() {
		return association;
	}

	public Association getAssociation() {
		return association;
	}

	public void setAssociation(Association association) {
		this.association = association;
	}

	public List<Association> getAssociationList() {
		return associationList;
	}

	public void setAssociationList(List<Association> associationList) {
		this.associationList = associationList;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public AssociationBiz getBiz() {
		return biz;
	}

	public void setBiz(AssociationBiz biz) {
		this.biz = biz;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	/**
	 * 添加社团
	 * @return
	 */
	public String creatAssociation(){
		flag=this.biz.addAssociation(association, studentId);
		if(flag){
			message="添加成功!";
			return SUCCESS;
		}else{
			message="当前业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 修改社团信息
	 * @return
	 */
	public String updateAssociation(){
		flag=this.biz.updateAssociation(association);
		if(flag){
			message="修改成功!";
			return SUCCESS;
		}else{
			message="当前业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 删除社团
	 * @return
	 */
	public String removeAssociation(){
		flag=this.biz.removeAssociation(association.getAssociationId());
		if(flag){
			message="删除社团成功!";
			return ERROR;
		}else{
			message="当前业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public String showAssociation(){
		/** 获取查询出的总记录条数  */
		totalPage=(int)(Math.ceil((double)this.biz.getPages( association.getAssociationId(),keyWord)/pageSize));
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
		//System.out.println(association.getStatus().getStatusId());
		associationList=this.biz.showAssociation(keyWord, curPage, pageSize, orderType, orderField, association.getStatus().getStatusId());
		//判断
		if(associationList!=null){
			message="查询成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}	
	}
}
