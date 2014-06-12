package com.mozido.reports.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.examples.generated.helloitems.EodPrintRequest;
import com.mozido.examples.generated.helloitems.EodPrintResponse;
import com.mozido.reports.service.reports.EodReport;

@Endpoint
public class EodPrintEndPoint {
	
	@Autowired
	EodReport eodReport;
	
	@PayloadRoot(localPart = "eodPrintRequest", namespace = "http://localhost:8181/surround_reports/eodPrint")
	@ResponsePayload
	public EodPrintResponse handleRequest(@RequestPayload EodPrintRequest request)
			throws Exception {

		EodPrintResponse response = new EodPrintResponse();
		response.setResponseMessage("Hello, your message was: " + request.getToken());
		response.setResponseMessage(eodReport.testing("gbolanos", "1234"));

		return response;
	}
}
