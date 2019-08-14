package com.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.Bean.ExamBean;
import com.Bean.QuestionBean;
import com.Bean.StudentExamBean;
import com.Bean.studentBean;




public class studentDao {
	
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	JdbcTemplate stmt;
	
	
	//static Session session = null;

	public void insert(studentBean studentbean) {

	Session	session = sessionFactory.openSession();
		session.save(studentbean);
		session.close();

	}



	public List<studentBean> datavalidation(String  e, String p) {
		
		Session	session=sessionFactory.openSession();
		List<studentBean> ls=session.createQuery("from studentBean where username='"+e+"' and password='"+p+"'").list();
		if(ls.size()==0)
		{
			return null;
		}
		session.close();
		
		// TODO Auto-generated method stub
		return ls;
	}



	public List<ExamBean> examlist() {
		Session	session=sessionFactory.openSession();
List<ExamBean> list=(List<ExamBean>) session.createQuery("from ExamBean").list();
		
		for (ExamBean bean:list)
		{
			System.out.println(bean.getExamid());
			System.out.println(bean.getTitle());
			System.out.println(bean.getDate());
			System.out.println(bean.getTotalmarks());
			System.out.println(bean.getDuration());
			System.out.println(bean.getExamcode());
			
		}
		
	session.close();
		return list;
	}


	public List<ExamBean> getAlldata(ExamBean examBean) {
		Session	session=sessionFactory.openSession();
		List<ExamBean> list=session.createQuery("from ExamBean where examcode='"+examBean.getExamcode()+"'").list();
    session.close();
		return list;
	}



	public List<QuestionBean> getAlldataofQuestion(int id) {
		Session	session=sessionFactory.openSession();
		List<QuestionBean> list=session.createQuery("from QuestionBean where examid='"+id+"'").list();
		session.close();
		return list;
	}



	public List<QuestionBean> score(String[] ans) {
		Session	session=sessionFactory.openSession();
		List<QuestionBean> list=session.createQuery("from QuestionBean where answer='"+ans+"'").list();
		return list;
	}



	public List<QuestionBean> questioncheck(int examid) {
		Session session=sessionFactory.openSession();
		List<QuestionBean> list=session.createQuery("from QuestionBean where examid='"+examid+"'").list();
		return list;
	}



	public void insertexam(StudentExamBean studentxambean) {

		Session	session = sessionFactory.openSession();
			session.save(studentxambean);
			session.close();
		
	}


}
