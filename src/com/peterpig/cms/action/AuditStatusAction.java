package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.AuditStatus;
import com.peterpig.cms.biz.AuditStatusBiz;
import com.peterpig.cms.biz.impl.AuditStatusBizImpl;

public class AuditStatusAction extends ActionSupport implements
		ModelDriven<AuditStatus> {
	/** 执行结果用于进行判断  */
	private boolean flag;
	/** 社团状态类属性  */
	private AuditStatus as=new AuditStatus();
	/** 社团状态列表属性   */
	private List<AuditStatus> asList=new ArrayList<AuditStatus>();
	/** 社团审核状态业务逻辑层类属性   */
	private AuditStatusBiz biz=new AuditStatusBizImpl();
	/** 关键字 */
	private String keyWord;
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
	/** 返回的消息 */
	private String message;
	
	@Override
	public AuditStatus getModel() {	
		return as;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public AuditStatus getAs() {
		return as;
	}

	public void setAs(AuditStatus as) {
		this.as = as;
	}

	public List<AuditStatus> getAsList() {
		return asList;
	}

	public void setAsList(List<AuditStatus> asList) {
		this.asList = asList;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public AuditStatusBiz getBiz() {
		return biz;
	}

	public void setBiz(AuditStatusBiz biz) {
		this.biz = biz;
	}

	/**
	 * 添加社团审核状态
	 * @return
	 */
	public String creatAuditStatus(){
		flag=this.biz.addAuditStatus(as);
		//判断
		if(flag){
			message="审核状态添加成功!";
			return SUCCESS;
		}else{
			message="当前业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 修改社团审核状态
	 * @return
	 */
	public String updateAuditStatus(){
		flag=this.biz.udpateAuditStatus(as);
		if(flag){
			message="修改审核状态信息成功!";
			return SUCCESS;
		}else{
			message="当前业务繁忙!";
			return ERROR;
		}
	}
	
	/**
	 * 删除审核状态
	 * @return
	 */
	public String removeAuditStatus(){
		flag=this.biz.removeAuditStatus(as.getStatusId());
		if(flag){
			message="删除审核状态成功!";
			return SUCCESS;
		}else{
			message="当前业务繁忙!";
			return ERROR;
		}
	}
	
	public String showAuditStatus(){
		totalPage=(int)(Math.ceil((double)this.biz.getPages(keyWord, as.getStatusId())));
		/** 进行查询并进行分页保存 */
		asList=this.biz.showAuditStatus(keyWord, curPage, pageSize, orderType, orderField, as.getStatusId());
		//判断
		if(asList!=null){
			message="查询成功!";
			return SUCCESS;
		}else{
			message="业务繁忙!";
			return ERROR;
		}	
	}
}
