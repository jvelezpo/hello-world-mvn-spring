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
@PropertySources(value={@PropertySource("classpath:properties/default.properties")})
public class LocalProperties {

}
