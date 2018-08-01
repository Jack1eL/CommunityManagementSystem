package com.peterpig.cms.dao.impl;

import java.util.List;
import java.util.Map;

import com.peterpig.cms.bean.Association;
import com.peterpig.cms.bean.AuditStatus;
import com.peterpig.cms.dao.AssociationDAO;
import com.peterpig.cms.util.OpenTransactionUtils;
/**
 * 社团实现类
 * @author JackieL
 *
 */
public class AssociationDAOImpl extends OpenTransactionUtils implements
		AssociationDAO {
	
	@Override
	public boolean doCreat(Association bean) {
		boolean flag=false;  //默认返回值为false
		super.openTransaction();   //开启事务，进行数据操作
		try{
			/**/
			Association association=new Association();
			AuditStatus audiStatus=new AuditStatus();
			//将要添加的信息set进对象属性值中进行保存
			association.setName(bean.getName());
			
			
		}
		return false;
	}

	@Override
	public boolean doUpdate(Association bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Association> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Association findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Association findByBean(Association bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
