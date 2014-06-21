package com.mozido.reports.report;

import java.io.IOException;

import org.pentaho.reporting.engine.classic.core.ReportProcessingException;

/**
 * 
 * @author sebastian
 *
 */
public interface EodPrint {

	/**
	 * 
	 * @param restaurantID
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws IOException
	 * @throws ReportProcessingException
	 */
	String doTheReport(String entityId, String fromDate, String toDate) throws IOException, ReportProcessingException;
}
