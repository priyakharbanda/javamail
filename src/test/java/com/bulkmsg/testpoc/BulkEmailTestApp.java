package com.bulkmsg.testpoc;

import static org.junit.Assert.*;

import javax.mail.Address;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.junit.*;

import com.bulkmessages.poc.SendBulkEmail;

public class BulkEmailTestApp {
	private SendBulkEmail sendBulkEmail;

	@Before
	public void init() {
		sendBulkEmail = new SendBulkEmail();
	}
	
	@Test
	public void testSendMsg() throws AddressException {
		Address[] toAddress = { new InternetAddress(
				"er.priya.k@gmail.com") };
		//Positive test case
		boolean isMsgSent = sendBulkEmail.sendEmails(toAddress, "This is the subject line!", "The actual body of the email goes here.");
		assertEquals(isMsgSent, true);
		
	}
	
	@Test
	public void testBulkSendMsg() throws AddressException {
		Address[] toAddresses = { new InternetAddress("er.priya.k@gmail.com"),new InternetAddress("priya.kharbanda6@gmail.com"),new InternetAddress("priya.kharbanda@globallogic.com")};
		boolean isMsgSent = sendBulkEmail.sendEmails(toAddresses, "This is the subject line!", "The actual body of the email goes here.");
		assertEquals(isMsgSent, true);
		
	}
	
	@Test
	public void testSendMsgFail() throws AddressException {
		Address[] toAddress = { new InternetAddress(
				"xyz@gmail.com") };
		//Positive test case
		boolean isMsgSent = sendBulkEmail.sendEmails(toAddress, "This is the subject line!", "The actual body of the email goes here.");
		assertEquals(isMsgSent, false);
	}

}