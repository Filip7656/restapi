package com.vps.restapi.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import com.vps.restapi.model.User;

public class EmailSender {
	@SuppressWarnings("unused")
	private static void sendSimpleEmail(User user1) {

		String userName = "fchlebowski@gmail.com";
		String password = "*****";
		String host = "smtp.googlemail.com";
		int port = 465;
		String fromAddress = "username@gmail.com";
		String toAddress = user1.getEmail();
		String subject = "Test Mail";
		String message = "Hello " + user1.getFirstName() + " " + user1.getLastName();

		try {
			Email email = new SimpleEmail();
			email.setHostName(host);
			email.setSmtpPort(port);
			email.setAuthenticator(new DefaultAuthenticator(userName, password));
			email.setSSLOnConnect(true);
			email.setFrom(fromAddress);
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(toAddress);
			email.send();
		} catch (Exception ex) {
			System.out.println("Unable to send email");
			System.out.println(ex);
		}
	}
}
