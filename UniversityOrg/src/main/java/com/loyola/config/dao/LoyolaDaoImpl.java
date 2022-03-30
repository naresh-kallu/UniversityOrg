package com.loyola.config.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.loyola.entity.LoyolaEntity;

@Repository
public class LoyolaDaoImpl {
	
	public SessionFactory sessionFactory() {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=config.buildSessionFactory();
		return sessionFactory;
	}
	public List<LoyolaEntity> getAll(LoyolaEntity entity){
		SessionFactory factory=sessionFactory();
		Session session=factory.openSession();
		//session.beginTransaction();
		String query="FROM loyola_table";
	Query query2=session.createQuery(query);
	List<LoyolaEntity> loyola=query2.list();
		
		return loyola;
	}

}
