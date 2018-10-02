package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.AssociationGroup;

/**
 * 社团组业务逻辑层接口
 * @author JackieL
 *
 */
public interface AssociationGroupBiz {
	
	/**
	 * 添加社团组
	 * @param ag 社团组对象
	 * @return 添加成功返回true，添加失败返回false
	 */
	public boolean addAssociationGroup(AssociationGroup ag);
	
	/**
	 * 修改社团组
	 * @param ag 社团组对象 
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean updateAssociationGroup(AssociationGroup ag);
	
	/**
	 * 删除社团组
	 * @param associationId 要删除的社团组的id
	 * @return 删除成功返回true，删除失败false
	 */
	public boolean removeAssociationGroup(Integer agId);
	
	/**
	 * 分页查询社团组 
	 * @param keyWord 关键字
	 * @param curPage 每页的数据量
	 * @param pageSize 页数
	 * @param orderType 排序方式
	 * @param orderField 排序字段
	 * @param agId 组id
	 * @return 返回查询出的列表
	 */
	public List<AssociationGroup> showAssociationGroup(String keyWord,Integer curPage,Integer pageSize,String orderType,String orderField,Integer agId);
	
	/**
	 * 获取查询的数据量，便于分页
	 * @param keyWord 关键字
	 * @param agId 组id
	 * @return 返回长整型整数
	 */
	public Long getPages(String keyWord,Integer agId);
	
	public Long getGroupCount(Integer associationId);
}
