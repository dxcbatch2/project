package com.dxc.web.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtils {
	

	private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final String HIBERNATE_CFG = "hibernate.cfg.xml";

    private static SessionFactory buildSessionFactory() 
    {
        Configuration cfg = new Configuration().addResource(HIBERNATE_CFG).configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
                applySettings(cfg.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}