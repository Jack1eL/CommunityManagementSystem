package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.AssociationActivity;

public interface AssociationActivityBiz {
	/**
	 * 添加社团活动
	 * @param activity 活动对象
	 * @return 添加成功返回true，失败返回false
	 */
	public boolean addActivity(AssociationActivity activity);
	
	/**
	 * 修改社团活动
	 * @param activity 活动对象
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean updateActivity(AssociationActivity activity);
	
	/**
	 * 删除社团活动
	 * @param id 活动编号
	 * @return 删除成功返回true，失败返回false
	 */
	public boolean updateActivity(Integer id);
	
	public List<AssociationActivity> findAllActivity();
	
	
}
