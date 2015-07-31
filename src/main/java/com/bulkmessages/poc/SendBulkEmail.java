package com.bulkmessages.poc;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendBulkEmail {

	private static final Logger LOGGER = Logger.getLogger(SendBulkEmail.class.getName());

	public boolean sendEmails(Address recAddress[], String subject, String emailBody)
	{    	
		boolean isSent = true;
		//Load Configurations from Property file
		Properties properties = PropertyUtil.getProperties();
		final String userName = properties.getProperty("username");
		final String password = properties.getProperty("password");


		Authenticator auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		};

		//Create Session
		Session session = Session.getInstance(properties, auth);

		try{
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(properties.getProperty("sender.address")));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO,recAddress);

			// Set Subject: header field
			message.setSubject(subject);

			// Now set the actual message
			message.setText(emailBody);

			// Send message
			Transport.send(message);
			LOGGER.log(Level.INFO, "Message sent successfully....");
		} catch (MessagingException ex) {
			isSent = false;
			LOGGER.log(Level.SEVERE, "Error while sending message: "+ex);
			ex.printStackTrace();
		} 
		return isSent;
	}
}
