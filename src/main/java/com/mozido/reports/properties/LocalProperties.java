package com.mozido.reports.properties;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Sebastian
 *
 */
@Component
@PropertySources(value = { 
		@PropertySource("classpath:connector_properties/default.properties"),
		@PropertySource(ignoreResourceNotFound = true, value = "classpath:connector_properties/${build.level}.properties"),
		@PropertySource(ignoreResourceNotFound = true, value = "file:${catalina.base}/conf/ESDM-REP.properties")
})
public class LocalProperties {

}
