package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.SignIn;

public interface SignInBiz {
	/**
	 * 添加一个签到
	 * @param signin 签到对象
	 * @return 签到成功返回true，失败返回false
	 */
	public boolean addSignIn(SignIn signin);
	
	/**
	 * 修改一个签到
	 * @param signin 签到对象
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean updateSignIn(SignIn signin);
	
	/**
	 * 删除一个签到
	 * @param id 签到记录的编号
	 * @return 删除成功返回true，失败返回false
	 */
	public boolean deleteSignIn(Integer id);
	
	/**
	 * 查询所有签到记录
	 * 1、通过关键字模糊查询
	 * 2、分页查询
	 * 3、排序
	 * @param keyWord 关键字
	 * @param curPage 当前页
	 * @param pageSize 页内记录数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @return 签到记录集合
	 */
	public List<SignIn> findAllSignIn(String keyWord, Integer curPage, Integer pageSize, String orderType, String orderField);
	
	/**
	 * 查询某活动的所有签到记录
	 * 1、通过关键字模糊查询
	 * 2、分页查询
	 * 3、排序
	 * @param keyWord 关键字
	 * @param curPage 当前页
	 * @param pageSize 页内记录数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @param activityId 活动编号
	 * @return 签到记录集合
	 */
	public List<SignIn> findAllSignInByActivityId(String keyWord, Integer curPage, Integer pageSize, String orderType, String orderField, Integer activityId);
	
	/**
	 * 通过编号查询签到记录
	 * @param signinId 签到编号
	 * @return 签到对象
	 */
	public SignIn findById(Integer signinId);
	
	/**
	 * 查询所有的活动数
	 * 1、关键字查询
	 * @param keyWord 关键字
	 * @return 签到记录数
	 */
	public Long getAllCount(String keyWord);
	
	/**
	 * 查询某社团所有的活动数
	 * 1、关键字查询
	 * @param keyWord 关键字
	 * @return 签到记录数
	 */
	public Long getAllCount(String keyWord, Integer activityId);
}
