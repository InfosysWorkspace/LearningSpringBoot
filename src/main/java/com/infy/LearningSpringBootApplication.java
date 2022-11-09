package com.infy;

import com.infy.controller.CustomerLoginController;
import com.infy.dto.CustomerLoginDTO;
import com.infy.exception.InfyBankException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class LearningSpringBootApplication implements CommandLineRunner {
	public static final Log LOGGER = LogFactory.getLog(LearningSpringBootApplication.class);

	@Autowired
	CustomerLoginController customerLoginController;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		try {
			CustomerLoginDTO customerLogin = new CustomerLoginDTO();
			customerLogin.setLoginName("buhari");
			customerLogin.setPassword("buhari123");

			customerLoginController.authenticateCustomer(customerLogin);

			LOGGER.info(environment.getProperty("SUCCESS"));

		} catch (InfyBankException exception){
			LOGGER.error(environment.getProperty(exception.getMessage()));
		}
	}

}
