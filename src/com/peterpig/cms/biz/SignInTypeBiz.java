package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.SignInType;

public interface SignInTypeBiz {
	/**
	 * 添加签到类型
	 * @param type 签到类型
	 * @return 添加成功返回true，失败返回false
	 */
	public boolean addSignInType(SignInType type);
	
	/**
	 * 修改签到类型
	 * @param type 签到类型
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean updateSignInType(SignInType type);
	
	/**
	 * 删除签到类型
	 * @param id 签到类型编号
	 * @return 删除成功返回true，失败返回false
	 */
	public boolean deleteSignInType(Integer id);
	
	/**
	 * 查询所有签到类型记录
	 * 1、通过关键字模糊查询
	 * 2、分页查询
	 * 3、排序
	 * @param keyWord 关键字
	 * @param curPage 当前页
	 * @param pageSize 页内记录数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @return 签到类型集合
	 */
	public List<SignInType> findAllSignInType(String keyWord, Integer curPage, Integer pageSize, String orderType, String orderField);
	
	/**
	 * 通过编号查询签到类型记录
	 * @param signinTypeId 签到类型编号
	 * @return 签到类型对象
	 */
	public SignInType findById(Integer signinTypeId);
	
	/**
	 * 查询所有的活动数
	 * 1、关键字查询
	 * @param keyWord 关键字
	 * @return 签到类型记录数
	 */
	public Long getAllCount(String keyWord);
	
}
