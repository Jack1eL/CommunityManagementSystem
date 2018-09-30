package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.AssociationActivity;
import com.peterpig.cms.biz.AssociationActivityBiz;
import com.peterpig.cms.dao.AssociationActivityDAO;
import com.peterpig.cms.dao.impl.AssociationActivityDAOImpl;

public class AssociationActivityBizImpl implements AssociationActivityBiz {
	private AssociationActivityDAO dao;
	
	public AssociationActivityBizImpl(){
		dao=new AssociationActivityDAOImpl();
	}
	
	@Override
	public boolean addActivity(AssociationActivity activity) {
		boolean flag=false;
		try {
			flag=this.dao.doCreat(activity);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateActivity(AssociationActivity activity) {
		boolean flag=false;
		try {
			flag=this.dao.doUpdate(activity);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteActivity(Integer id) {
		boolean flag=false;
		try {
			flag=this.dao.doRemove(id);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<AssociationActivity> findAllActivity(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField) {
		List<AssociationActivity> activityList=null;
		try {
			activityList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, null);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return activityList;
	}

	@Override
	public List<AssociationActivity> findAllActivityByAssociationId(
			String keyWord, Integer curPage, Integer pageSize,
			String orderType, String orderField, Integer associationId) {
		List<AssociationActivity> activityList=null;
		try {
			activityList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, associationId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return activityList;
	}

	@Override
	public List<AssociationActivity> findAllByStatusId(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField, Integer associationId, Integer statusId) {
		List<AssociationActivity> activityList=null;
		try {
			activityList=this.dao.findAllByStatusId(keyWord, curPage, pageSize, orderType, orderField, associationId,statusId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return activityList;
	}

	@Override
	public AssociationActivity findById(Integer activityId) {
		AssociationActivity activity=null;
		try {
			activity=this.dao.findById(activityId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return activity;
	}

	@Override
	public Long getAllCount(String keyWord) {
		Long count=0L;
		try {
			count=this.dao.getAllCount(keyWord, null);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Long getAllCount(String keyWord, Integer associationId) {
		Long count=0L;
		try {
			count=this.dao.getAllCount(keyWord, associationId);
		} catch (Exception e) {
			System.out.println("--------bizimpl出现异常---------");
			e.printStackTrace();
		}
		return count;
	}


}
