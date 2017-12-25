package com.soap.jaxws.beans;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = -557757908111070434L;
	private String name;
	private int age;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
