package com.peterpig.cms.action;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.Admin;
import com.peterpig.cms.biz.AdminBiz;
import com.peterpig.cms.biz.impl.AdminBizImpl;

public class AdminAction extends ActionSupport implements
ModelDriven<Admin> {
	/** 用户对象 */
	private Admin admin = new Admin();
	/** 用户逻辑接口 */
	private AdminBiz adminBiz = new AdminBizImpl();
	/** 用户列表  */
	private ArrayList<Admin> list = new ArrayList<Admin>();
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
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminBiz getAdminBiz() {
		return adminBiz;
	}
	public void setAdminBiz(AdminBiz adminBiz) {
		this.adminBiz = adminBiz;
	}
	public ArrayList<Admin> getList() {
		return list;
	}
	public void setList(ArrayList<Admin> list) {
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
	
	
	public String login(){
		admin = adminBiz.login(admin);
		if(admin!=null){
			Map<String,Object> session = ActionContext.getContext().getSession();
			ActionContext.getContext().getValueStack().push(admin);
			session.put("Admin", admin);
			result = "loginOK";
		}else{
			message = "用户名或密码错误";
			result = "loginFAIL";
		}
		return result;
	}
	
	public String regist(){
		if(adminBiz.addAdmin(admin)){
			message = "注册成功";
			result = "registOK";
		}else{
			message = "注册失败";
			result = "registFAIL";
		}
		return result;
	}
	
	public String update(){
		if(adminBiz.updateAdmin(admin)){
			message = "修改成功";
			result = "updateOK";
		}else{
			message = "修改失败";
			result = "updateFAIL";
		}
		return result;
	}
	
	public String remove(){
		if(adminBiz.removeAdmin(admin.getAdminId())){
			message = "删除成功";
			result = "removeOK";
		}else{
			message = "删除失败";
			result = "removeFAIL";
		}
		return result;
	}
	public String logout(){
		Map<String,Object> session = ActionContext.getContext().getSession();
		ActionContext.getContext().getValueStack().push(admin);
		session.remove(admin);
		result = "logoutOK";
		return result;
	}
	public String findAll(){
		totalPage=(int)(Math.ceil(((double)adminBiz.getAllCount(keyWord, admin.getAdminId()))/pageSize));
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
		list = (ArrayList<Admin>) adminBiz.findAllAdmin(keyWord, curPage, pageSize, orderType, orderField, admin.getAdminId());
		if(list != null)
			result="findbyjspOK";
		else
			result="findbyjspFAIL";
		return result;
	}
}
