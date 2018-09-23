package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.AssociationPosition;
import com.peterpig.cms.biz.AssociationPositionBiz;
import com.peterpig.cms.biz.impl.AssociationPositionBizImpl;

public class AssociationPositionAction extends ActionSupport implements
		ModelDriven<AssociationPosition> {
	/** 获取biz层的执行结果 */
	private boolean flag;
	/** 社团职务对象  */
	private AssociationPosition ap=new AssociationPosition();
	/** 社团职务业务逻辑层 */
	private AssociationPositionBiz biz=new AssociationPositionBizImpl();
	/** 社团职务类泛型的容器 */
	private List<AssociationPosition> apList=new ArrayList<AssociationPosition>();
	/** 关键字 */
	private String keyWord;
	/** 返回消息 */
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
	public AssociationPosition getModel() {
		return ap;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public AssociationPosition getAp() {
		return ap;
	}

	public void setAp(AssociationPosition ap) {
		this.ap = ap;
	}

	public AssociationPositionBiz getBiz() {
		return biz;
	}

	public void setBiz(AssociationPositionBiz biz) {
		this.biz = biz;
	}

	public List<AssociationPosition> getApList() {
		return apList;
	}

	public void setApList(List<AssociationPosition> apList) {
		this.apList = apList;
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
	
	/**
	 * 增加社团职务
	 * @return
	 */
	public String creatAssociationPosition(){
		flag=this.biz.addAssociaitonPostion(ap);
		if(flag){
			message="增加成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 修改社团职务
	 * @return
	 */
	public String updateAssociationPosition(){
		flag=this.biz.updateAssociationPosition(ap);
		if(flag){
			message="修改成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 删除社团某个职务
	 * @return
	 */
	public String removeAssociationPosition(){
		flag=this.biz.removeAssociationPosition(ap.getPositionId());
		if(flag){
			message="删除成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 分页查询出社团职务
	 * @return
	 */
	public String showAssociationPosition(){
		/** 获取查询出的总记录条数  */
		totalPage=(int)(Math.ceil((double)this.biz.getPages(keyWord, ap.getPositionId())));
		/** 进行查询并进行分页保存 */
		apList=this.biz.showAssociationPosition(keyWord, curPage, pageSize, orderType, orderField, ap.getPositionId());
		//判断
		if(apList!=null){
			message="查询成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}	
	}
}
