package com.mozido.reports.service.getperson;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.api.core.getcompany.GetCompanyService;
import com.mozido.api.core.getperson.GetPerson;
import com.mozido.api.core.getperson.GetPersonRequest;
import com.mozido.api.core.getperson.GetPersonResponse;
import com.mozido.api.core.getperson.GetPersonService;
import com.mozido.api.core.personshared.Person;
import com.mozido.api.core.sharedcontext.ContextRequest;
import com.mozido.reports.exception.ServerException;
import com.mozido.reports.util.PropertyGetter;
import com.mozido.reports.util.network.NetworkServices;

/**
 * 
 * @author sebastian
 *
 */
@Service
public class GetPersonServicesImpl implements GetPersonServices{

	private GetPersonService getPersonService;
	private GetPerson getPerson;
	
	@Autowired
	private NetworkServices networkServices;
	
	@Autowired
	PropertyGetter propertyGetter;
	
	@PostConstruct
	public void initIt() throws Exception {
		getPersonService = new GetPersonService();
		getPerson = getPersonService.getGetPersonSoap11();
		networkServices.initSoapService((BindingProvider)getPerson, "getPerson");
	}
	
	public Person getPerson(String token) throws ServerException {
		Person person = null;
		
		ContextRequest contextRequest = new ContextRequest();
		contextRequest.setTenantName(propertyGetter.getProperty(PropertyGetter.TENANT_NAME_KEY));
		contextRequest.setToken(token);
		
		GetPersonRequest request = new GetPersonRequest();
		
		request.setContextRequest(contextRequest);
		request.setCredentialType("user");
		request.setCredential("user");
		
		try {
			GetPersonResponse response = getPerson.getPerson(request);
			if(!response.getContextResponse().getStatusCode().equals("SUCCESS")){
				throw new Exception();
			}
			person = response.getPerson();
		} catch (Exception e) {
			throw new ServerException("GetPerson Exception");
		}
		
		return person;
	}

}
