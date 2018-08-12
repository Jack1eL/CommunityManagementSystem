package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.junit.Test;

import com.peterpig.cms.bean.Association;
import com.peterpig.cms.bean.AssociationPosition;
import com.peterpig.cms.bean.AuditStatus;
import com.peterpig.cms.bean.Student;
import com.peterpig.cms.dao.AssociationDAO;
import com.peterpig.cms.util.OpenTransactionUtils;
/**
 * 社团实现类
 * @author JackieL
 *
 */
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
			AuditStatus status= (AuditStatus)session.get(AuditStatus.class, bean.getAssociationId());//查询出未通过审核的数据
			Student student=(Student)session.get(Student.class, studentId);
			//将要添加的信息set进对象属性值中进行保存
			association.setName(bean.getName());
			association.setExplains(bean.getExplains());
			association.setStatus(status);
			student.setAssociation(association);
			session.save(association);
			session.save(student);
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
	public boolean doCreat(Association bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Association bean) {
		boolean flag=false;  //默认返回为false
		super.openTransaction(); //打开事务
		try{
			/* 先查询，再修改   */
			Association association=(Association) session.get(Association.class, bean.getAssociationId());   //查询
			association.setName(bean.getName());
			association.setExplains(bean.getExplains());
			session.save(association);
			transaction.commit();
			flag=true;
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题！----------------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		super.openTransaction(); //开启事务
		try{
			Association association=(Association) session.get(Association.class, 1);
			AssociationPosition position=(AssociationPosition) session.get(AssociationPosition.class, 4);
			/***
			 * 当次社团被删除，则所有的学生的职位改为普通学生，需要遍历修改
			 */
			Set<Student> student=association.getStudents();
			for(Student studentSet : student){
				studentSet.setPosition(position);
				session.save(studentSet);  //当删除了社团之后s
			}
			
			session.delete(association);
			transaction.commit();
			flag=true;
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题！----------------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<Association> pageSelAll(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField) {
		List<Association> associationList=null;
		super.openTransaction();
		try{
			associationList=new ArrayList<Association>();
			//模糊查询: 1、根据用户提供的关键字(社团名。社团简介。社团状态)； 2、设置排序的字段； 3、设置排序的方式。 
			String hql="from Association where name like ? or explains like ? or status_id like ? order by "+orderField+" "+orderType;
			Query query=session.createQuery(hql);  
			query.setString(0, "%"+keyWord+"%");
			query.setString(1, "%"+keyWord+"%");
			query.setString(2, "%"+keyWord+"%");
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			associationList=query.list();  //将查询出的结果放入集合中
			transaction.commit();
		}catch(Exception e){
			System.out.print("----------------daoImpl出现问题!-----------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return associationList;
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
	
	@Test
	public void test(){
		
	
	}

}
