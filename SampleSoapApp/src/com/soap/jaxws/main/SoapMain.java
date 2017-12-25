package com.soap.jaxws.main;

import javax.xml.ws.Endpoint;

import com.soap.jaxws.service.PersonServiceImpl;

public class SoapMain {
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8011/ws/person", new PersonServiceImpl());
	}
}
