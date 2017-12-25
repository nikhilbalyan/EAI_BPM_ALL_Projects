package com.spring.hibernate.mapping;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.mapping.pojo.CampusMind;
import com.hibernate.mapping.pojo.Orchard;
import com.hibernate.mapping.pojo.TeamLead;

public class UserDAOImpl implements UserDaoInterface {

	static SessionFactory sessionFactory = null;
	static Session session = null;
	static Transaction txn = null;

	public boolean add(Orchard orhard) {
		int num = 5;
		try {
			for (int i = 0; i < num; i++) {
				Orchard orh = new Orchard();
				TeamLead tLead = new TeamLead();
				CampusMind camp = new CampusMind();
				camp.setmId(10 + i);
				camp.setName("balyans" + i);
				camp.setTrack("EAI");
				camp.setOrchardDetails(orh);

				tLead.setLeadName("Nikhil Balyan" + i);
				tLead.setMid(20 + i);
				tLead.setTrack("EAI");
				tLead.setOrchardDetails(orh);

				Set<TeamLead> tLeadSet = new HashSet<TeamLead>();
				tLeadSet.add(tLead);

				Set<CampusMind> campSet = new HashSet<CampusMind>();
				campSet.add(camp);

				session.save(camp);
				session.save(tLead);
				session.save(orh);

				// UserDetails usr = new UserDetails();
				// usr.setUserName("user " + i);
				// session.save(usr);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		return true;

	}

	public boolean read(int num) {
		try {
			// Query q = session.createQuery("FROM Orchard");
			// List<Orchard> list = q.list();
			// List<Orchard> list = q.getFirstResult();
			// List<Orchard> list = (List<Orchard>) session.createQuery("Select
			// * FROM Orchard");

			Query qry = session.createQuery("FROM Orchard");

			List<Orchard> l = qry.list();
			System.out.println("Total Number Of Records : " + l.size());
			Iterator it = l.iterator();
			// System.out.println("campus minds = "+l.get(0).getCampusMind());

			while (it.hasNext()) {
				Orchard oor = (Orchard) it.next();
				// CampusMind cmd = (CampusMind) oor.getCampusMind();
				// Set<CampusMind> cmd = HashSet<CampusMind>();
				Set<CampusMind> cmd = new HashSet<CampusMind>();
				System.out.println("orchard set size = " + oor.getCampusMind());
				System.out.println("team lead set size = " + oor.getTeamLead());
				cmd = oor.getCampusMind();
				for (CampusMind cmAns : cmd) {
					System.out.println("campus minds name = ");
					System.out.println(cmAns.getName());
				}
				// System.out.println(cmd.getName());

				/*
				 * System.out.println("Product id : "+o[0]+
				 * "Product Name : "+o[1]);
				 * 
				 * System.out.println("----------------");
				 */
			}

			Query qry1 = session.createQuery("FROM TeamLead");
			List<TeamLead> teamLead = qry1.list();
			Iterator itLead = teamLead.iterator();

			while (itLead.hasNext()) {
				TeamLead tL = (TeamLead) itLead.next();
				System.out.println("team lead name = ");
				System.out.println(tL.getLeadName());
			}
			/*
			 * for (Orchard cm : list) {
			 * System.out.println("here is batch id = " + cm.getBatchId());
			 * 
			 * Set<CampusMind> cs = cm.getCampusMind();
			 * 
			 * for (CampusMind cms : cs) { System.out.println("campus minds = "
			 * + cms.getName()); } }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		// List

		/*
		 * Query q = session.createQuery("FROM campusmind");
		 * 
		 * @SuppressWarnings("unchecked") List<CampusMind> list =
		 * (List<CampusMind>) q.list(); // List<CampusMind> list =
		 * q.getResultList(); CampusMind cmp = new CampusMind(); for (CampusMind
		 * it : list) { System.out.println(it.getmId());
		 * System.out.println(it.getName()); System.out.println(it.getTrack());
		 * }
		 */

		// working code for reading teamlead id
		/*
		 * TeamLead tLead = (TeamLead) session.get(TeamLead.class, 1);
		 * CampusMind cMind = (CampusMind) session.get(CampusMind.class, 1);
		 * System.out.println("user name read from db is =========== " +
		 * tLead.getLeadName()); System.out.println("orchard id ======= " + 1);
		 */

		// UserDetails user = (UserDetails) session.get(UserDetails.class,
		// 5);
		// System.out.println("user name read from db is = " +
		// user.getUserName());

		return true;
	}

	public boolean update(int num) {
		try {
			int kk = 3;
			// UserDetails user2 = (UserDetails) session.get(UserDetails.class,
			// kk);
			// user2.setUserName("Updated User hola");
			// session.update(user2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int num) {
		try {
			// UserDetails user1 = (UserDetails) session.get(UserDetails.class,
			// 6);
			// session.delete(user1);
		} catch (Exception e) {
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
			// session.beginTransaction();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
			return false;
		}
		return true;
	}

	public static boolean closeConnection() {
		try {
			// session.getTransaction().commit();
			// txn.commit();
			session.flush();
			session.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public TeamLead getLeadByName(String name) {
		try {
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return new TeamLead();
	}

	public boolean update(Orchard num) {
		// TODO Auto-generated method stub
		return false;
	}

	public CampusMind getCampusMindById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Orchard getOrchardByTrack(String track) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
