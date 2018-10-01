package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.Association;

/**
 * 社团业务逻辑层接口
 * @author JackieL
 *
 */
public interface AssociationBiz {
	
	/**
	 * 增加社团(当学生申请一个社团需要由管理员审核，所以需要此学生的信息，并且不能马上增加，因为需要通过审核才可)
	 * @param association 申请的社团的信息 
	 * @param studentId 申请人员，当审核通过时将此学生升级为社长
	 * @return 申请成功返回true，申请失败返回false
	 */
	public boolean addAssociation(Association association,Integer studentId);
	
	/**
	 * 修改社团信息
	 * @param association 修改的社团的对象
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean updateAssociation(Association association);
	
	/**
	 * 删除社团，并且将此社团内的学生和组进行解散
	 * @param associationId 删除的社团的id
	 * @return 删除成功返回true，删除失败返回false
	 */
	public boolean removeAssociation(Integer associationId);
	
	
	public Association findById(Integer id);
	
	/**
	 * 查询社团
	 * @param keyWord 关键字
	 * @param curPage 当前页的数据量
	 * @param pageSize 页数 
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @param associationId 社团id(查询条件)
	 * @return 返回Association泛型的容器
	 */
	public List<Association> showAssociation(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField,Integer associationId);
	
	/**
	 * 查询总记录数目
	 * @param associationId 社团id
	 * @param keyWord 关键字查询
	 * @return 返回长整型整数
	 */
	public Long getPages(Integer associationId,String keyWord);
	
	/**
	 * 通过某个社团的申请
	 * @param associationId 社团的id 
	 * @return 通过成功返回true，通过失败返回false
	 */
	public boolean passAssociation(Integer associationId);
	
	/**
	 * 拒绝某个社团的申请
	 * @param associationId 社团的id
	 * @param studentId 学生的id
	 * @return 拒绝成功返回true，拒绝失败返回false
	 */
	public boolean refuseAssociation(Integer associationId,Integer studentId);
}
