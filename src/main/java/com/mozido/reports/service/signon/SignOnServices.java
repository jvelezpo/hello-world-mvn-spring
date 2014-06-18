package com.mozido.reports.service.signon;

import com.mozido.reports.exception.ServerException;

public interface SignOnServices {
	public Boolean signIn(String username, String password) throws ServerException;
}
