package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.SignInType;
import com.peterpig.cms.biz.SignInTypeBiz;
import com.peterpig.cms.biz.impl.SignInTypeBizImpl;

public class SignInTypeAction extends ActionSupport implements ModelDriven<SignInType>{
	/** 签到类型对象 */
	private SignInType signinType=new SignInType();
	/** 签到类型列表 */
	private List<SignInType> list=new ArrayList<SignInType>();
	/** 签到类型的逻辑层接口 */
	private SignInTypeBiz biz=new SignInTypeBizImpl();
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
	public SignInType getSigninType() {
		return signinType;
	}
	public void setSigninType(SignInType signinType) {
		this.signinType = signinType;
	}
	public List<SignInType> getList() {
		return list;
	}
	public void setList(List<SignInType> list) {
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
	
	/*-----------------------------业务-----------------------------*/
	public String add(){
		if(biz.addSignInType(signinType)){
			message="添加成功";
			return SUCCESS;
		}else{
			message="添加失败";
			return INPUT;
		}
	}
	
	public String update(){
		if(biz.updateSignInType(signinType)){
			message="修改成功";
			return SUCCESS;
		}else{
			message="修改失败";
			return INPUT;
		}
	}
	
	public String delete(){
		if(biz.deleteSignInType(signinType.getTypeId())){
			message="删除成功";
			return SUCCESS;
		}else{
			message="删除失败";
			return INPUT;
		}
	}
	
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)biz.getAllCount(keyWord))/pageSize));
		list=biz.findAllSignInType(keyWord, curPage, pageSize, orderType, orderField);
		
		if(list!=null){
			message="查询成功";
			
			return SUCCESS;
		}else{
			message="查询失败";
			
			return INPUT;
		}
	}
	
	public String findBySignInTypeId(){
		signinType=biz.findById(signinType.getTypeId());
		if(signinType!=null){
			message="查询成功";
			return SUCCESS;
		}else{
			message="查询失败";
			return INPUT;
		}
	}
	
	
	@Override
	public SignInType getModel() {
		return signinType;
	}
	
}
