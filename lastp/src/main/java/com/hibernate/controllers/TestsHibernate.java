package com.hibernate.controllers;

import java.util.Iterator;
import java.util.List;


import java.util.Properties;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.spi.Criteria;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.models.Artiste;
import com.hibernate.models.Etudiant;
import com.hibernate.models.Film;
import com.hibernate.models.Pays;
import com.hibernate.models.Region;



import org.hibernate.HibernateException;
import org.hibernate.Transaction;
//import tp1.Etudiant;

public class TestsHibernate {
/**
* Objet Session de Hibernate
*/

	private Session session;

/**
* Constructeur établissant une connexion avec Hibernate
*/
public TestsHibernate() {
Configuration configuration =  new Configuration().configure("/hibernate.cfg.xml");

//ICI ON AJOUTE LES CLASSES JPA
configuration.addAnnotatedClass(Etudiant.class);
configuration.addAnnotatedClass(Film.class);
configuration.addAnnotatedClass(Pays.class);
configuration.addAnnotatedClass(Artiste.class);
configuration.addAnnotatedClass(Region.class);

//FIN DE L'AJOUT DES CLASSES JPA
try {
//ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//
//SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	
	ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
			.applySettings(configuration.getProperties()).build();
	
SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
/*
ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
SessionFactory sessionFactory = new    configuration.buildSessionFactory(serviceRegistry);
//Configuration().configure().buildSessionFactory();
*/

session = sessionFactory.openSession();
}
catch (Exception ex)
{
throw new RuntimeException("Probleme de configuration : "
+ ex.getMessage(), ex);
}
}

////////////////// Insertion dans la BD/////////////////////////

public void InsertEtu(Etudiant etu){
    session.beginTransaction();
	session.save(etu);
	session.getTransaction().commit();
	session.close();
	}


public void InsertArt(Artiste art){
    session.beginTransaction();
	session.save(art);
	session.getTransaction().commit();
	session.close();
	}

public void InsertFilm(Film film){
    session.beginTransaction();
	session.save(film);
	session.getTransaction().commit();
	session.close();
	}


////////////////////  Recuperation des donnees de la BD ///////////////////////////////

@SuppressWarnings("unchecked")
public List<Etudiant> lectureEtuHQL() {
	
@SuppressWarnings("rawtypes")
Query query = session.createQuery("from Etudiant");

return query.list();
}
//Liste des films
  @SuppressWarnings({ "unchecked", "deprecation" })
public List<Film> lectureFlmHQL() {
@SuppressWarnings("rawtypes")	
Query query = session.createQuery("from Film");



return query.list();
}
  
//Liste de pays
  @SuppressWarnings("unchecked")
public List<Pays> lecturePaysHQL() {
@SuppressWarnings("rawtypes")	
Query query = session.createQuery("from Pays");

return query.list();


}

//Liste des artistes
  @SuppressWarnings("unchecked")
public List<Artiste> lectureArtHQL() {
@SuppressWarnings("rawtypes")	
Query query = session.createQuery("from Artiste");

return query.list();
}
//Liste des regions
  @SuppressWarnings("gunchecked")
public List<Region> lectureRegHQL() {
@SuppressWarnings("rawtypes")	
Query query = session.createQuery("from Region");

return query.list();
}
}
