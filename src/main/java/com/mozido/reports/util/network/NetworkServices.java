package com.mozido.reports.util.network;

import javax.xml.ws.BindingProvider;

public interface NetworkServices {
	void initSoapService(BindingProvider bindingProvider,  String endPointAddress);
}
