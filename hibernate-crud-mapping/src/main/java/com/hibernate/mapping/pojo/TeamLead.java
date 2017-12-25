package com.hibernate.mapping.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teamlead")
public class TeamLead {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mid;
	private String leadName;
	private String track;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "batchId")
	private Orchard orchardDetails;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getLeadName() {
		return leadName;
	}

	public void setLeadName(String leadName) {
		this.leadName = leadName;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	public Orchard getOrchardDetails() {
		return orchardDetails;
	}

	public void setOrchardDetails(Orchard orchardDetails) {
		this.orchardDetails = orchardDetails;
	}

	@Override
	public String toString() {
		return "1. mid = " + mid + "2. leadName = " + leadName + "3. track = " +
				"4. orchardDetails "+ orchardDetails.toString();
	}
	
	

}
