package br.com.rlsistemas.pedidosonline.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory	sessionFactory	= buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
//			AnnotationConfiguration cfg = new AnnotationConfiguration();
//			cfg.configure("hibernate.cfg.xml");
//			return cfg.buildSessionFactory();
			
			System.out.println("1");	
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			
			System.out.println("2");
			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(cfg.getProperties());

			StandardServiceRegistry servico = registradorServico.build();
			
			System.out.println("3");	
			return cfg.buildSessionFactory(servico);
		} catch (Throwable e) {
			System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	} 

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
