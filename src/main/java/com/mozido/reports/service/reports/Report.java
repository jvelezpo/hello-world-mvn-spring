package com.mozido.reports.service.reports;

import java.io.IOException;

import org.pentaho.reporting.engine.classic.core.ReportProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import com.mozido.api.core.personshared.Person;
import com.mozido.reports.exception.ServerException;
import com.mozido.reports.service.getcompany.GetCompanyServices;
import com.mozido.reports.service.getperson.GetPersonServices;
import com.mozido.reports.service.getroles.GetRolesServices;

public abstract class Report {
	
	@Autowired
	GetCompanyServices getCompanyServices;
	
	@Autowired
	GetRolesServices getRolesServices;
	
	@Autowired
	GetPersonServices getPersonServices;
	
	protected Boolean authenticate(String token, String entityId) throws ServerException{
		boolean authenticated = getCompanyServices.authenticate(token, entityId);
		return authenticated;
	}
	
	protected Boolean checkIfAdmin(String token) throws ServerException{
		
		Person person = getPersonServices.getPerson(token);
		
		boolean admin = getRolesServices.checkIfAdmin(token, Integer.parseInt(person.getId()));
		return admin;
	}
	
	public String doTheReport(String token, String entityId, String fromDate, String toDate) {
		String result = "N/A";
		
		//First authentication is needed
		boolean authenticated = false;
		try {
			if(entityId.toUpperCase().equals("ALL")){
				authenticated = checkIfAdmin(token);
			}else{
				authenticated = authenticate(token, entityId);
			}
		} catch (ServerException e) {
			result = "Authentication error";
		}
		if(authenticated){
			try {
				result = doTheReport(entityId, fromDate, toDate);
			} catch (IOException e) {
				result = "Generate Report IOException error";
			} catch (ReportProcessingException e) {
				result = "Generate Report ReportProcessingException error";
			}
		}
		return result;
	}
	
	public abstract String doTheReport(String entityId, String fromDate, String toDate) throws IOException, ReportProcessingException;
}
