package com.loja;

import org.directwebremoting.spring.DwrSpringServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
@ImportResource(locations = "classpath:dwr-spring.xml")
@SpringBootApplication
public class LojaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean<DwrSpringServlet> dwrSpringServlet() {
		DwrSpringServlet dwrServlet = new DwrSpringServlet();
		
		ServletRegistrationBean<DwrSpringServlet> registrationBean = 
				new ServletRegistrationBean<>(dwrServlet, "/dwr/*");
		
		registrationBean.addInitParameter("debug", "false");
		registrationBean.addInitParameter("activeReverseAjaxEnabled",
										"true");
		return registrationBean;
	}
}
