package com.mozido.reports.service.reports;

import java.io.IOException;

import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.report.ClientStatement;
import com.mozido.reports.util.PropertyGetter;

/**
 * 
 * @author sebastian
 *
 */
@Service
public class ClientStatementReportImpl extends Report implements ClientStatementReport{

	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	ClientStatement clientStatement;

	@Override
	public String doTheReport(String entityId, String fromDate, String toDate) throws IOException, ReportProcessingException {
		String report = clientStatement.doTheReport(entityId, fromDate, toDate);
		return report;
	}

}
