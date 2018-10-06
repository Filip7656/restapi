package com.vps.restapi.utils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailHandler implements EmailInterface {
	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String mail, String firstName, String lastName) {
		// TODO Auto-generated method stub
		MimeMessage mail1 = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mail1, true);
			helper.setTo(mail);
			helper.setReplyTo("newsletter@codecouple.pl");
			helper.setFrom("newsletter@codecouple.pl");
			helper.setSubject("Test");
			helper.setText(firstName + lastName, true);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		javaMailSender.send(mail1);
	}

}
