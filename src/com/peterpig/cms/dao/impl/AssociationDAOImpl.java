package com.peterpig.cms.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.peterpig.cms.bean.Association;
import com.peterpig.cms.bean.AuditStatus;
import com.peterpig.cms.bean.Student;
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
	public boolean creatAssociation(Association bean,Integer studentId) {
		boolean flag=false;  //默认返回值为false
		super.openTransaction();   //开启事务，进行数据操作
		try{
			/* 如果要添加社团则需要先通过审核 */
			Association association=new Association();
			AuditStatus status= (AuditStatus)session.get(AuditStatus.class, 1);//查询出未通过审核的数据
			Student student=(Student)session.get(Student.class, studentId);
			//将要添加的信息set进对象属性值中进行保存
			association.setName(bean.getName());
			association.setExplains(bean.getExplains());
			association.setStatus(status);
			student.setAssociation(association);
			session.save(association);
			session.save(student);
			transaction.commit();
		}catch(Exception e){
			System.out.println("---------------daoImpl出现问题！--------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public boolean doCreat(Association bean) {
		// TODO Auto-generated method stub
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
