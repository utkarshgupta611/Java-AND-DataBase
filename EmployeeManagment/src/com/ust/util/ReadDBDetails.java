package com.ust.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDBDetails {
	private String configFile="db.config";

	public ReadDBDetails(String configFile) {
		super();
		this.configFile = configFile;
	}

public Properties getData() {
	Properties props = new Properties();
	
	try {
		props.load(new FileInputStream(configFile));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return props;
	
}
	
}
