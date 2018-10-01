package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.Association;
import com.peterpig.cms.biz.AssociationBiz;
import com.peterpig.cms.dao.AssociationDAO;
/**
 * 业务逻辑层实现类
 * @author JackieL
 *
 */
import com.peterpig.cms.dao.impl.AssociationDAOImpl;
/**
 * 业务逻辑层实现类
 * @author JackieL
 *
 */
public class AssociationBizImpl implements AssociationBiz {
	/**  社团实现层接口类属性  **/
	private AssociationDAO dao;
	
	public AssociationBizImpl(){
		this.dao=new AssociationDAOImpl();
	}
	
	@Override
	public boolean addAssociation(Association association, Integer studentId) {
		boolean flag=false;
		try{
			flag=this.dao.creatAssociation(association, studentId);
		}catch(Exception e){
			System.out.println("-----------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateAssociation(Association association) {
		boolean flag=false;
		try{
			flag=this.dao.doUpdate(association);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeAssociation(Integer associationId) {
		boolean flag=false;
		try{
			flag=this.dao.doRemove(associationId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return flag;
	}


	@Override
	public Association findById(Integer id) {
		Association association=null;
		try {
			association=this.dao.findById(id);
		} catch (Exception e) {
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return association;
	}

	
	@Override
	public List<Association> showAssociation(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer associationId) {
		List<Association> associationList=null;
		try{
			associationList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, associationId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return associationList;
	}

	@Override
	public Long getPages(Integer associationId, String keyWord) {
		Long count=0L;
		try{
			count=this.dao.getAllCount(keyWord, associationId);
		}catch(Exception e){
			System.out.println("------------biz层报错!-------------");
			e.printStackTrace();
		}
		return count;
	}

}
