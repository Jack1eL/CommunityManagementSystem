package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.AssociationPosition;

/**
 * 社团职务业务逻辑层接口类
 * @author JackieL
 *
 */
public interface AssociationPositionBiz {
	/**
	 * 增加社团职务
	 * @param ap 社团职务对象
	 * @return 增加成功返回true，增加失败返回false
	 */
	public boolean addAssociaitonPostion(AssociationPosition ap);
	
	/**
	 * 修改社团职务
	 * @param ap 社团职务对象
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean updateAssociationPosition(AssociationPosition ap);
	
	/**
	 * 删除社团职务
	 * @param apId 社团职务id
	 * @return 删除成功返回true，删除失败返回false
 	 */
	public boolean removeAssociationPosition(Integer apId);
	
	/**
	 * 查询社团职务(分页)
	 * @param keyWord 关键字
	 * @param curPage 每页的数据量
	 * @param pageSize 页数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @param apId 社团职务id
	 * @return 返回AssociationPosition泛型的容器
	 */
	public List<AssociationPosition> showAssociationPosition(String keyWord,Integer curPage,Integer pageSize,String orderType,String orderField,Integer apId);
	
	/**
	 * 查询总记录数目
	 * @param keyWord 关键字
	 * @param apId 社团职务id
	 * @return 返回长整型
	 */
	public Long getPages(String keyWord,Integer apId);
}
