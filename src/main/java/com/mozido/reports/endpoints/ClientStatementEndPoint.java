package com.mozido.reports.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.reports.generated.ClientStatementRequest;
import com.mozido.reports.generated.ClientStatementResponse;
import com.mozido.reports.service.reports.ClientStatementReport;

/**
 * 
 * @author sebastian
 *
 */
@Endpoint
public class ClientStatementEndPoint {

	@Autowired
	ClientStatementReport clientStatementReport;
	
	@PayloadRoot(localPart = "clientStatementRequest", namespace = "http://mozido.com/reportssurround/clientStatement")
	@ResponsePayload
	public ClientStatementResponse handleRequest(@RequestPayload ClientStatementRequest request)
			throws Exception {

		ClientStatementResponse response = new ClientStatementResponse();
		response.setResponseMessage(
				clientStatementReport.doTheReport(
						request.getToken(), 
						request.getRestaurantID(),
						request.getStartDate(), 
						request.getEndDate()));

		return response;
	}
}
