package com.vps.restapi.model;

public class ConfigurationFreemarker {
	// Create your Configuration instance, and specify if up to what FreeMarker
	// // version (here 2.3.27) do you want to apply the fixes that are not 100%
	// // // backward-compatible. See the Configuration JavaDoc for details.
	// Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
	// // cfg.setDirectoryForTemplateLoading(new
	// File("/restapi/src/main/resources"));
	// // // Set the preferred charset template files are stored in. UTF-8 is
	// // // a good choice in most applications:
	// cfg.setDefaultEncoding("UTF-8");
	// // // Sets how errors will appear.
	// // // During web page *development*
	// TemplateExceptionHandler.HTML_DEBUG_HANDLER
	// // is better.
	// cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	// //
	// // // Don't log exceptions inside FreeMarker that it will thrown at you
	// anyway:
	// cfg.setLogTemplateExceptions(false);
	// //
	// // // Wrap unchecked exceptions thrown during template processing into
	// // TemplateException-s.
	// cfg.setWrapUncheckedExceptions(true);
	// //
	//
	// // Later, whenever the application needs a template (so you may do this a
	// lot,
	// // and from multiple threads):
	// Template myTemplate = cfg.getTemplate("EmailTemplate.ftl");
}
