package com.abulkhair.project.customer_registration.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.abulkhair.project.customer_registration.dao.RegistrationDao;
import com.abulkhair.project.customer_registration.entity.Registration;

@Controller
public class RegistrationController {
	@Autowired
	RegistrationDao registrationDao;

	@RequestMapping(value = "/")
	public ModelAndView test(HttpServletResponse response) throws IOException {
		return new ModelAndView("registration");
	}
	
	@ResponseBody
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public HttpServletResponse addCustomer(HttpServletResponse httpServletResponse , @RequestBody Registration registration) {
		
		int count = registrationDao.register(registration);
		System.out.println(count);
		if(count ==1) {
			httpServletResponse.setStatus(httpServletResponse.SC_CREATED);
		}
		return httpServletResponse;
		
	}

}
