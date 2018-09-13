package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.SignIn;
import com.peterpig.cms.biz.SignInBiz;
import com.peterpig.cms.biz.impl.SignInBizImpl;

public class SignInAction extends ActionSupport implements ModelDriven<SignIn> {
	
	/** 签到对象 */
	private SignIn signin=new SignIn();
	/** 签到列表 */
	private List<SignIn> list = new ArrayList<SignIn>();
	/** 签到对象的逻辑层接口 */
	private SignInBiz biz= new SignInBizImpl();
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
	public SignIn getSignin() {
		return signin;
	}
	public void setSignin(SignIn signin) {
		this.signin = signin;
	}
	public List<SignIn> getList() {
		return list;
	}
	public void setList(List<SignIn> list) {
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
		if(biz.addSignIn(signin)){
			message="添加成功";
			return SUCCESS;
		}else{
			message="添加失败";
			return INPUT;
		}
	}
	
	public String update(){
		if(biz.updateSignIn(signin)){
			message="添加成功";
			return SUCCESS;
		}else{
			message="添加失败";
			return INPUT;
		}
	}
	
	public String delete(){
		if(biz.deleteSignIn(signin.getSigninId())){
			message="添加成功";
			return SUCCESS;
		}else{
			message="添加失败";
			return INPUT;
		}
	}
	
	
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)biz.getAllCount(keyWord))/pageSize));
		list=biz.findAllSignIn(keyWord, curPage, pageSize, orderType, orderField);
		
		if(list!=null){
			message="查询成功";
			
			return SUCCESS;
		}else{
			message="查询失败";
			
			return INPUT;
		}
	}
	
	public String findAllByActivityId(){
		totalPage=(int)(Math.ceil(((double)biz.getAllCount(keyWord))/pageSize));
		list=biz.findAllSignInByActivityId(keyWord, curPage, pageSize, orderType, orderField, signin.getActivity().getActivityId());
		
		if(list!=null){
			message="查询成功";
			
			return SUCCESS;
		}else{
			message="查询失败";
			
			return INPUT;
		}
	}
	
	public String findBySignInId(){
		signin=biz.findById(signin.getSigninId());
		if(signin!=null){
			message="查询成功";
			return SUCCESS;
		}else{
			message="查询失败";
			return INPUT;
		}
	}
	
	
	
	@Override
	public SignIn getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
