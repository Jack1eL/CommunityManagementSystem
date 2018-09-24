package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.AssociationActivity;
import com.peterpig.cms.biz.AssociationActivityBiz;
import com.peterpig.cms.biz.impl.AssociationActivityBizImpl;

public class AssociationActivityAction extends ActionSupport implements
		ModelDriven<AssociationActivity> {
	/** 社团活动对象 */
	private AssociationActivity associationActivity=new AssociationActivity();
	/** 社团活动逻辑层接口 */
	private AssociationActivityBiz biz=new AssociationActivityBizImpl();
	/** 社团活动列表 */
	private List<AssociationActivity> list=new ArrayList<AssociationActivity>();
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
	
	/*-----------------------------GETTER AND SETTER-----------------------------*/
	public AssociationActivity getAssociationActivity() {
		return associationActivity;
	}
	public void setAssociationActivity(AssociationActivity associationActivity) {
		this.associationActivity = associationActivity;
	}
	public List<AssociationActivity> getList() {
		return list;
	}
	public void setList(List<AssociationActivity> list) {
		this.list = list;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	
	/*-----------------------------业务-----------------------------*/
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)biz.getAllCount(keyWord))/pageSize));
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
		
		
		list=biz.findAllActivity(keyWord, curPage, pageSize, orderType, orderField);
		
		if(list!=null){
			message="查询成功";
			
			return SUCCESS;
		}else{
			message="查询失败";
			
			return INPUT;
		}
	}
	
	public String findAllByAssociationId(){
		totalPage=(int)(Math.ceil(((double)biz.getAllCount(keyWord,associationActivity.getAssociation().getAssociationId()))/pageSize));
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
		
		list=biz.findAllActivityByAssociationId(keyWord, curPage, pageSize, orderType, orderField, associationActivity.getAssociation().getAssociationId());
		
		if(list!=null){
			message="查询成功";
			
			return SUCCESS;
		}else{
			message="查询失败";
			
			return INPUT;
		}
	}
	
	public String findByActivityId(){
		associationActivity=biz.findById(associationActivity.getActivityId());
		if(associationActivity!=null){
			message="查询成功";
			return SUCCESS;
		}else{
			message="查询失败";
			return INPUT;
		}
	}
	
	
	@Override
	public AssociationActivity getModel() {
		// TODO Auto-generated method stub
		return associationActivity;
	}

}
