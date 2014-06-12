package com.mozido.reports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.api.core.sharedcontext.ContextRequest;
import com.mozido.api.core.signon.SignonRequest;
import com.mozido.api.core.signon.SignonResponse;
import com.mozido.reports.service.signon.SignOnServices;
import com.mozido.reports.util.PropertyGetter;

/**
 * 
 * @author Sebastian
 *
 */
@Service
public class ReportImpl implements Report{

	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	SignOnServices signOnServices;
	
	public String returnAToken() {
		String url = propertyGetter.getProperty(PropertyGetter.SECURITY_ELEMENT_TYPE_KEY);
		url += "?signon=" + signOnServices.signIn("gbolanos","1234");
		return url + "&random=" + String.valueOf(Math.random());
	}

	
}
