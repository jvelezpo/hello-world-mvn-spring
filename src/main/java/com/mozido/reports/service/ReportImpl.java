package com.mozido.reports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.util.PropertyConfigurer;

/**
 * 
 * @author Sebastian
 *
 */
@Service
public class ReportImpl implements Report{

	@Autowired
	PropertyConfigurer proConf;
	
	public String returnAToken() {
		String url = proConf.getProperty(PropertyConfigurer.THEURL);
		return url + "?" + String.valueOf(Math.random());
	}

}
