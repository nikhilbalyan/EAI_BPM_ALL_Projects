package com.spring.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.pojo.UserDetails;

public class UserDAOImpl implements UserDaoInterface {

	static SessionFactory sessionFactory;
	static Session session;

	public boolean add(int num) {

		try {
			for (int i = 0; i < num; i++) {
				UserDetails usr = new UserDetails();
				usr.setUserName("user " + i);
				session.save(usr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;

	}

	public boolean read(int num) {
		try {
			UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
			System.out.println("user name read from db is = " + user.getUserName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(int num) {
		try {
			int kk = 3;
			UserDetails user2 = (UserDetails) session.get(UserDetails.class, kk);
			user2.setUserName("Updated User hola");
			session.update(user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int num) {
		try {
		UserDetails user1 = (UserDetails) session.get(UserDetails.class, 6);
		session.delete(user1);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean startConnection() {
		try {
			String hibernateFilePath = "hibernate.cfg.xml";

			sessionFactory = new Configuration().configure(hibernateFilePath).buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean closeConnection() {
		try {
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
