package org.iesvdm.streams;
// Generated 15 dic. 2022 23:59:33 by Hibernate Tools 5.6.9.Final

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Home object for domain model class Cliente.
 * @see Cliente
 * @author Hibernate Tools
 */
public class ClienteHome {

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		} catch (Exception e) {
			throw new IllegalStateException("No puedo crear SessionFactory");
		}
	}

	public void beginTransaction() {
		sessionFactory.getCurrentSession().beginTransaction();
	}

	public void commitTransaction() {
		sessionFactory.getCurrentSession().getTransaction().commit();
	}

	public void rollbackTransaction() {
		sessionFactory.getCurrentSession().getTransaction().rollback();
	}

	public List<Cliente> findAll() {
		List<Cliente> lst = null;

		lst = sessionFactory.getCurrentSession().createQuery("SELECT c FROM Cliente c", Cliente.class)
				.getResultList();

		return lst;
	}
}
