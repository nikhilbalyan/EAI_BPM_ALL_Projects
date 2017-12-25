package ar.com_glassfish_sample_jms.async;

import java.util.Properties;
import java.util.Scanner;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Sender {

	public static String senderMessage;
	
	public String sendMessage() throws NamingException, JMSException {
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
		env.put(Context.PROVIDER_URL, "tcp://localhost:61616");
		env.put("queue.queueSampleQueue", "MyNewQueue");

		// get the initial context
		InitialContext ctx = new InitialContext(env);

		// lookup the queue object
		Queue queue = (Queue) ctx.lookup("queueSampleQueue");
		// lookup the queue connection factory
		QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.lookup("QueueConnectionFactory");
		// create a queue connection
		QueueConnection queueConn = connFactory.createQueueConnection();

		// create a queue session
		QueueSession queueSession = queueConn.createQueueSession(false, Session.DUPS_OK_ACKNOWLEDGE);

		// create a queue sender
		QueueSender queueSender = queueSession.createSender(queue);
		queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		// create a simple message to say "Hello"
		System.out.println("enter message u wanna send to reciever");
		Scanner sc = new Scanner(System.in);
		String hello = sc.next();
		TextMessage message = queueSession.createTextMessage(hello);

		// send the message
		queueSender.send(message);
		senderMessage = message.getText();
		String res = "sent: " + message.getText();

		queueConn.close();
		return res;
	}

	public static void main(String[] args) throws Exception {
		Sender sender = new Sender();
		System.out.println(sender.sendMessage());
	}
}