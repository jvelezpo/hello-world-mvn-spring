package com.mozido.reports.service.getroles;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.api.core.getroles.GetRoles;
import com.mozido.api.core.getroles.GetRolesRequest;
import com.mozido.api.core.getroles.GetRolesResponse;
import com.mozido.api.core.getroles.GetRolesService;
import com.mozido.api.core.sharedcontext.ContextRequest;
import com.mozido.reports.exception.ServerException;
import com.mozido.reports.service.getperson.GetPersonServices;
import com.mozido.reports.util.PropertyGetter;
import com.mozido.reports.util.network.NetworkServices;

/**
 * 
 * @author sebastian
 *
 */
@Service
public class GetRolesServicesImpl implements GetRolesServices{

	private GetRolesService getRolesService;
	private GetRoles getRoles;
	
	@Autowired
	private NetworkServices networkServices;
	
	@Autowired
	PropertyGetter propertyGetter;
	
	@Autowired
	GetPersonServices getPersonServices;
	
	@PostConstruct
	public void initIt() throws Exception {
		getRolesService = new GetRolesService();
		getRoles = getRolesService.getGetRolesSoap11();
		networkServices.initSoapService((BindingProvider)getRoles, "getRoles");
	}

	public Boolean checkIfAdmin(String token, Integer personId) throws ServerException{
		boolean result = false;
		
		ContextRequest contextRequest = new ContextRequest();
		contextRequest.setTenantName(propertyGetter.getProperty(PropertyGetter.TENANT_NAME_KEY));
		contextRequest.setToken(token);
		
		GetRolesRequest request = new GetRolesRequest();
		request.setContextRequest(contextRequest);
		request.setPersonId(personId);
		
		try {
			GetRolesResponse response = getRoles.getRoles(request);
			if(!response.getContextResponse().getStatusCode().equals("SUCCESS")){
				throw new Exception();
			}
			if(response.getRoles().get(0).getRoleReference().equals("EL_SALVADOR_MR_DONUT_ADMINISTRATOR")){
				result = true;
			}
		} catch (Exception e) {
			throw new ServerException("GetRoles Exception");
		}
		return result;
	}
}
