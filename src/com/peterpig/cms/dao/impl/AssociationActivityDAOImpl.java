package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.peterpig.cms.bean.AssociationActivity;
import com.peterpig.cms.dao.AssociationActivityDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class AssociationActivityDAOImpl extends OpenTransactionUtils implements
		AssociationActivityDAO {

	@Override
	public boolean doCreat(AssociationActivity bean) {
		boolean flag=false;
		super.openTransaction();
		try {
			
			session.save(bean);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(AssociationActivity bean) {
		boolean flag=false;
		super.openTransaction();
		try {
			
			session.save(bean);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		super.openTransaction();
		try {
			AssociationActivity activity=(AssociationActivity) session.get(AssociationActivity.class, id);
			session.delete(activity);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<AssociationActivity> pageSelAll(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField) {
		List<AssociationActivity> activityList=new ArrayList<AssociationActivity>();
		try {
			
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return activityList;
	}

	@Override
	public AssociationActivity findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssociationActivity findByBean(AssociationActivity bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
