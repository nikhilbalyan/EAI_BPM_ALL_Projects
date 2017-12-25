package com.spring.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.pojo.UserDetails;

public class SpringHibernateMain {
	static SessionFactory sessionFactory;
	static Session session;
	
	public static void main(String[] args) {
		
//		userDao = new UserDAOImpl();
		UserDAOImpl userDao = new UserDAOImpl();
		userDao.startConnection();
		userDao.add(10);
		userDao.update(3);
		userDao.delete(4);
		userDao.read(3);
		userDao.closeConnection();
/*		// starting connection method call
		startConnection();

		// add to database method call
		addToDatabase(5);

		// we have put it here to save the user because
		// we can save user only after beginning the transaction
		// create operation
		for (int i = 0; i < 10; i++) {
			UserDetails usr = new UserDetails();
			usr.setUserName("user " + i);
			session.save(usr);
		}

		// read user name
		// we can write this after session.close also because it is eager
		// fetch and it is not lazy fetch inside eager fetch we don't
		// need to take care about where to try to display data because it
		// is already fetched and here we don't have a list or collection
		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
		System.out.println("user name read from db is = " + user.getUserName());

		// update user name
		int kk = 3;
		UserDetails user2 = (UserDetails) session.get(UserDetails.class, kk);
		user2.setUserName("Updated User");
		session.update(user2);

		// delete username with id 6 we delete the user object simply
		// by calling the delete before deleting we need to fetch/pull the user
		// that is why we created user1 object
		UserDetails user1 = (UserDetails) session.get(UserDetails.class, 6);
		session.delete(user1);

		// call for closing connection
		closeConnection();
*/	}

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

	public static boolean addToDatabase(int n) {

		try {
			for (int i = 0; i < n; i++) {
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
