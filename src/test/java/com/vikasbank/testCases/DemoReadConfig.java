package com.vikasbank.testCases;

import com.vikasbank.utilities.ReadConfig;

public class DemoReadConfig {

	public static void main(String[] args) {
		
		ReadConfig rc = new ReadConfig();
		String url=rc.getApplicationURL();
		System.out.println(url);

	}

}
