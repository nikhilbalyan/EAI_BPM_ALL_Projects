package com.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.pojo.FourWheeler;
import com.hibernate.pojo.TwoWheeler;
import com.hibernate.pojo.Vehicle;

public class InheritanceMain {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("car");
		
		TwoWheeler twoWheeler = new TwoWheeler();
		twoWheeler.setSteeringHandle("bike steering handle");
		twoWheeler.setVehicleName("bike");
		
		
		FourWheeler fourWheeler = new FourWheeler();
		fourWheeler.setSteeringWheel("car steering wheel");
		fourWheeler.setVehicleName("Porsche Steering wheel");
		
		
		// starting hibernate session\
		String hibernateFilePath = "hibernate.cfg.xml";
		SessionFactory sessionFactory = new Configuration().configure(hibernateFilePath).buildSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(vehicle);
			session.save(twoWheeler);
			session.save(fourWheeler);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
