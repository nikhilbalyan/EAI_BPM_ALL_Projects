package com.soap.jaxws.service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.soap.jaxws.beans.Person;
@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface PersonService {
	public boolean addPerson(Person p);

	public boolean deletePerson(int id);

	public Person getPerson(int id);

	public Person[] getAllPersons();
}
