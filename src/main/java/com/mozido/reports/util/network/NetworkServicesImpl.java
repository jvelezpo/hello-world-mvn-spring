package com.mozido.reports.util.network;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.util.PropertyGetter;
//import com.sun.xml.ws.developer.JAXWSProperties;

@Service
public class NetworkServicesImpl implements NetworkServices{

	@Autowired
	PropertyGetter proConf;
	
	private String host;
//	private int timeout;
	
	@PostConstruct
	public void initIt() throws Exception {
		host = proConf.getProperty(PropertyGetter.MOTEAF_HOST_AND_PORT);
//		timeout = Integer.parseInt(proConf.getProperty(PropertyGetter.REQUEST_TIMEOUT_IN_MILLIS));
	}
	
	public void initSoapService(BindingProvider bindingProvider, String endPointAddress) {
		Map<String, Object> requestContext = ((BindingProvider) bindingProvider).getRequestContext();
//		requestContext.put(JAXWSProperties.CONNECT_TIMEOUT, timeout);
//		requestContext.put(JAXWSProperties.REQUEST_TIMEOUT, timeout);
		requestContext.put("javax.xml.ws.service.endpoint.address", host + "/services/" + endPointAddress);
	}

}
