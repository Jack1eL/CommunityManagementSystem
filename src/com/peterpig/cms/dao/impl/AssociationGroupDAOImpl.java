package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

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
		List<AssociationGroup> agList=null;
		super.openTransaction();
		try{
			String hql="from AssociationGroup where (association_id like ? or group_number like ?) and group_id like ?";
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			query.setString(1,"%"+keyWord+"%");
			query.setInteger(2,beanId);
			if(beanId==null)
				query.setString(2,"%%");
			//分页设置
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			agList=query.list();  //将查询的结果放入容器
			transaction.commit();
		}catch(Exception e){
			System.out.println("---------------daoImpl出现问题！--------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return agList;
	}

	@Override
	public AssociationGroup findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount(String keyWord,Integer beanId) {
		Long count=0L;
		super.openTransaction();
		try{
			String hql="select count(association_id) from AssociationGroup where (association_id like ? or group_number like ?) and group_id like ?";
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			query.setString(1,"%"+keyWord+"%");
			query.setInteger(2,beanId);
			if(beanId==null)
				query.setString(2,"%%");
			count=(Long) query.uniqueResult(); 
			transaction.commit();
		}catch(Exception e){
			System.out.println("---------------daoImpl出现问题！--------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public AssociationGroup findByBean(AssociationGroup bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long findGroupCount(Integer associationId) {
		Long count=0L;
		super.openTransaction();
		try{
			String hql="select count(association_id) from AssociationGroup where association_id=?";
			Query query=session.createQuery(hql);
			query.setInteger(0, associationId);
			
			count=(Long) query.uniqueResult(); 
			transaction.commit();
		}catch(Exception e){
			System.out.println("---------------daoImpl出现问题！--------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return count;
	}


}
