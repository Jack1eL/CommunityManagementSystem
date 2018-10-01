package com.peterpig.cms.dao;

import com.peterpig.cms.bean.Association;
/**
 * 社团接口类
 * @author JackieL
 *
 */
public interface AssociationDAO extends baseDAO<Association, Integer> {
	
	/**
	 * 添加社团
	 * @param bean 在社团表中添加纪录
	 * @param studentId 关联某个学生所添加的社团
	 * @return 添加成功返回true。添加失败返回false
	 */
	public boolean creatAssociation(Association bean,Integer studentId);
	
	/**
	 * 通过某个社团
	 * @param associationId 社团id
	 * @return 通过成功返回true，通过失败返回false
	 */
	public boolean updateAssociationToPass(Integer associationId);
	
	/**
	 * 拒绝某个社团的申请
	 * @param associationId 社团id
	 * @param studentId 申请的学生的id
	 * @return 拒绝成功返回true，拒绝失败返回false
	 */
	public boolean updateAssociationToRefuse(Integer associationId,Integer studentId);
}
