package com.websystique.springboot.configuration;

/**
 * @author SYED ABDUL BASIT ALI
 *
 */


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

import java.util.Locale;

@Configuration
@ComponentScan(basePackages = { "com.websystique.springboot.controller"})
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {


	private int maxUploadSizeInMb = 3 * 1024 * 1024; // 3 MB


	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();

	}


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/css/");
		registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/");
		registry.addResourceHandler("/static/js/lib/**").addResourceLocations("classpath:/static/js/lib/");
		registry.addResourceHandler("/static/js/app/**").addResourceLocations("classpath:/static/js/app/");
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		//registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates");


	}

	@Bean
	public StandardServletMultipartResolver multipartResolver() {
		StandardServletMultipartResolver multipartResolver = new StandardServletMultipartResolver();
		return multipartResolver;
	}



	@Bean
	public JasperReportsViewResolver getJasperReportsViewResolver() {
		JasperReportsViewResolver resolver = new JasperReportsViewResolver();
		resolver.setPrefix("classpath:/jasperreports/");
		resolver.setSuffix(".jasper");
		// resolver.setReportDataKey("datasource");
		resolver.setViewNames("rpt_*");
		resolver.setViewClass(JasperReportsMultiFormatView.class);
		resolver.setOrder(0);

		return resolver;
	}



	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(new Locale("en"));
		resolver.setCookieName("myLocaleCookie");
		resolver.setCookieMaxAge(4800);
		return resolver;
	}


}
