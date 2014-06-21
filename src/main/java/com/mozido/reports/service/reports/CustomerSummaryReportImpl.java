package com.mozido.reports.service.reports;

import java.io.IOException;

import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.report.CustomerSummary;
import com.mozido.reports.util.PropertyGetter;

/**
 * 
 * @author sebastian
 *
 */
@Service
public class CustomerSummaryReportImpl extends Report implements CustomerSummaryReport{

	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	CustomerSummary customerSummary;
	
	@Override
	public String doTheReport(String entityId, String fromDate, String toDate) throws IOException, ReportProcessingException {
		String report = customerSummary.doTheReport(entityId, fromDate, toDate);
		return report;
	}

}
