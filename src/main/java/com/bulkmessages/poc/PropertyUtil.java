package com.bulkmessages.poc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyUtil {
	
	private static final Logger LOGGER = Logger.getLogger(PropertyUtil.class.getName());
	
	public static Properties getProperties() {
		Properties prop = new Properties();
		String propFileName = "config.properties";
		
		InputStream inputStream = Properties.class.getResourceAsStream(propFileName);
		
		if(inputStream != null) {
			try {
				prop.load(inputStream);
			} catch (IOException e) {
				LOGGER.log(Level.WARNING, "Unable to load config properties");
				e.printStackTrace();
			}
		}
		return prop;
	}
}
