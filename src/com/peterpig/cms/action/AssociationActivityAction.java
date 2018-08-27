package com.peterpig.cms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.peterpig.cms.bean.AssociationActivity;

public class AssociationActivityAction extends ActionSupport implements
		ModelDriven<AssociationActivity> {
	/**  */
	private AssociationActivity associationActivity=new AssociationActivity();
	
	
	
	
	
	@Override
	public AssociationActivity getModel() {
		// TODO Auto-generated method stub
		return associationActivity;
	}

}
