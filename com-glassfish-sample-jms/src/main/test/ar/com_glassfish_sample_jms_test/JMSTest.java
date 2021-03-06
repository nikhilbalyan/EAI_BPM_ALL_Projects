package ar.com_glassfish_sample_jms_test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.com_glassfish_sample_jms.async.AsyncReceiver;
import ar.com_glassfish_sample_jms.async.Sender;
import junit.framework.Assert;

public class JMSTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void out() throws Exception {
//		System.out.print("hello");
//		assertEquals("hello", outContent.toString();
		Sender sender = new Sender();
//		AsyncReceiver rec = new AsyncReceiver();
//		try {
//			sender.sendMessage();
//		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		assertEquals("sent: Hello", sender.sendMessage());
		
		/*rec.main(null);
		assertEqu*/
	}
	
	@Test
	public void receiverTest() throws Exception {
		Sender sender = new Sender();
		sender.sendMessage();
		AsyncReceiver rcv =  new AsyncReceiver();
//		assertEquals("received: Hello", rcv.onMessage("");;
		
	}
	
	
	@Test
	public void senderAndReceiverMessageTest() throws Exception {
		Sender sender = new Sender();
		AsyncReceiver rcv = new AsyncReceiver();
		Assert.assertEquals(sender.senderMessage, rcv.receiverMessage);
		
	}

	@After
	public void cleanUpStreams() {
		System.setOut(null);
		System.setErr(null);
	}

}
