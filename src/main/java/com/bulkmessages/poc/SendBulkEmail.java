package com.bulkmessages.poc;

//File Name SendBulkSms.java

import java.util.*;
import java.io.*;
import java.net.InetAddress;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendBulkEmail {

	public static void main(String[] argv) {
		SendBulkEmail sendBulkEmail = new SendBulkEmail();
		System.out.println("Provide UserName");
		Scanner scanner = new Scanner(System.in);
		String userName = scanner.nextLine();
		System.out.println("Provide Password");
		String password = scanner.nextLine();
		sendBulkEmail.sendEmail(userName, password);
	}

	public boolean sendEmail(final String userName, final String password)
	{    
		boolean isSent = false;
		
		// Recipient's email ID needs to be mentioned.
		String to = "receipient@gmail.com";

		// Sender's email ID needs to be mentioned
		String from = "sender@gmail.com";

		// Using gmail smtp gateway for sending emails
		String host = "smtp.gmail.com";
		String port = "587";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", port);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		//System.out.println("Auth Done!");
		Session session = Session.getInstance(properties, auth);

		try{
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Subject Line!");

			// Now set the actual message
			message.setText("Here is the actual message");

			// Send message
			Transport.send(message);
			isSent = true;
			System.out.println("Message sent successfully....");
		}catch (MessagingException ex) {
			ex.printStackTrace();
		} finally {
			return isSent;
		}
	}
}

