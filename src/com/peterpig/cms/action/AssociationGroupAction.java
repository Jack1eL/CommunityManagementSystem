package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.AssociationGroup;
import com.peterpig.cms.biz.AssociationGroupBiz;
import com.peterpig.cms.biz.impl.AssociationGroupBizImpl;

public class AssociationGroupAction extends ActionSupport implements
		ModelDriven<AssociationGroup> {
	/** 执行结果的保存  */
	private boolean flag;
	/** 社团组对象  */
	private AssociationGroup ag=new AssociationGroup();
	/** 社团组业务逻辑层  */
	private AssociationGroupBiz biz=new AssociationGroupBizImpl();
	/** 关键字  */
	private String keyWord;
	/** 返回的消息 */
	private String message;
	/** 社团组泛型容器  */
	private List<AssociationGroup> agList=new ArrayList<AssociationGroup>();
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
	public AssociationGroup getModel() {
		return ag;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public AssociationGroup getAg() {
		return ag;
	}

	public void setAg(AssociationGroup ag) {
		this.ag = ag;
	}

	public AssociationGroupBiz getBiz() {
		return biz;
	}

	public void setBiz(AssociationGroupBiz biz) {
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

	public List<AssociationGroup> getAgList() {
		return agList;
	}

	public void setAgList(List<AssociationGroup> agList) {
		this.agList = agList;
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
	
	/**
	 * 添加某个社团的组
	 * @return
	 */
	public String creatAssociationGroup(){
		flag=this.biz.addAssociationGroup(ag);
		if(flag){
			//当添加成功
			message="添加成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 修改社团组信息
	 * @return
	 */
	public String updateAssociationGroup(){
		flag=this.biz.updateAssociationGroup(ag);
		if(flag){
			message="修改成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 删除社团组
	 * @return
	 */
	public String removeAssociationGroup(){
		flag=this.biz.removeAssociationGroup(ag.getGroupId());
		if(flag){
			message="删除成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 分页查询出社团组信息
	 * @return
	 */
	public String showAssociationGroup(){
		/** 获取查询出的总记录条数  */
		totalPage=(int)(Math.ceil((double)this.biz.getPages(keyWord, ag.getGroupId())));
		/** 进行查询并进行分页保存 */
		agList=this.biz.showAssociationGroup(keyWord, curPage, pageSize, orderType, orderField, ag.getGroupId());
		//判断
		if(agList!=null){
			message="查询成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}	
	}
	
	/**
	 * 获取社团的组数
	 * @return
	 */
	public String findGroupCountById(){
		/** 获取查询出的总记录条数  */
		totalPage=(int)(Math.ceil((double)this.biz.getGroupCount(ag.getAssociation().getAssociationId())));
		if(totalPage!=null){
			System.out.println(totalPage);
			message="查询成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}
	}
}
