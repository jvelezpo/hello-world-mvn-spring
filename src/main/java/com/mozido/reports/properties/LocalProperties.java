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
		@PropertySource("classpath:reports_properties/default.properties"),
		@PropertySource(ignoreResourceNotFound = true, value = "classpath:reports_properties/devint2.properties")
})
public class LocalProperties {

}
