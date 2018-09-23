package com.peterpig.cms.biz.impl;

import java.util.List;

import com.peterpig.cms.bean.AuditStatus;
import com.peterpig.cms.biz.AuditStatusBiz;
import com.peterpig.cms.dao.AuditStatusDAO;
import com.peterpig.cms.dao.impl.AuditStatusDAOImpl;
/**
 * 审核状态业务逻辑层类
 * @author JackieL
 *
 */
public class AuditStatusBizImpl implements AuditStatusBiz {
	/** 审核状态数据访问层接口类属性  */
	private AuditStatusDAO dao;
	
	/**
	 * 无参数构造方法，实例化实现层
	 */
	public AuditStatusBizImpl(){
		this.dao=new AuditStatusDAOImpl();
	}
	
	@Override
	public boolean addAuditStatus(AuditStatus as) {
		boolean flag=false;
		try{
			flag=this.dao.doCreat(as);
		}catch(Exception e){
			System.out.println("-----------------biz层出现问题-----------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean udpateAuditStatus(AuditStatus as) {
		boolean flag=false;
		try{
			flag=this.dao.doUpdate(as);
		}catch(Exception e){
			System.out.println("-----------------biz层出现问题-----------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeAuditStatus(Integer asId) {
		boolean flag=false;
		try{
			flag=this.dao.doRemove(asId);
		}catch(Exception e){
			System.out.println("-----------------biz层出现问题-----------------");
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<AuditStatus> showAuditStatus(String keyWord, Integer curPage,
			Integer pageSize, String orderType, String orderField,
			Integer asId) {
		List<AuditStatus> asList=null;
		try{
			asList=this.dao.pageSelAll(keyWord, curPage, pageSize, orderType, orderField, asId);
		}catch(Exception e){
			System.out.println("-----------------biz层出现问题-----------------");
			e.printStackTrace();
		}
		return asList;
	}

	@Override
	public Long getPages(String keyWord, Integer asId) {
		Long count=0L;
		try{
			count=this.dao.getAllCount(keyWord, asId);
		}catch(Exception e){
			System.out.println("-----------------biz层出现问题-----------------");
			e.printStackTrace();
		}
		return count;
	}

}
