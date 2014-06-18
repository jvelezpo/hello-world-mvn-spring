package com.mozido.reports.service.getperson;

import com.mozido.api.core.personshared.Person;
import com.mozido.reports.exception.ServerException;

/**
 * 
 * @author sebastian
 *
 */
public interface GetPersonServices {
	Person getPerson(String token) throws ServerException;
}
