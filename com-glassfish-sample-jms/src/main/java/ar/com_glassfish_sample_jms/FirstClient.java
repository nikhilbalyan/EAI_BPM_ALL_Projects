package ar.com_glassfish_sample_jms;

import java.util.Properties;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.jms.JMSException;
import javax.jms.Destination;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

public class FirstClient {
	Context context = null;
	ConnectionFactory factory = null;
	Connection connection = null;
	Destination destination = null;
	Session session = null;
	MessageProducer producer = null;
	
	public FirstClient() {

	}

	public void sendMessage() {
	Properties initialProperties = new Properties();
	initialProperties.put(InitialContext.INITIAL_CONTEXT_FACTORY,
	"org.exolab.jms.jndi.InitialContextFactory");
	initialProperties.put(InitialContext.PROVIDER_URL,
	"http://localhost:8161/");

	try {

	context = new InitialContext(initialProperties);
	factory = (ConnectionFactory) context.lookup("ConnectionFactory");
	destination = (Destination) context.lookup("queue1");
	connection = factory.createConnection();
	session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	producer = session.createProducer(destination);
	connection.start();
	TextMessage message = session.createTextMessage();
	message.setText("Hello ...This is a sample message..sending from FirstClient");
	producer.send(message);
	System.out.println("Sent: " + message.getText());

	} catch (JMSException ex) {
	ex.printStackTrace();
	} catch (NamingException ex) {
	ex.printStackTrace();
	}

	if (context != null) {
	try {
	context.close();
	} catch (NamingException ex) {
	ex.printStackTrace();
	}
	}

	if (connection != null) {
	try {
	connection.close();
	} catch (JMSException ex) {
	ex.printStackTrace();
	}
	}
	}

	public static void main(String[] args) {
	FirstClient firstClient = new FirstClient();
	firstClient.sendMessage();
	}

}
