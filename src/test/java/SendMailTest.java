package com.ecom.mail;

import static org.junit.Assert.assertTrue;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import org.junit.Test;

public class SendMailTest {

	@Test
	public void testSendMail() throws MessagingException {
		SendMail classUnderTest = new SendMail();
		Address[] toAddresses = { new InternetAddress("prashantsahu034@gmail.com")};
		assertTrue(classUnderTest.sendMessage("sahuprashanta@gmail.com", "xxxxxxxx",toAddresses));
	}
}
