package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.AssociationGroup;
import com.peterpig.cms.biz.AssociationGroupBiz;
import com.peterpig.cms.dao.AssociationGroupDAO;
import com.peterpig.cms.dao.impl.AssociationGroupDAOImpl;
/**
 * 社团组业务逻辑层类
 * @author JackieL
 *
 */
public class AssociationGroupBizImpl implements AssociationGroupBiz {
	/** 社团组数据访问层接口类属性  */
	private AssociationGroupDAO dao;
	
	/**
	 * 构造方法，向下转型数据访问层
	 */
	public AssociationGroupBizImpl(){
		this.dao=new AssociationGroupDAOImpl();
	}
	@Override
	public boolean addAssociationGroup(AssociationGroup ag) {
		boolean flag=false;
		try{
			flag=this.dao.doCreat(ag);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateAssociationGroup(AssociationGroup ag) {
		boolean flag=false;
		try{
			flag=this.dao.doUpdate(ag);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeAssociationGroup(Integer agId) {
		boolean flag=false;
		try{
			flag=this.dao.doRemove(agId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<AssociationGroup> showAssociationGroup(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField, Integer agId) {
		List<AssociationGroup> agList=null;
		try{
			agList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, agId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return agList;
	}

	@Override
	public Long getPages(String keyWord, Integer agId) {
		Long count=0L;
		try{
			count=this.dao.getAllCount(keyWord, agId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return count;
	}

}
