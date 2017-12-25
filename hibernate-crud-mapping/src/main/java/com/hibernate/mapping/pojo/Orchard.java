package com.hibernate.mapping.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orchard")
public class Orchard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int batchId;

	@OneToMany(/*fetch = FetchType.LAZY,*/ mappedBy = "orchardDetails"/*, cascade = CascadeType.ALL*/)
	private Set<CampusMind> campusMind = new HashSet<CampusMind>();

	@OneToMany(/*fetch = FetchType.LAZY,*/ mappedBy = "orchardDetails"/*, cascade = CascadeType.ALL*/)
	private Set<TeamLead> teamLead = new HashSet<TeamLead>();

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Set<CampusMind> getCampusMind() {
		return campusMind;
	}

	public void setCampusMind(Set<CampusMind> campusMind) {
		this.campusMind = campusMind;
	}

	public Set<TeamLead> getTeamLead() {
		return teamLead;
	}

	public void setTeamLead(Set<TeamLead> teamLead) {
		this.teamLead = teamLead;
	}

	@Override
	public String toString() {
		return this.batchId +" batchId " + " campusMind " + campusMind.toString() + " teamLead "
					+ teamLead.toString();
	}
}
