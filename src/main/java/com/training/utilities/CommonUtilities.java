package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CommonUtilities {
	// write a method to get property
	public String getProperty(String key) throws IOException {
		String path = "/Users/chinmayimahishi/eclipse-ws/TestNGFramework/Properties/application.properties";

		FileInputStream fileinput = new FileInputStream(path);

		Properties property = new Properties();

		property.load(fileinput);

		String value = property.getProperty(key);

		return value;
	}
	

}
