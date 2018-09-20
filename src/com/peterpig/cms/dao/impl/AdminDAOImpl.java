package com.peterpig.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.peterpig.cms.bean.Admin;
import com.peterpig.cms.dao.AdminDAO;
import com.peterpig.cms.util.OpenTransactionUtils;

public class AdminDAOImpl extends OpenTransactionUtils implements AdminDAO {

	@Override
	public boolean doCreat(Admin bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			Admin admin = new Admin();
			admin.setUsername(bean.getUsername());
			admin.setPassword(bean.getPassword());
			session.save(admin);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean doUpdate(Admin bean) {
		boolean flag = false;
		super.openTransaction();
		try{
			//通过adminid查出此管理员
			Admin admin = (Admin) session.get(Admin.class,bean.getAdminId());
			//只允许修改密码
			admin.setPassword(bean.getPassword());
			session.save(admin);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public boolean doRemove(Integer id) {
		boolean flag = false;
		super.openTransaction();
		try{
			Admin admin = (Admin) session.get(Admin.class, id);
			session.delete(admin);
			transaction.commit();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return flag;
	}

	@Override
	public List<Admin> pageSelAll(String keyWord, Integer curPage,Integer pageSize, String orderType, String orderFiel,Integer beanId) {
		List<Admin> list = null;
		super.openTransaction();
		try{
			String hql="from Admin where username like ? admin_id like ? order by "+orderFiel+" "+orderType;
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1, "");
			}else{
				query.setInteger(1, beanId);
			}
			query.setFirstResult((curPage-1)*pageSize);
			query.setMaxResults(pageSize);
			list=query.list(); //将查询出的内容保存到列表中
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Admin findById(Integer id) {
		Admin admin = null;
		super.openTransaction();
		try{
			admin = (Admin) session.get(Admin.class, id);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}
		return admin;
	}

	@Override
	public Long getAllCount(String keyWord,Integer beanId) {
		Long count=0l;
		super.openTransaction();
		try{
			String hql="select count(adminId) from Admin where username like ? and adminid like ?";
			Query query=session.createQuery(hql);
			query.setString(0, "%"+keyWord+"%");
			if(beanId==null){
				query.setString(1, "");
			}else{
				query.setInteger(1, beanId);
			}
			count=(Long)query.uniqueResult();
			transaction.commit();
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Admin findByBean(Admin bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
