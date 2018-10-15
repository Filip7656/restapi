package com.vps.restapi.model;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class ConfigurationFreemarker {
	@Autowired
	static Configuration cfg;

	public static void templateSet(User userToSend) throws Exception {
		cfg.setDirectoryForTemplateLoading(new File("/resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(false);
		cfg.setWrapUncheckedExceptions(true);

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
