package com.ttl.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;

import com.ttl.entity.Student;

import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;

import org.hibernate.SessionFactory;

public class HibernateUtil {

	private static org.hibernate.service.ServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null) {
			
			//configurations
			Configuration configuration=new Configuration();
			
			Properties settings=new Properties();
			
			settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
			settings.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate_db?useSSL=false");
			settings.put(Environment.USER, "root");
			settings.put(Environment.PASS,"Rugved@2015");
			
			settings.put(Environment.SHOW_SQL, "true");
			
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			settings.put(Environment.HBM2DDL_AUTO, "update");
			
			configuration.setProperties(settings);
			configuration.addAnnotatedClass(Student.class);
			
			StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionFactory=configuration.buildSessionFactory(serviceRegistry);
			
			
		
		}
		return sessionFactory;
	}
	
	public static void shutdown()
	{
		if(registry!=null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
	
}
