package com.mozido.reports.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.reports.generated.EodPrintRequest;
import com.mozido.reports.generated.EodPrintResponse;
import com.mozido.reports.service.reports.EodReport;

/**
 * 
 * @author sebastian
 *
 */
@Endpoint
public class EodPrintEndPoint {
	
	@Autowired
	EodReport eodReport;
	
	@PayloadRoot(localPart = "eodPrintRequest", namespace = "http://mozido.com/reportssurround/eodPrint")
	@ResponsePayload
	public EodPrintResponse handleRequest(@RequestPayload EodPrintRequest request)
			throws Exception {

		EodPrintResponse response = new EodPrintResponse();
		response.setResponseMessage(
				eodReport.doTheReport(
						request.getToken(), 
						request.getRestaurantID(),
						request.getStartDate(), 
						request.getEndDate()));

		return response;
	}
}
