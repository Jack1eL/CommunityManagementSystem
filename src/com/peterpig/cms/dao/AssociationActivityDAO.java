package com.peterpig.cms.dao;

import java.util.List;

import com.peterpig.cms.bean.AssociationActivity;

public interface AssociationActivityDAO extends baseDAO<AssociationActivity, Integer> {
	public List<AssociationActivity> findAllByStatusId(String keyWord, Integer curPage, Integer pageSize, String orderType, String orderField, Integer beanId,Integer statusId);
}
