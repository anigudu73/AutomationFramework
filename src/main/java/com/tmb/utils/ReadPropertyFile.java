package com.tmb.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.tmb.constants.FrameworkConstants;

public final class ReadPropertyFile {

	private ReadPropertyFile()
	{

	}
	private static Properties property = new Properties();

	static {
		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigfilepath());
			property.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}

	}
	public static String readProperty(String key) throws Exception
	{


		if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key))
		{
			throw new Exception("Property named "+key+"is not found. Please check config file");
		}
		return property.getProperty(key).trim();
	}

}
