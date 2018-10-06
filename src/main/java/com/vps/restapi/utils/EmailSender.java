package com.vps.restapi.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vps.restapi.Api;
import com.vps.restapi.model.User;

public class EmailSender {
	private static final Logger LOG = LoggerFactory.getLogger(Api.class);

	public static void sendSimpleEmail(User user1) {

		String userName = "fchlebowski@gmail.com";
		String password = "*********";
		String host = "smtp.gmail.com";
		int port = 465;
		String fromAddress = "noreply@service.com";
		String toAddress = user1.getEmail();
		String subject = "Hello " + user1.getFirstName();
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
			LOG.info("email send to :" + user1.getEmail());
			email.addTo(toAddress);
			email.send();
		} catch (Exception ex) {
			System.out.println("Unable to send email");
			System.out.println(ex);
		}
	}
}
