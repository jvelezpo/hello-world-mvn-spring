package com.mozido.reports.service.reports;

import java.io.IOException;

import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.report.EodPrint;
import com.mozido.reports.util.PropertyGetter;

/**
 * 
 * @author sebastian
 *
 */
@Service
public class EodReportImpl extends Report implements EodReport{

	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	EodPrint eodPrint;
	
	public String doTheReport(String entityId, String fromDate, String toDate) throws IOException, ReportProcessingException{
		String report = eodPrint.doTheReport(entityId, fromDate, toDate);
		return report;
	}
}
