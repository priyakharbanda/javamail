package com.bulkmsg.testpoc;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.*;

public class BulkEmailTestApp {
	String userName;
	String password;
	boolean isSent;
	
	@Before
	public void init() {
		isSent = true;
		SendBulkEmail sendBulkEmail = new SendBulkEmail();
		System.out.println("Provide UserName");
		Scanner scanner = new Scanner(System.in);
		userName = scanner.nextLine();
		System.out.println("Provide Password");
		password = scanner.nextLine();
	}
	
	@Test
	public void testSum() {
		boolean isMsgSent = sendBulkEmail.sendEmail(userName, password);
		assertEquals(isMsgSent, isSent);
	}

}