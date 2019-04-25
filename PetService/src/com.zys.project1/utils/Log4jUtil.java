package com.zys.project1.utils;

import org.apache.log4j.Logger;

public class Log4jUtil {

	static Logger logger;
	
	public static Logger getInstance(String clazzName){
		return Logger.getLogger(clazzName);
	}
	
}
