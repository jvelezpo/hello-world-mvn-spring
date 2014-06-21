package com.mozido.reports.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.reports.generated.SettlementByRestaurantRequest;
import com.mozido.reports.generated.SettlementByRestaurantResponse;
import com.mozido.reports.service.reports.SettlementByRestaurantReport;

/**
 * 
 * @author sebastian
 *
 */
@Endpoint
public class SettlementByRestaurantEndPoint {
	
	@Autowired
	SettlementByRestaurantReport settlementByRestaurantReport;
	
	@PayloadRoot(localPart = "settlementByRestaurantRequest", namespace = "http://mozido.com/reportssurround/settlementByRestaurant")
	@ResponsePayload
	public SettlementByRestaurantResponse handleRequest(@RequestPayload SettlementByRestaurantRequest request)
			throws Exception {

		SettlementByRestaurantResponse response = new SettlementByRestaurantResponse();
		response.setResponseMessage(
				settlementByRestaurantReport.doTheReport(
						request.getToken(), 
						request.getRestaurantID(),
						request.getStartDate(), 
						request.getEndDate()));

		return response;
	}
}
