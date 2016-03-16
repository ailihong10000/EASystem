package dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BaseDao {
	private HibernateTemplate hibernateTemplate;
	private SessionFactory sessionFactory;

	protected HibernateTemplate getHibernateTemplate() {
		hibernateTemplate=new HibernateTemplate(sessionFactory);
		return hibernateTemplate;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
