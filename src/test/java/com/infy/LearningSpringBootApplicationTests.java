package com.infy;

import com.infy.dto.CustomerLoginDTO;
import com.infy.exception.InfyBankException;
import com.infy.service.CustomerLoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearningSpringBootApplicationTests {

	@Autowired
	CustomerLoginService customerLoginService;

	@Test
	public void authenticateCustomerTestValidCredentials() throws InfyBankException{
		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setLoginName("aisha");
		customer.setPassword("aisha123");
		String actual = customerLoginService.authenticateCustomer(customer);
		Assertions.assertEquals("SUCCESS", actual);
	}

	@Test
	public void authenticateCustomerTestInValidCredentials() throws InfyBankException{
		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setLoginName("aisha");
		customer.setPassword("aisha12");
		InfyBankException exception=Assertions.assertThrows(InfyBankException.class, () ->
				customerLoginService.authenticateCustomer(customer));
		Assertions.assertEquals("Service.WRONG_CREDENTIALS", exception.getMessage());
	}

	@Test
	void contextLoads() {
	}

}
