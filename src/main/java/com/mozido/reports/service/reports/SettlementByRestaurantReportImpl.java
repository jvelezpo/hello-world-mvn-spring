package com.mozido.reports.service.reports;

import java.io.IOException;

import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.report.SettlementByRestaurant;
import com.mozido.reports.util.PropertyGetter;

/**
 * 
 * @author sebastian
 *
 */
@Service
public class SettlementByRestaurantReportImpl extends Report implements SettlementByRestaurantReport{

	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	SettlementByRestaurant settlementByRestaurant;

	@Override
	public String doTheReport(String entityId, String fromDate, String toDate) throws IOException, ReportProcessingException {
		String report = settlementByRestaurant.doTheReport(entityId, fromDate, toDate);
		return report;
	}

}
