package com.mozido.reports.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.reports.generated.CustomerSummaryRequest;
import com.mozido.reports.generated.CustomerSummaryResponse;
import com.mozido.reports.service.reports.CustomerSummaryReport;

/**
 * 
 * @author sebastian
 *
 */
@Endpoint
public class CustomerSummaryEndPoint {

	@Autowired
	CustomerSummaryReport customerSummaryReport;
	
	@PayloadRoot(localPart = "customerSummaryRequest", namespace = "http://mozido.com/reportssurround/customerSummary")
	@ResponsePayload
	public CustomerSummaryResponse handleRequest(@RequestPayload CustomerSummaryRequest request)
			throws Exception {

		CustomerSummaryResponse response = new CustomerSummaryResponse();
		response.setResponseMessage(
				customerSummaryReport.doTheReport(
						request.getToken(), 
						request.getRestaurantID(),
						request.getStartDate(), 
						request.getEndDate()));

		return response;
	}
}
