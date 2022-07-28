package com.vikasbank.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	//ReadConfig file is used to store the common data which is needed for the
	//project multiple times
	Properties pro;
	//creating properties object for reading .properties file
	public ReadConfig() {
		//loading file in into FIS
		//Available at runtime when the object of ReadConfig is created
		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch(Exception e)
		{
			System.out.println("Exception is:"+e);
		}
	}

	//need to writing method for each value defined the properties file
	//pro object provides to read and retrieve value from properties file
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String uname=pro.getProperty("username");
		return uname;
	}
	public String getPassword()
	{
		String pass=pro.getProperty("password");
		return pass;
	}
	public String getChromepath()
	{
		String cpath=pro.getProperty("chromepath");
		return cpath;
	}
	public String getIEpath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;
	}

}
