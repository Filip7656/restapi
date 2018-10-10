package com.vps.restapi.utils;

import java.io.File;
<<<<<<< HEAD
=======
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
>>>>>>> FilipDev
import java.util.Optional;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
<<<<<<< HEAD
=======
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
>>>>>>> FilipDev

import com.vps.restapi.model.User;

public class EmailSender {
	private static final Logger LOG = LoggerFactory.getLogger(EmailSender.class);

<<<<<<< HEAD
	static String userName = "ducha321@wp.pl";
	static String password = "klucz12";
	static String host = "smtp.gmail.com";
	static int port = 465;
	static String fromAddress = "noreply@service.com";
	static HtmlEmail he = new HtmlEmail();

	public static void newAccountEmail(User user1) throws EmailException {
		// zapytac o exception

		String toAddress = user1.getEmail();
		String subject = "Hello " + user1.getFirstName();
		String message = "Hello " + user1.getFirstName() + " " + user1.getLastName();
		File img = new File("C://Users/filip/Downloads/doors.jpg");

		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		msg.append("<img src=cid:").append(he.embed(img)).append(">");
=======
	static String userName = "fchlebowski@gmail.com";
	static String password = "*****";
	static String host = "smtp.gmail.com";
	static int port = 465;
	static String fromAddress = "noreply@service.com";

	public static void newAccountEmail(User userNew) throws EmailException {
		// zapytac o exception

		String subject = "Hello " + userNew.getFirstName();
		String message = "Hello " + userNew.getFirstName() + " " + userNew.getLastName();

		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
>>>>>>> FilipDev
		msg.append("<br>");
		msg.append(message);
		msg.append("</br>");
		msg.append("</body></html>");

<<<<<<< HEAD
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
=======
		sendEmail(initHtmlEmail(), userNew.getEmail(), subject, msg.toString(), Collections.emptyMap());
>>>>>>> FilipDev

	}

	public static void editAccountEmail(Optional<User> userFromDatabase, User userNew) throws EmailException {
<<<<<<< HEAD
		User userOld = userFromDatabase.get();
		String toAddress = userNew.getEmail();
=======

		User userOld = userFromDatabase.get();
>>>>>>> FilipDev
		String subject = "Hello " + userOld.getFirstName();
		String message = "<h1>Hello " + userOld.getFirstName() + " " + userOld.getLastName()
				+ " your account was edited</h1>";

		String emailChange = "Previus email: " + userOld.getEmail() + "<br> New email: " + userNew.getEmail();
		String firstNameChange = "Previus name: " + userOld.getFirstName() + "<br> New name: " + userNew.getFirstName();
		String lastNameChange = "Previous last name: " + userOld.getLastName() + "<br> New last name: "
				+ userNew.getLastName();
		String passwordChange = "Previous password: " + userOld.getPassword() + "<br> New password: "
				+ userNew.getPassword();

<<<<<<< HEAD
		// File img = new File("C://Users/filip/Downloads/doors.jpg");

		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		// msg.append("<img src=cid:").append(he.embed(img)).append(">");
=======
		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		msg.append("<img src=cid:doors.jpg>");
>>>>>>> FilipDev
		msg.append("<br>");
		msg.append(message);
		msg.append("</br>");
		msg.append("<h3>" + emailChange + "</h3>");
		msg.append("<h3>" + firstNameChange + "</h3>");
		msg.append("<h3>" + lastNameChange + "</h3>");
		msg.append("<h3>" + passwordChange + "</h3>");

		msg.append("</body></html>");

<<<<<<< HEAD
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
=======
		Map<String, File> imagesToEmbed = new HashMap<>();
		File img = new File("C://Users/filip/Downloads/doors.jpg");
		imagesToEmbed.put(img.getName(), img);
		sendEmail(initHtmlEmail(), userNew.getEmail(), subject, msg.toString(), imagesToEmbed);
>>>>>>> FilipDev

	}

	public static void deleteAccountEmail(Optional<User> userFromDatabase, User userNew) throws EmailException {
		User userOld = userFromDatabase.get();
<<<<<<< HEAD
		String toAddress = userNew.getEmail();
=======
>>>>>>> FilipDev
		String subject = "Hello " + userOld.getFirstName();
		String message = "<h1>Hello</h1><br><h1> " + userOld.getFirstName() + " " + userOld.getLastName()
				+ " your account was deleted</h1>";

<<<<<<< HEAD
		// File img = new File("C://Users/filip/Downloads/doors.jpg");

		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		// msg.append("<img src=cid:").append(he.embed(img)).append(">");
=======
		StringBuffer msg = new StringBuffer();
		msg.append("<html><body>");
		msg.append("<img src=cid:doors.jpg>");
>>>>>>> FilipDev
		msg.append("<br>");
		msg.append(message);
		msg.append("</br>");
		msg.append("</body></html>");

<<<<<<< HEAD
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

=======
		Map<String, File> imagesToEmbed = new HashMap<>();
		File img = new File("C://Users/filip/Downloads/doors.jpg");
		imagesToEmbed.put(img.getName(), img);
		sendEmail(initHtmlEmail(), userNew.getEmail(), subject, msg.toString(), imagesToEmbed);
	}

	private static void sendEmail(HtmlEmail htmlEmail, String toAddress, String subject, String message,
			Map<String, File> imagesToEmbed) {
		try {
			htmlEmail.setSubject(subject);
			htmlEmail.setHtmlMsg(message);
			htmlEmail.addTo(toAddress);
			for (Entry<String, File> imagesToEmbedEntry : imagesToEmbed.entrySet()) {
				htmlEmail.embed(imagesToEmbedEntry.getValue(), imagesToEmbedEntry.getKey());
			}
			// java collections/map
			htmlEmail.send();
			LOG.info("email send to :" + toAddress);
		} catch (Exception ex) {
			LOG.error("Unable to send email : " + ex);
		}
	}

	// wyciagnac emaila do pliku, zrobic szablon freemaker dla nazw uzytkownika itp,
	// uzytkownik nie usuwany ale zmiana aktywnosci
	// mail z aktywacja konta
	// metoda w api ktora przyjmie token zweryfikuje, czy ma uzytkownik go
	// przypisanego i jezeli tak to najs

	private static HtmlEmail initHtmlEmail() throws EmailException {
		HtmlEmail he = new HtmlEmail();
		he.setHostName(host);
		he.setSmtpPort(port);
		he.setAuthentication(userName, password);
		he.setSSLOnConnect(true);
		he.setFrom(fromAddress);
		return he;
	}
	// linijka do redirectu

	private static ResponseEntity<Void> reDiretct() {

		// get action destination view identity
		String redirectUrl = accountService.resolveActionDestination(requestId, "postUserAccountConfirmation");
		// prepare and return redirect
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", redirectUrl);
		return new ResponseEntity<Void>(headers, HttpStatus.SEE_OTHER);
	}
>>>>>>> FilipDev
}
