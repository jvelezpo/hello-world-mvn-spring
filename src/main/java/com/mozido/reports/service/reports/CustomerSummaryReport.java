package com.mozido.reports.service.reports;

/**
 * 
 * @author sebastian
 *
 */
public interface CustomerSummaryReport {

	/**
	 * 
	 * @param token
	 * @param entityId
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	String doTheReport(String token, String entityId, String fromDate, String toDate);
}
