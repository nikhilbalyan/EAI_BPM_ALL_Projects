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
@Table(name = "campusmind")
public class CampusMind {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mId;
	private String name;
	private String track;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "batchId")
	private Orchard orchardDetails;

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "CampusMind [mId=" + mId + ", name=" + name + ", track=" + track + ", orchardDetails=" + orchardDetails
				+ "]";
	}
	
	

}
