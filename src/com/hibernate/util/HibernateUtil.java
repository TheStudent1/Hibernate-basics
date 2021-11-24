package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.client.entities.Client;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;
	public static ServiceRegistry serviceRegistry = null;

	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure();

			configuration.addAnnotatedClass(Client.class);

			serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Throwable th) {
			System.err.println("Initial Session Factory creation failed:" + th);
			throw new ExceptionInInitializerError(th);

		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
