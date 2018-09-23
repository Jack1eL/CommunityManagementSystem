package com.peterpig.cms.biz;

import java.util.List;

import com.peterpig.cms.bean.AuditStatus;

/**
 * 审核状态业务逻辑层接口类
 * @author JackieL
 *
 */
public interface AuditStatusBiz {
	
	/**
	 * 增加审核状态
	 * @param as 审核状态对象
	 * @return 增加成功返回true，增加失败返回false
	 */
	public boolean addAuditStatus(AuditStatus as);
	
	/**
	 * 修改审核状态
	 * @param as 审核状态对象
	 * @return 修改成功返回true，修改失败返回false
	 */
	public boolean udpateAuditStatus(AuditStatus as);
	
	/**
	 * 删除审核状态
	 * @param asId 根据审核id删除
	 * @return 删除成功返回true，删除失败返回false
	 */
	public boolean removeAuditStatus(Integer asId);
	
	/**
	 * 分页查询审核状态 
	 * @param keyWord 关键字
	 * @param curPage 当前页
	 * @param pageSize 页数
	 * @param orderType 排序类型
	 * @param orderField 排序字段
	 * @param asId 社团审核状态id
	 * @return 返回列表
	 */
	public List<AuditStatus> showAuditStatus(String keyWord,Integer curPage,Integer pageSize,String orderType,String orderField,Integer asId);
	
	/**
	 * 查询总页数
	 * @param keyWord 关键字
	 * @param asId 社团审核状态id
	 * @return
	 */
	public Long getPages(String keyWord,Integer asId);
}
