package com.spring.hibernate.mapping;

import com.hibernate.mapping.pojo.CampusMind;
import com.hibernate.mapping.pojo.Orchard;
import com.hibernate.mapping.pojo.TeamLead;

public interface UserDaoInterface {
	public boolean add(Orchard data);

	public boolean read(int batchId);

	public boolean update(Orchard num);

	public boolean delete(int batchId);
	
	public TeamLead getLeadByName(String name);
	
	public CampusMind getCampusMindById(int id);
	
	public Orchard getOrchardByTrack(String track);
	
}
