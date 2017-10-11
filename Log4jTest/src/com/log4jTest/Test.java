package com.log4jTest;

import java.util.logging.Logger;

public class Test {
	
	final static Logger logger = Logger.getLogger("Test");
	
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			logger.info("Information "+i);
		}
		//logger.warning("Hello logger");
		//logger.info("Logger info");
		logger.warning("Logger waring ");

		
	}
}
