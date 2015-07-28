package com.bulkmsg.testpoc;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.*;

public class BulkEmailTestApp {
	String userName = null;
	String password = null;
	
	@Before
	public void init() {
		SendBulkEmail sendBulkEmail = new SendBulkEmail();
		System.out.println("Provide UserName");
		Scanner scanner = new Scanner(System.in);
		userName = scanner.nextLine();
		System.out.println("Provide Password");
		password = scanner.nextLine();
	}
	
	@Test
	public void testSum() {
		sendBulkEmail.sendEmail(userName, password);
		assert()
	}

}