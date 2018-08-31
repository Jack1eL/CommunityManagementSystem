package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.peterpig.cms.bean.Association;
import com.peterpig.cms.bean.AssociationPosition;
import com.peterpig.cms.bean.Student;
import com.peterpig.cms.dao.AssociationPositionDAO;
import com.peterpig.cms.util.OpenTransactionUtils;
/**
 * 社团职务接口实现类
 * @author JackieL
 *
 */
public class AssociationPositionDAOImpl extends OpenTransactionUtils implements AssociationPositionDAO {

	@Override
	public boolean doCreat(AssociationPosition bean) {
		boolean flag=false; 
		super.openTransaction();  //开启事务
		try{
			AssociationPosition associationPosition=new AssociationPosition();
			associationPosition.setPositionName(bean.getPositionName());
			session.save(associationPosition);
			transaction.commit();
			flag=true;
		}catch(Exception e){
			System.out.println("---------------daoImpl出现问题!--------------");
			e.printStackTrace();
			transaction.rollback();  //增加出现问题进行回滚操作
		}
		return flag;
	}

	@Override
	public boolean doUpdate(AssociationPosition bean) {
		boolean flag=false;
		super.openTransaction();
		try{
			//先查询出此条记录，然后对社团职务表的记录进行修改
			AssociationPosition associationPosition=(AssociationPosition) session.get(AssociationPosition.class, bean.getPositionId());
			associationPosition.setPositionName(bean.getPositionName());
			session.save(associationPosition);  //保存修改后的信息
			transaction.commit();  //提交
			flag=true;
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题!-------------------");
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		super.openTransaction();
		try{
			//同样的是先查询出此记录然后再做删除，因为当某些职务删除，就必须将部分学生的职务进行修改为3(普通学生)
			AssociationPosition associationPosition=(AssociationPosition) session.get(AssociationPosition.class, id);
			AssociationPosition ap=(AssociationPosition) session.get(AssociationPosition.class, 3);
			/**
			 * 当次职务删除，则需要将部分学生的职务修改为3
			 */
			Set<Student> student=associationPosition.getStudents(); 
			for(Student studentSet : student){
				studentSet.setPosition(ap);
				session.save(studentSet);
			}
			session.save(associationPosition);
			transaction.commit();
			flag=true;
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题!-------------------");
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public List<AssociationPosition> pageSelAll(String keyWord,
			Integer curPage, Integer pageSize, String orderType,
			String orderField,Integer beanId) {
		List<AssociationPosition> apList=null;
		super.openTransaction();
		try{
			apList=new ArrayList<AssociationPosition>();
			//模糊查询: 1、根据用户提供的关键字(社团名。社团简介。社团状态)； 2、设置排序的字段； 3、设置排序的方式。 
			String hql1="from AssociationPosition where ";
			String hql2=" position_name like ? order by "+orderField+" "+orderType;
			if(beanId!=null){
				hql2="position_name like ? and position_id=?  order by "+orderField+" "+orderType;		
			}
			Query query=session.createQuery(hql1+hql2);  
			query.setString(0, "%"+keyWord+"%");
			if(beanId!=null)
				query.setInteger(1, beanId);
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			apList=query.list();  //将查询出的结果放入集合中
			transaction.commit();
		}catch(Exception e){
			System.out.print("----------------daoImpl出现问题!-----------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return apList;
	}

	@Override
	public AssociationPosition findById(Integer id) {
		AssociationPosition ap=null;
		super.openTransaction();
		try{
			//根据id查询
			ap=(AssociationPosition) session.get(AssociationPosition.class, id);
			transaction.commit();
		}catch(Exception e){
			System.out.println("----------------daoImpl出现问题!-------------------");
			e.printStackTrace();
			transaction.rollback();
		}
		return ap;
	}

	@Override
	public Long getAllCount(String keyWord,Integer beanId) {
		Long count=0L;   //创建一个长整型变量,便于获取查询结果进行返回
		super.openTransaction();
		try{
			//创建查询语句，根据用户提供的关键字查询记录总数
			String hql1="select count(position_id) from AssociationPosition where ";
			String hql2="position_name like ?";
			if(beanId!=null){
				hql2="position_name like ? and association_id=?";
			}	
			Query query=session.createQuery(hql1+hql2);   //创建查询
			// 根据分页查询提供的参数进行模糊查询 
			query.setString(0, "%"+keyWord+"%");
			if(beanId!=null)
				query.setInteger(1, beanId);
			count=(Long) query.uniqueResult();  //获取查询的结果
			transaction.commit();
		}catch(Exception e){
			System.out.println("-----------------daoImpl出现问题!------------------");
			transaction.rollback();
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public AssociationPosition findByBean(AssociationPosition bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
