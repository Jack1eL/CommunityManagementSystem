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
	public boolean deleteActivity(Integer id);
	
	/**
	 * 查询所有活动
	 * 1、通过关键字模糊查询
	 * 2、分页查询
	 * 3、排序
	 * @param keyWord 关键字
	 * @param curPage 当前页
	 * @param pageSize 页内记录数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @return 活动集合
	 */
	public List<AssociationActivity> findAllActivity(String keyWord,Integer curPage,Integer pageSize,String orderType,String orderField);
	
	/**
	 * 查询某社团所有活动
	 * 1、通过关键字模糊查询
	 * 2、分页查询
	 * 3、排序
	 * @param keyWord 关键字
	 * @param curPage 当前页
	 * @param pageSize 页内记录数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @param associationId 所属社团编号
	 * @return 活动集合
	 */
	public List<AssociationActivity> findAllActivityByAssociationId(String keyWord,Integer curPage,Integer pageSize,String orderType,String orderField,Integer associationId);
	
	/**
	 * 查询某社团所有活动
	 * 1、通过关键字模糊查询
	 * 2、分页查询
	 * 3、排序
	 * @param keyWord 关键字
	 * @param curPage 当前页
	 * @param pageSize 页内记录数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @param associationId 所属社团编号
	 * @param statusId 状态编号
	 * @return 活动集合
	 */
	public List<AssociationActivity> findAllByStatusId(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField, Integer associationId, Integer statusId);
	
	/**
	 * 通过活动编号查询活动详情
	 * @param id 活动编号
	 * @return 返回AssociationActivity对象，为null时未查询到
	 */
	public AssociationActivity findById(Integer activityId);
	
	/**
	 * 查询所有的活动数
	 * 1、关键字查询
	 * @param keyWord 关键字
	 * @return 活动的数目
	 */
	public Long getAllCount(String keyWord);
	
	/**
	 * 查询某社团所有的活动数
	 * 1、关键字查询
	 * @param keyWord 关键字
	 * @param associationId 社团编号
	 * @return 活动的数目
	 */
	public Long getAllCount(String keyWord,Integer associationId);
	
	public Long getAllCount(String keyWord, Integer associationId,
			Integer statusId);
	
	/**
	 * 修改状态
	 * @param activityId 活动ID
	 * @param statusId 状态
	 * @return 修改成功true，失败false
	 */
	public boolean changeStatus(Integer activityId,Integer statusId);
}
