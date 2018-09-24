package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.Admin;

public interface AdminBiz {
	/**
	 * 添加
	 * @param bean 要添加的类型
	 * @return 添加成功返回true，添加失败返回false
	 */
	public boolean addAdmin(Admin admin);
	
	/**
	 * 修改
	 * @param bean 要修改的类
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean updateAdmin(Admin admin);
	
	/**
	 * 删除
	 * @param id 根据id删除记录
	 * @return 删除成功返回true，删除失败返回false
	 */
	public boolean removeAdmin(Integer adminId);
	
	/**
	 * 查询分页操作(支持模糊查询)
	 * @param keyWord 关键字
	 * @param curPage 每页的数据量
	 * @param pageSize 页数
	 * @param orderType 排序是为升序还是降序
	 * @param orderField 根据此字段排序
	 * @return 返回列表
	 */
	public List<Admin> findAllAdmin(String keyWord,Integer curPage,Integer pageSize,String orderType,String orderField,Integer adminId);
	
	/**
	 * 根据id查询数据
	 * @param id 参数id
	 * @return 返回查询的类型
	 */
	public Admin findById(Integer adminId);
	
	/**
	 * 查询数据的总数
	 * @param keyWord 根据关键字查询数据的总数
	 * @return 返回长整型总数数量
	 */
	public Long getAllCount(String keyWord,Integer adminId);
	/**
	 * 登陆方法
	 * @param bean
	 * @return
	 */
	public Admin login(Admin bean);
}
