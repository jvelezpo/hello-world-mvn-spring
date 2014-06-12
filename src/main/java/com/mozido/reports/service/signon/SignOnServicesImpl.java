package com.mozido.reports.service.signon;

import javax.annotation.PostConstruct;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mozido.api.core.sharedcontext.ContextRequest;
import com.mozido.api.core.signon.Signon;
import com.mozido.api.core.signon.SignonRequest;
import com.mozido.api.core.signon.SignonResponse;
import com.mozido.api.core.signon.SignonService;
import com.mozido.reports.util.PropertyGetter;
import com.mozido.reports.util.network.NetworkServices;

@Service
public class SignOnServicesImpl implements SignOnServices {

	private SignonService signonService;
	private Signon signon;
	
	@Autowired
	private NetworkServices networkServices;
	
	@Autowired
	PropertyGetter propertyGetter;

	@PostConstruct
	public void initIt() throws Exception {
		signonService = new SignonService();
		signon = signonService.getSignonSoap11();
		networkServices.initSoapService((BindingProvider)signon, "signon");
	}
	
	public String signIn(String username, String password) {
		return doSignOn(username, password);
	}
	
	public String doSignOn(String username, String password){
		String result = "N/A"; 
		
		ContextRequest contextRequest = new ContextRequest();
		contextRequest.setTenantName(propertyGetter.getProperty(PropertyGetter.TENANT_NAME_KEY));
		
		SignonRequest signonRequest = new SignonRequest();
		
		signonRequest.setContextRequest(contextRequest);
		
		SignonRequest.Login login = new SignonRequest.Login();
		login.setCredentialType(propertyGetter.getProperty(PropertyGetter.CREDENTIAL_TYPE_KEY));
		login.setValue(username);
		signonRequest.setLogin(login);

		SignonRequest.Pass pass = new SignonRequest.Pass();
		pass.setSecurityElementType(propertyGetter.getProperty(PropertyGetter.SECURITY_ELEMENT_TYPE_KEY));
		pass.setValue(password);
		signonRequest.setPass(pass);

		SignonResponse signonResponse = signon.signon(signonRequest);
		
		try{
			result = signonResponse.getContextResponse().getToken();
			if(result == null)
				throw new Exception();
		}catch(Exception e){
			result = "Mozido Exception\n"+e.getMessage();
		}
		return result;
	}
}
