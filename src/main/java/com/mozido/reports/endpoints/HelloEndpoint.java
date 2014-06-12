package com.mozido.reports.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.examples.generated.helloitems.HelloRequest;
import com.mozido.examples.generated.helloitems.HelloResponse;
import com.mozido.reports.service.Report;

/**
 * 
 * @author Sebastian
 *
 */
@Endpoint
public class HelloEndpoint {
	
	@Autowired
	Report report;

	@PayloadRoot(localPart = "helloRequest", namespace = "http://localhost:8080/surround_reports/hello")
	@ResponsePayload
	public HelloResponse handleRequest(@RequestPayload HelloRequest request)
			throws Exception {

		HelloResponse response = new HelloResponse();
		response.setResponseMessage("Hello, your message was: " + request.getMessage());
		response.setToken(report.returnAToken());

		return response;
	}

}
