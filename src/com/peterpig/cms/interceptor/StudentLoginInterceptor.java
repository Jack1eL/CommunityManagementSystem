package com.peterpig.cms.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.peterpig.cms.bean.Admin;
import com.peterpig.cms.bean.Student;

public class StudentLoginInterceptor extends MethodFilterInterceptor {
	
	private String exludeAction;
	



	public String getExludeAction() {
		return exludeAction;
	}





	public void setExludeAction(String exludeAction) {
		this.exludeAction = exludeAction;
	}





	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {	
		String actionName=invocation.getInvocationContext().getName();
		if(actionName!=null && exludeAction.indexOf(actionName)!=-1)
			invocation.invoke();
		
		Admin admin=(Admin) ServletActionContext.getRequest().getSession().getAttribute("admin");
		
		if(admin==null){
			System.out.println("无权限访问!");
			return "nologin";
		}else{
			return invocation.invoke();
		}
		
	}

}
