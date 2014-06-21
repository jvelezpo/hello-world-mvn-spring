package com.mozido.reports.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mozido.reports.generated.RestaurantSummaryRequest;
import com.mozido.reports.generated.RestaurantSummaryResponse;
import com.mozido.reports.service.reports.RestaurantSummaryReport;

/**
 * 
 * @author sebastian
 *
 */
@Endpoint
public class RestaurantSummaryEndPoint {

	@Autowired
	RestaurantSummaryReport restaurantSummaryReport;
	
	@PayloadRoot(localPart = "restaurantSummaryRequest", namespace = "http://mozido.com/reportssurround/restaurantSummary")
	@ResponsePayload
	public RestaurantSummaryResponse handleRequest(@RequestPayload RestaurantSummaryRequest request)
			throws Exception {

		RestaurantSummaryResponse response = new RestaurantSummaryResponse();
		response.setResponseMessage(
				restaurantSummaryReport.doTheReport(
						request.getToken(), 
						request.getRestaurantID(),
						request.getStartDate(), 
						request.getEndDate()));

		return response;
	}
}
