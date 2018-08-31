package com.peterpig.cms.dao.impl;

import java.util.List;
import java.util.Set;

import com.peterpig.cms.bean.AssociationGroup;
import com.peterpig.cms.bean.Student;
import com.peterpig.cms.dao.AssociationGroupDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class AssociationGroupDAOImpl extends OpenTransactionUtils implements AssociationGroupDAO {

	@Override
	public boolean doCreat(AssociationGroup bean) {
		boolean flag=false;
		super.openTransaction();
		try{
			AssociationGroup ag=new AssociationGroup();
			ag.setGroupNumber(bean.getGroupNumber());
			transaction.commit();
		}catch(Exception e){
			System.out.println("---------------daoImpl出现问题！--------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(AssociationGroup bean) {
		boolean flag=false;
		super.openTransaction();
		try{
			AssociationGroup ag=(AssociationGroup) session.get(AssociationGroup.class, bean.getGroupId());
			ag.setGroupNumber(bean.getGroupNumber());
			session.save(ag);
			Set<Student> studentSet=ag.getStudents();   //修改完组的信息之后，学生所在组的信息也要修改
			for(Student stSet : studentSet){
				stSet.setGroup(ag);
				session.save(stSet);
			}
			transaction.commit();
			flag=true;
		}catch(Exception e){
			System.out.println("---------------daoImpl出现问题！--------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		super.openTransaction();
		try{
			AssociationGroup ag=(AssociationGroup) session.get(AssociationGroup.class, id);
			session.delete(ag);
			transaction.commit();
			flag=true;
 		}catch(Exception e){
 			System.out.println("---------------daoImpl出现问题！--------------");
			transaction.rollback();
			e.printStackTrace();
 		}
		return flag;
	}

	@Override
	public List<AssociationGroup> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,Integer beanId) {
		String hql="from AssociationGroup where association_id like ? ";
		return null;
	}

	@Override
	public AssociationGroup findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String keyWord,Integer beanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssociationGroup findByBean(AssociationGroup bean) {
		// TODO Auto-generated method stub
		return null;
	}


}
