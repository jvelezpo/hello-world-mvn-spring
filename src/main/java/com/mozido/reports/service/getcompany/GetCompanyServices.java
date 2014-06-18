package com.mozido.reports.service.getcompany;

import com.mozido.reports.exception.ServerException;

/**
 * 
 * @author sebastian
 *
 */
public interface GetCompanyServices {
	Boolean authenticate(String token, String entityId) throws ServerException;
}
