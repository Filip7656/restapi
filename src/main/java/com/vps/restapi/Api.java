package com.vps.restapi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//mapowanie rest
@RestController
@RequestMapping("/json")
public class Api {
	public static String data;
	public static String data_log;
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	private MongoTemplate mongoTemplate;

	@RequestMapping(method = { RequestMethod.POST })
	@CrossOrigin(origins = "http://145.239.87.1:4200")
	public String create(@RequestBody String json_data) {
		data = json_data;

		// wysłanie json do mongo
		Document doc = Document.parse(data);
		mongoTemplate.insert(doc, "dane");

		File json = new File("/ang-form/src/data/log.json");

		/*
		 * skomplikowany system tworzenia formatu pliku json tak aby czytała to tabelka
		 * zwrotna
		 */
		try {
			FileWriter fileWriter = new FileWriter(json, true);
			FileReader filereader = new FileReader(json);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			BufferedReader br = new BufferedReader(filereader);
			data_log = br.readLine();
			log.debug(data_log);
			br.close();

			if (json.exists()) {
				PrintWriter albo = new PrintWriter(json);
				albo.close();
			}

			if (!json.exists()) {
				log.debug("making a new file");
				json.createNewFile();
			}

			if (json.length() == 0 && data_log == null) {
				log.debug("Saving json to proper format");
				bufferedWriter.write('{');
				bufferedWriter.write('"');
				bufferedWriter.write("json_data");
				bufferedWriter.write('"');
				bufferedWriter.write(":[");
				bufferedWriter.write(data);
				bufferedWriter.write("]}");
				bufferedWriter.close();
			} else
				log.debug("file not empty");
			if (data_log == null) {
				bufferedWriter.write(data);
			} else {
				bufferedWriter.write(data_log.replace("]}", ""));
				bufferedWriter.write("," + data);
			}
			bufferedWriter.write("]}");
			bufferedWriter.close();
			log.info("Done");
		} catch (IOException e) {
			log.error("error while making and writing to file");
		}

		return null;

	}

	// mapowanie resta
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getAll() {
		return data;
	}

}
