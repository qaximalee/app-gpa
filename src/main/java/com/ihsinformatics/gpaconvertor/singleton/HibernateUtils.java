package com.ihsinformatics.gpaconvertor.singleton;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// sessionFactory = getSessionFactoryByOtherMethod();
			try {
				registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

				MetadataSources sources = new MetadataSources(registry);

				Metadata metadata = sources.getMetadataBuilder().build();

				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
				e.printStackTrace();
				if (registry != null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
		return sessionFactory;
	}

	private static SessionFactory getSessionFactoryByOtherMethod() {
		// TODO Auto-generated method stub

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistry serviceReg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceReg);
		return sessionFactory;
	}

	public static Session getHibernateSession() {
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		final Session session = sf.openSession();
		return session;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
