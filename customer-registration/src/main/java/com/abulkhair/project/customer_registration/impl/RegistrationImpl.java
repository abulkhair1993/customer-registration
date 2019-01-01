package com.abulkhair.project.customer_registration.impl;

import java.util.Random;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.abulkhair.project.customer_registration.dao.RegistrationDao;
import com.abulkhair.project.customer_registration.entity.Registration;


public class RegistrationImpl implements RegistrationDao {
	public RegistrationImpl() {}
	
	JdbcTemplate jdbcTemplate;	
	public RegistrationImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int register(Registration registration) {
		System.out.println("registration ");
		Random rand = new Random();
		int id = rand.nextInt(1000);
		String sql = "INSERT INTO CUSTOMER_INFO VALUES(?,?,?,?,?)";

		try {
			
			int counter = jdbcTemplate.update(sql, new Object[] { id, registration.getFirstName(), registration.getLastName(), registration.getEmail(), registration.getMobile() });

			return counter;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
