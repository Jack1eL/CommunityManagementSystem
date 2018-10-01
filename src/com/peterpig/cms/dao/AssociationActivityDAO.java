package com.peterpig.cms.dao;

import java.util.List;

import com.peterpig.cms.bean.AssociationActivity;

public interface AssociationActivityDAO extends baseDAO<AssociationActivity, Integer> {
	public List<AssociationActivity> findAllByStatusId(String keyWord, Integer curPage, Integer pageSize, String orderType, String orderField, Integer beanId,Integer statusId);
	
	/**
	 * 修改状态
	 * @param activityId 活动ID
	 * @param statusId 状态
	 * @return 修改成功true，失败false
	 */
	public boolean changeStatus(Integer activityId,Integer statusId);
}
