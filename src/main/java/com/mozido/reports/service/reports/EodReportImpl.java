package com.mozido.reports.service.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.api.core.personshared.Person;
import com.mozido.reports.exception.ServerException;
import com.mozido.reports.service.getcompany.GetCompanyServices;
import com.mozido.reports.service.getperson.GetPersonServices;
import com.mozido.reports.service.getroles.GetRolesServices;
import com.mozido.reports.service.signon.SignOnServices;
import com.mozido.reports.util.PropertyGetter;

/**
 * 
 * @author sebastian
 *
 */
@Service
public class EodReportImpl implements EodReport{

	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	SignOnServices signOnServices;
	
	@Autowired
	GetCompanyServices getCompanyServices;
	
	@Autowired
	GetRolesServices getRolesServices;
	
	@Autowired
	GetPersonServices getPersonServices;
	
	
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
			result = "LISTO PAPITO SI ES YA ES YA";
		}
		return result;
	}
	
	private Boolean authenticate(String token, String entityId) throws ServerException{
		boolean authenticated = getCompanyServices.authenticate(token, entityId);
		return authenticated;
	}
	
	private Boolean checkIfAdmin(String token) throws ServerException{
		
		Person person = getPersonServices.getPerson(token);
		
		boolean admin = getRolesServices.checkIfAdmin(token, Integer.parseInt(person.getId()));
		return admin;
	}
}
