package com.vps.restapi.model;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

@Service
public class CustomConfigurationFreemarker {
	@Autowired
	Configuration cfg;

	@PostConstruct
	public void init() {
		try {
			cfg.setDirectoryForTemplateLoading(new File("/resources"));
			cfg.setDefaultEncoding("UTF-8");
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			cfg.setLogTemplateExceptions(true);
			cfg.setWrapUncheckedExceptions(true);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void templateSet(User userToSend) throws Exception {

		Map<String, String> root = new HashMap<String, String>();
		root.put("user", userToSend.getFirstName());
		root.put("lastName", userToSend.getLastName());
		root.put("password", userToSend.getPassword());
		root.put("email", userToSend.getEmail());

		Template myTemplate = cfg.getTemplate("EmailTemplate.ftl");
		Writer out = new OutputStreamWriter(System.out);
		myTemplate.process(root, out);

	}
}