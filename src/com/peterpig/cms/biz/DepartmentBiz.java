package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.Department;

public interface DepartmentBiz {
	/**
	 * 添加
	 * @param bean 要添加的类型
	 * @return 添加成功返回true，添加失败返回false
	 */
	public boolean addDepartment(Department department);
	
	/**
	 * 修改
	 * @param bean 要修改的类
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean updateDepartment(Department department);
	
	/**
	 * 删除
	 * @param id 根据id删除记录
	 * @return 删除成功返回true，删除失败返回false
	 */
	public boolean removeDepartment(Integer departmentId);
	
	/**
	 * 查询分页操作(支持模糊查询)
	 * @param keyWord 关键字
	 * @param curPage 每页的数据量
	 * @param pageSize 页数
	 * @param orderType 排序是为升序还是降序
	 * @param orderField 根据此字段排序
	 * @return 返回列表
	 */
	public List<Department> findAllDepartment(String keyWord,Integer curPage,Integer pageSize,String orderType,String orderField,Integer departmentId);
	
	/**
	 * 根据id查询数据
	 * @param id 参数id
	 * @return 返回查询的类型
	 */
	public Department findById(Integer departmentId);
	
	/**
	 * 查询数据的总数
	 * @param keyWord 根据关键字查询数据的总数
	 * @return 返回长整型总数数量
	 */
	public Long getAllCount(String keyWord,Integer departmentId);
}
