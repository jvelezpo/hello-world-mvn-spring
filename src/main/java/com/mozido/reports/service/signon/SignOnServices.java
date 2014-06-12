package com.mozido.reports.service.signon;

import com.mozido.api.core.signon.SignonRequest;
import com.mozido.api.core.signon.SignonResponse;


public interface SignOnServices {
	public String signIn(String username, String password);
}
