package com.doodle.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DBManager {
	/*manage user*/
	public static List<User> findAllUsers() {
		List<User> users = null;
		try{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			Query query = em.createQuery("SELECT u FROM User u");
			users = query.getResultList();
			// update entities, etc.
			em.close();
			emf.close();
		} catch(Exception e){
			System.out.println("Exception: " + e);
		}
		
		return users;
	}
	
	
	public static User findUserByUsername(String username, String password){
		User user = null;
		try {
			EntityManagerFactory emf = 
							Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			Query query = em.createQuery("SELECT u FROM User u Where u.username = '" + username + "'");
			user = (User) query.getSingleResult();
			System.out.println(user.getUsername());
			if(!user.getPassword().equals(password)){
				user = null;
			}
			// update entities, etc.
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e);
		}
		return user;
	}
	
	public static User findUserByUsername(String username){
		User user = null;
		try {
			EntityManagerFactory emf = 
							Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			Query query = em.createQuery("SELECT u FROM User u Where u.username = '" + username + "'");
			user = (User) query.getSingleResult();
			System.out.println(user.getUsername());
			// update entities, etc.
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e);
		}
		return user;
	}
	
	
	public static void addUser(User user) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			em.persist(user);
			// update entities, etc.
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	/*manage event*/
	public static int addEventAndGetId(Event event){
		int id = 0;
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			em.persist(event);
			// update entities, etc.
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		id = DBManager.findAllEvents().get(DBManager.findAllEvents().size()-1).getId();
		return id;
	}
	
	public static List<Event> findAllEvents(){
		List<Event> events =null;
		try {
			EntityManagerFactory emf = 
							Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT e FROM Event e");
			events = query.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return events;
	}
	
	public static Event findEventById(int id){
		Event event = null;
		try {
			EntityManagerFactory emf = 
							Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			Query query = em.createQuery("SELECT e FROM Event e Where e.id = " + id);
			event = (Event) query.getSingleResult();
			System.out.println(event.getName());
			// update entities, etc.
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e);
		}
		return event;
	}
	
	/*manage detail*/
	public static List<Detail> findAllDetails(){
		List<Detail> details = null;
		try {
			EntityManagerFactory emf = 
							Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT d FROM Detail d");
			details = query.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return details;
	}
	
	public static Detail findDetailById(int id){
		Detail detail = null;
		try {
			EntityManagerFactory emf = 
							Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			Query query = em.createQuery("SELECT d FROM Detail d Where d.id = " + id);
			detail = (Detail) query.getSingleResult();
			System.out.println(detail.getDate());
			// update entities, etc.
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e);
		}
		return detail;
	}
	
	public static void addDetail(Detail detail) {
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			em.persist(detail);
			// update entities, etc.
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	public static void deleteDetail(int id){
		try {
			EntityManagerFactory emf = 
							Persistence.createEntityManagerFactory("DoodleWebApp");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			// Perform finds, execute queries,...
			Detail detail = em.find(Detail.class, id);
			em.remove(detail);
			// update entities, etc.
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception: " + e);
		}
	}
}
