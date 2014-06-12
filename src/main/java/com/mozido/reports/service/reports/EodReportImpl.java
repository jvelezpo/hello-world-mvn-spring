package com.mozido.reports.service.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.service.signon.SignOnServices;
import com.mozido.reports.util.PropertyGetter;

@Service
public class EodReportImpl implements EodReport{

	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	SignOnServices signOnServices;
	
	public String testing(String user, String pass) {
		String url = propertyGetter.getProperty(PropertyGetter.SECURITY_ELEMENT_TYPE_KEY);
		url += "?signon=" + signOnServices.signIn(user, pass);
		return url + "&random=" + String.valueOf(Math.random());
	}
}
