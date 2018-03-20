package cn.com.fourwind.propertyManager.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 
 * @author damit
 * 相当于对每个Controller默认加上允许跨域注解
 * 
 */
@Configuration
public class CorsConfigurerAdapter extends WebMvcConfigurerAdapter{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/*").allowedOrigins("*");
	}
	
	
	
	
	
	
}

