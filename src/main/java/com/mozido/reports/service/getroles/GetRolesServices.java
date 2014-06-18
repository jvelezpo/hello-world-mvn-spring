package com.mozido.reports.service.getroles;

import com.mozido.reports.exception.ServerException;

/**
 * 
 * @author sebastian
 *
 */
public interface GetRolesServices {
	Boolean checkIfAdmin(String token, Integer personId) throws ServerException;
}
