package com.ecom.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Load properties
 * 
 * @author prashant.sahu
 *
 */
public class PropertyUtil {

	private final static Logger logger = Logger.getLogger(PropertyUtil.class);

	public static Properties loadProperties(String fileName) {

		Properties props = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try (InputStream resourceStream = loader.getResourceAsStream(fileName)) {
			props.load(resourceStream);
		} catch (IOException e) {
			logger.error("Unable to load properties file", e);
		}

		return props;
	}
}
