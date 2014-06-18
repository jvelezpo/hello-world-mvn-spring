package com.mozido.reports.service.getcompany;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.api.core.getcompany.GetCompany;
import com.mozido.api.core.getcompany.GetCompanyRequest;
import com.mozido.api.core.getcompany.GetCompanyResponse;
import com.mozido.api.core.getcompany.GetCompanyService;
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
public class GetCompanyServicesImpl implements GetCompanyServices{
	
	private GetCompanyService getCompanyService;
	private GetCompany getCompany;
	
	@Autowired
	private NetworkServices networkServices;
	
	@Autowired
	PropertyGetter propertyGetter;
	
	@PostConstruct
	public void initIt() throws Exception {
		getCompanyService = new GetCompanyService();
		getCompany = getCompanyService.getGetCompanySoap11();
		networkServices.initSoapService((BindingProvider)getCompany, "getCompany");
	}
	
	public Boolean authenticate(String token, String entityId) throws ServerException{
		boolean result = false;
		
		ContextRequest contextRequest = new ContextRequest();
		contextRequest.setTenantName(propertyGetter.getProperty(PropertyGetter.TENANT_NAME_KEY));
		contextRequest.setToken(token);
		
		GetCompanyRequest request = new GetCompanyRequest();
		request.setContextRequest(contextRequest);
		request.setCompanyId(Integer.parseInt(entityId));
		
		try{
			GetCompanyResponse response = getCompany.getCompany(request);
			if(!response.getContextResponse().getStatusCode().equals("SUCCESS")){
				result = false;
			}else{
				result = true;
			}
		}catch(Exception e){
			throw new ServerException("GetCompany Exception");
		}
		return result;
	}
}
