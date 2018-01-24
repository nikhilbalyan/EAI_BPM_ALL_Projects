package com.hibernate.pojo;

import javax.persistence.Entity;


// discriminator need only for singletable mapping
//@DiscriminatorValue("bike")\

@Entity
public class TwoWheeler extends Vehicle {
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}

}
