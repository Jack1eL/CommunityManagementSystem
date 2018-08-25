package com.peterpig.cms.dao;

import java.util.List;
import java.util.Map;

/**
 * 公共接口类
 * @author JackieL
 *
 * @param <T> bean中类
 * @param <K> Integer类型
 */
public interface baseDAO<T, K> {
	
	/**
	 * 添加
	 * @param bean 要添加的类型
	 * @return 添加成功返回true，添加失败返回false
	 */
	public boolean doCreat(T bean);
	
	/**
	 * 修改
	 * @param bean 要修改的类
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean doUpdate(T bean);
	
	/**
	 * 删除
	 * @param id 根据id删除记录
	 * @return 删除成功返回true，删除失败返回false
	 */
	public boolean doRemove(K id);
	
	/**
	 * 查询分页操作(支持模糊查询)
	 * @param keyWord 关键字
	 * @param curPage 每页的数据量
	 * @param pageSize 页数
	 * @param orderType 排序是为升序还是降序
	 * @param orderField 根据此字段排序
	 * @return 返回列表
	 */
	public List<T> pageSelAll(String keyWord,K curPage,K pageSize,String orderType,String orderField,K beanId);
	
	/**
	 * 根据id查询数据
	 * @param id 参数id
	 * @return 返回查询的类型
	 */
	public T findById(K id);
	
	/**
	 * 查询数据的总数
	 * @param keyWord 根据关键字查询数据的总数
	 * @return 返回长整型总数数量
	 */
	public Long getAllCount(String keyWord,K beanId);
	
	
	/**
	 * 根据用户提供的信息精准查询
	 * @param bean 实体类型
	 * @return 返回对象类型
	 */
	public T findByBean(T bean);
	
}
