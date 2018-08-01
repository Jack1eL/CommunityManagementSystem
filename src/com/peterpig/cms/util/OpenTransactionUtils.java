package com.peterpig.cms.util;

import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 * 开启处理事务类，在各个dao层真实类中被继承
 * @author JackieL
 *
 */
public class OpenTransactionUtils {
	/**  session对象  */
	public Session session;
	/**  transaction对象  */
	public Transaction transaction;
	
	/**
	 * 开启事务
	 */
	public void openTransaction(){
		session=HibernateUtils.openSession();
		transaction=session.beginTransaction();
	}
}
