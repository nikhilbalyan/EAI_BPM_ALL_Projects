package com.spring.hibernate.mapping;

import java.util.Scanner;

import com.hibernate.mapping.pojo.Orchard;
import com.hibernate.mapping.pojo.TeamLead;

public class SpringHibernateMain {

	public static void main(String[] args) {
		UserDAOImpl userDao = new UserDAOImpl();
		/*
		 * userDao.startConnection(); userDao.add(5); userDao.read(5);
		 * userDao.closeConnection();
		 */

		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		int batch_id;
		String name;
		TeamLead teamLead = new TeamLead();
		
		
		System.out.println("enter -1 to exit");
		System.out.println("enter 1 for creation");
		System.out.println("enter 2 for reading");
		System.out.println("enter 3 for updation");
		System.out.println("enter 4 for deletion");
		System.out.println("enter 5 for getting lead by name");
		System.out.println("enter 6 for getting campus mind by id");
		System.out.println("enter 7 for getting orchard by track");
		int num = sc.nextInt();
		if(num == -1) {
			flag = false;
		}
		while (flag) {
			
			switch (num) {
			case 1:
				UserDAOImpl.startConnection();
				Orchard orchard = new Orchard();
				System.out.println("enter batch id");
				batch_id = sc.nextInt();
				System.out.println("enter name");
				name = sc.next();
				System.out.println("enter Team Lead Name");
				teamLead.setLeadName(sc.next());
				System.out.println("enter lead mid");
				teamLead.setMid(sc.nextInt());
				System.out.println("enter track");
				teamLead.setTrack(sc.next());
				
				
				
				userDao.add(orchard); 
//				userDao.read(5);
				UserDAOImpl.closeConnection();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			default:
				System.out.println("you entered wrong choice");
				break;
			}
			
			System.out.println("enter -1 to exit");
			num = sc.nextInt();
			if(num == -1) {
				break;
			}
		}
		
		sc.close();

	}
}
