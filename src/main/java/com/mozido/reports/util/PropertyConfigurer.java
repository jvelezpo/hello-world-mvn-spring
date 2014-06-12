package com.mozido.reports.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 
 * @author Sebastian
 *
 */
@Configuration
public class PropertyConfigurer {

	public final static String THEURL = "theurl"; 
	public final static String SECOND = "second";
	
	@Autowired
	private Environment env;
	
	public String getProperty(String key){
		return env.getProperty(key);
	}
}
