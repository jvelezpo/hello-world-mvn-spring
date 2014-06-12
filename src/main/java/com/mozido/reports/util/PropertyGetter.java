package com.mozido.reports.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 
 * @author Sebastian
 *
 */
@Configuration
public class PropertyGetter {

	/*Shared properties*/
	public static final String TENANT_NAME_KEY = "tenantName";
	public static final String CG_SURROUND = "cg_surround_host_and_port";
	public static final String MOTEAF_HOST_AND_PORT = "moteaf_host_and_port";
	
	
	/*Subcriber properties*/
	public static final String PERSON_TYPE_KEY = "personType";
	public static final String TIME_ZONE_KEY = "timeZone";
	public static final String TIME_ZONE_OFFSET_KEY = "timeZoneOffset";
	public static final String CREDENTIAL_TYPE_KEY = "credentialType";
	public static final String SECURITY_ELEMENT_TYPE_KEY = "securityElementType";
	public static final String GENDER_KEY = "genderKey";
	public static final String ACCOUNT_NAME_KEY = "accountName";
	public static final String CONTAINER_TYPE_KEY = "containerType";
	public static final String CONTAINER_SUB_TYPE_KEY = "containerSubType";
	public static final String CURRENCY_KEY = "currency";
	public static final String ACCOUNT_NAME_VALUE = "ACCOUNT_NAME";
	public static final String CAMPAIGN_KEY_VALUE = "campaign_id";
	public static final String CAMPAIGN_POINTS_KEY = "campaignPoints";
	public static final String RESET_ACTION_KEY = "resetAction";
	public static final String ADDRESS_NAME_KEY = "addressName";
	public static final String DEFAULT_COUNTRY_KEY = "defaultCountry";
	public static final String ADDRESS_TYPE_KEY = "addressType";
	public static final String PHONE_TYPE_KEY = "phoneType";
	public static final String REQUEST_TIMEOUT_IN_MILLIS = "requestTimeoutMillis";
	
	public static final String FIRST_NAME_KEY = "first_name";
	public static final String LAST_NAME_KEY = "last_name";
	public static final String EMAIL_KEY = "email";
	public static final String CODE_KEY = "code";
	
	/*admin properties*/
	public static final String ADMIN_ROLE_REFERENCE = "adminRoleReference";
	public static final String ADMIN_PERSON_TYPE_KEY = "adminPersonType";
	
	@Autowired
	private Environment env;
	
	public String getProperty(String key){
		return env.getProperty(key);
	}
}
