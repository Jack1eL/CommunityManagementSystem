package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.AssociationPosition;
import com.peterpig.cms.biz.AssociationPositionBiz;
import com.peterpig.cms.dao.AssociationPositionDAO;
import com.peterpig.cms.dao.impl.AssociationPositionDAOImpl;
/**
 * 社团职务业务逻辑层类
 * @author JackieL
 *
 */
public class AssociationPositionBizImpl implements AssociationPositionBiz {
	/** 社团职务数据访问层接口类属性   */
	private AssociationPositionDAO dao;
	
	/**
	 * 构造方法
	 */
	public AssociationPositionBizImpl(){
		this.dao=new AssociationPositionDAOImpl();
	}
	@Override
	public boolean addAssociaitonPostion(AssociationPosition ap) {
		boolean flag=false;
		try{
			flag=this.dao.doCreat(ap);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateAssociationPosition(AssociationPosition ap) {
		boolean flag=false;
		try{
			flag=this.dao.doUpdate(ap);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeAssociationPosition(Integer apId) {
		boolean flag=false;
		try{
			flag=this.dao.doRemove(apId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<AssociationPosition> showAssociationPosition(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField, Integer apId) {
		List<AssociationPosition> apList=null;
		try{
			apList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, apId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return apList;
	}

	@Override
	public Long getPages(String keyWord, Integer apId) {
		Long count=0L;
		try{
			count=this.dao.getAllCount(keyWord, apId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return count;
	}

}
