package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.junit.Test;

import com.peterpig.cms.bean.AssociationActivity;
import com.peterpig.cms.dao.AssociationActivityDAO;
import com.peterpig.cms.util.OpenTransactionUtils;
/**
 * 社团活动数据连接层实现类
 * @author Evan
 *
 */
public class AssociationActivityDAOImpl extends OpenTransactionUtils implements
		AssociationActivityDAO {

	@Override
	public boolean doCreat(AssociationActivity bean) {
		boolean flag=false;
		super.openTransaction();
		try {
			
			session.save(bean);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(AssociationActivity bean) {
		boolean flag=false;
		super.openTransaction();
		try {
			
			session.save(bean);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag=false;
		super.openTransaction();
		try {
			AssociationActivity activity=(AssociationActivity) session.get(AssociationActivity.class, id);
			session.delete(activity);
			transaction.commit();
			flag=true;
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return flag;
	}


	@Override
	public List<AssociationActivity> pageSelAll(String keyWord, Integer curPage, Integer pageSize, String orderType, String orderField, Integer beanId) {
		List<AssociationActivity> activityList=null;
		super.openTransaction();
		try {
			//查询社团活动：1、活动名模糊查询 2、通过某一字段进行排序 3、分页
			String hql="from AssociationActivity where activityName like ? and association.associationId like ? order by "+orderField+" "+orderType;
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1, "");
			}else{
				query.setInteger(1, beanId);
			}
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			
			//执行查询并且保存到列表
			activityList=query.list();
//			for(AssociationActivity aa:activityList){
//				System.out.println(aa.getActivityId()+"\n"+aa.getActivityName());
//			}
			
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return activityList;
	}

	@Override
	public AssociationActivity findById(Integer id) {
		AssociationActivity aa=null;
		super.openTransaction();
		try {
			//通过活动ID查询社团活动
			String hql="from AssociationActivity where activityId=?";
			Query query=session.createQuery(hql);
			query.setInteger(0, id);
			
			//执行查询并且保存
			aa=(AssociationActivity) query.uniqueResult();
			
			//System.out.println(aa.getActivityName()+aa.getAssociation().getExplains());
			transaction.commit();
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return aa;
	}

	@Override
	public Long getAllCount(String keyWord) {
		Long count=0l;
		super.openTransaction();
		try{
			//查找社团活动表中的所有记录条数
			String hql="select count(activityId) from AssociationActivity where activityName like ?";
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			count=(Long)query.uniqueResult();
			
			//System.out.println(count);
			transaction.commit();
		}catch(Exception e){
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public AssociationActivity findByBean(AssociationActivity bean) {
		AssociationActivity aa=null;
		super.openTransaction();
		try {
			//通过社团活动的字段查询社团活动
			String hql="from AssociationActivity where activityName=? and explains=? and activityBegin=? and activityEnd=?";
			Query query=session.createQuery(hql);
			query.setString(0, bean.getActivityName());
			query.setString(1, bean.getExplains());
			query.setDate(2, bean.getActivityBegin());
			query.setDate(3, bean.getActivityEnd());
			
			//执行查询并且保存
			aa=(AssociationActivity) query.uniqueResult();
			
			System.out.println(aa);
			transaction.commit();
		} catch (Exception e) {
			System.out.println("--------daoimpl出现异常---------");
			transaction.rollback();
			e.printStackTrace();
		}
		return aa;
	}

	/**
	 * 测试
	 */
	@Test
	public void t(){
		//pageSelAll("",1,2,"asc","activityName",3);
		//findById(1);
		//getAllCount("");
		//AssociationActivity aa=new AssociationActivity();
		//aa.setActivityName("篮球社常规训练");
		//findByBean(aa);
	}

}
