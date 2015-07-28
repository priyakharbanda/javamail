package com.ecom.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class SendMail {

	private final static Logger logger = Logger.getLogger(SendMail.class);

	public boolean sendMessage(String subject, String body,
			Address[] toAddresses) {

		logger.info("Start of sendMessage");
		Properties props = getProperties();
		String username = props.getProperty("mail.username");

		// Create session
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, props
								.getProperty("mail.password"));
					}
				});

		try {

			// form message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, toAddresses);
			message.setSubject(subject);
			message.setText(body);

			// send message
			Transport.send(message);

			logger.info("message sent successfully");

		} catch (MessagingException e) {
			logger.error("Error occured while sending message", e);
			throw new RuntimeException(e);
		}

		logger.info("End of sendMessage");

		return true;

	}

	private Properties getProperties() {

		Properties props = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream resourceStream = loader
				.getResourceAsStream("config.properties")) {
			props.load(resourceStream);
		} catch (IOException e) {
			logger.error("Unable to load properties file", e);
		}

		return props;
	}

}
