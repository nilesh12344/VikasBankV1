package demo;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jDemo {

	public static Logger logger;
	
	public static void main(String[] args) {
		logger = Logger.getLogger("Ebanking");
		PropertyConfigurator.configure("log4j.properties");
		System.out.println("This is logger method");
		logger.info("url is opened");
		logger.info("Enter password");
		logger.error("failed");
		logger.warn("this is warning");
	}

}
