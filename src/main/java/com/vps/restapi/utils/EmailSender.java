package com.vps.restapi.utils;

import java.io.File;
import java.util.Optional;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vps.restapi.Api;
import com.vps.restapi.model.User;

public class EmailSender {
	private static final Logger LOG = LoggerFactory.getLogger(Api.class);

	public static void newAccountEmail(User user1) throws EmailException {
		// zapytac o exception
		String userName = "fchlebowski@gmail.com";
		String password = "*********";
		String host = "smtp.gmail.com";
		int port = 465;
		String fromAddress = "noreply@service.com";
		String toAddress = user1.getEmail();
		String subject = "Hello " + user1.getFirstName();
		String message = "Hello " + user1.getFirstName() + " " + user1.getLastName();

		HtmlEmail he = new HtmlEmail();
		File img = new File("C://Users/filip/Downloads/doors.jpg");

		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		msg.append("<img src=cid:").append(he.embed(img)).append(">");
		msg.append("<br>");
		msg.append(message);
		msg.append("</br>");
		msg.append("</body></html>");

		try {
			he.setHostName(host);
			he.setSmtpPort(port);
			he.setAuthentication(userName, password);
			he.setSSLOnConnect(true);
			he.setFrom(fromAddress);
			he.setSubject(subject);
			he.setHtmlMsg(msg.toString());
			he.addTo(toAddress);
			he.send();
			LOG.info("email send to :" + user1.getEmail());
		} catch (Exception ex) {
			LOG.error("Unable to send email : " + ex);
		}

	}

	public static void editAccountEmail(Optional<User> userFromDatabase, User userNew) throws EmailException {
		User userOld = userFromDatabase.get();

		String userName = "fchlebowski@gmail.com";
		String password = "*********";
		String host = "smtp.gmail.com";
		String toAddress = userOld.getEmail();
		int port = 465;
		String fromAddress = "noreply@service.com";
		String subject = "Hello " + userOld.getFirstName();
		String message = "<h1>Hello " + userOld.getFirstName() + " " + userOld.getLastName()
				+ " your account was edited</h1>";

		String emailChange = "Previus email: " + userOld.getEmail() + "<br> New email: " + userNew.getEmail();
		String firstNameChange = "Previus name: " + userOld.getFirstName() + "<br> New name: " + userNew.getFirstName();
		String lastNameChange = "Previous last name: " + userOld.getLastName() + "<br> New last name: "
				+ userNew.getLastName();
		String passwordChange = "Previous password: " + userOld.getPassword() + "<br> New password: "
				+ userNew.getPassword();

		HtmlEmail he = new HtmlEmail();
		// File img = new File("C://Users/filip/Downloads/doors.jpg");

		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		// msg.append("<img src=cid:").append(he.embed(img)).append(">");
		msg.append("<br>");
		msg.append(message);
		msg.append("</br>");
		msg.append("<h3>" + emailChange + "</h3>");
		msg.append("<h3>" + firstNameChange + "</h3>");
		msg.append("<h3>" + lastNameChange + "</h3>");
		msg.append("<h3>" + passwordChange + "</h3>");

		msg.append("</body></html>");

		try {
			he.setHostName(host);
			he.setSmtpPort(port);
			he.setAuthentication(userName, password);
			he.setSSLOnConnect(true);
			he.setFrom(fromAddress);
			he.setSubject(subject);
			he.setHtmlMsg(msg.toString());
			he.addTo(toAddress);
			he.send();
			LOG.info("email send to :" + userOld.getEmail());
		} catch (Exception ex) {
			LOG.error("Unable to send email : " + ex);
		}

	}

}
