package com.mozido.reports.report;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.pentaho.reporting.engine.classic.core.MasterReport;
import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.pentaho.reporting.libraries.resourceloader.Resource;
import org.pentaho.reporting.libraries.resourceloader.ResourceException;
import org.pentaho.reporting.libraries.resourceloader.ResourceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.reports.util.PropertyGetter;

/**
 * 
 * @author sebastian
 * 
 */
@Service
public class SettlementByRestaurantImpl extends AbstractReportGenerator
		implements SettlementByRestaurant {

	@Autowired
	PropertyGetter propertyGetter;

	public String doTheReport(String entityID, String fromDate, String toDate)
			throws IOException, ReportProcessingException {

		this.restaurantID = entityID;
		this.fromDate = fromDate;
		this.toDate = toDate;

		// Create an output filename
		final File outputFilename = new File(SettlementByRestaurant.class.getSimpleName() + ".pdf");

		// Generate the report
		generateReport(AbstractReportGenerator.OutputType.PDF, outputFilename);

		// Send the path back
		return outputFilename.toURI().toURL().toString();
	}

	/**
	 * Returns the report definition which will be used to generate the report.
	 * In this case, the report will be loaded and parsed from a file contained
	 * in this package.
	 * 
	 * @return the loaded and parsed report definition to be used in report
	 *         generation.
	 */
	public MasterReport getReportDefinition() {
		try {
			// Using the classloader, get the URL to the reportDefinition file
			final ClassLoader classloader = this.getClass().getClassLoader();
			final URL reportDefinitionURL = classloader
					.getResource("com/mozido/reports/report/pentaho/"
							+ propertyGetter.getProperty(PropertyGetter.SETTLEMENT_BY_RESTAURANT));

			// Parse the report file
			final ResourceManager resourceManager = new ResourceManager();
			final Resource directly = resourceManager.createDirectly(
					reportDefinitionURL, MasterReport.class);
			return (MasterReport) directly.getResource();
		} catch (ResourceException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns the set of runtime report parameters. This sample report uses the
	 * following three parameters:
	 * <ul>
	 * <li><b>Report Title</b> - The title text on the top of the report</li>
	 * <li><b>Customer Names</b> - an array of customer names to show in the
	 * report</li>
	 * <li><b>Col Headers BG Color</b> - the background color for the column
	 * headers</li>
	 * </ul>
	 * 
	 * @return <code>null</code> indicating the report generator does not use
	 *         any report parameters
	 */
	public Map<String, Object> getReportParameters() {
		final Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("RestaurantID", this.restaurantID);
		parameters.put("StartDate", this.fromDate);
		parameters.put("EndDate", this.toDate);
		parameters.put("SortOrder", "ASC");

		return parameters;
	}
}
