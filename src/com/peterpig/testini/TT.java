package com.peterpig.testini;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.peterpig.bean.AssociationActivity;
import com.peterpig.bean.SignIn;
import com.peterpig.bean.SignInType;
import com.peterpig.bean.Student;
import com.peterpig.util.HibernateUtils;

public class TT {
	public static void main(String[] args) {
		Session session=HibernateUtils.openSession();
		Transaction ts=session.beginTransaction();
		try {
//			Department d=(Department) session.get(Department.class, 1);
//			
//			for(Major m:d.getMajors()){
//				for(Classes c:m.getClasses()){
//					System.out.println(m.getGrade()+"级"+m.getMajorName()+c.getClassNumber()+"班");
//				}
//			}
			
//			Association a=(Association) session.get(Association.class, 1);
//			AuditStatus status=(AuditStatus) session.get(AuditStatus.class, 1);
//			
//			AssociationActivity aa=new AssociationActivity();
//			aa.setActivityName("篮球社常规训练");
//			aa.setExplains("为了提高大家的球感");
//			aa.setAssociation(a);
//			aa.setStatus(status);
//			aa.setActivityBegin(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-7-24 18:00:00").getTime()));
//			aa.setActivityEnd(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-7-24 20:00:00").getTime()));
//			
//			session.save(a);
//			session.save(status);
//			session.save(aa);
//			AssociationActivity aa=(AssociationActivity) session.get(AssociationActivity.class, 1);
//			Student student=(Student) session.get(Student.class, 1);
//			SignInType type=(SignInType) session.get(SignInType.class, 1);
//			
//			SignIn s=new SignIn();
//			s.setActivity(aa);
//			s.setSigninTime(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-7-24 18:3:00").getTime()));
//			s.setStudent(student);
//			s.setType(type);
//			
//			session.save(aa);
//			session.save(student);
//			session.save(type);
//			session.save(s);
			
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}
	}
}
