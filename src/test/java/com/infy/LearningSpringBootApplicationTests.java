package com.infy;

import com.infy.dto.CustomerLoginDTO;
import com.infy.exception.InfyBankException;
import com.infy.repository.CustomerLoginRepository;
import com.infy.service.CustomerLoginService;
import com.infy.service.CustomerLoginServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearningSpringBootApplicationTests {

	@Mock
	CustomerLoginRepository customerLoginRepository;

	@InjectMocks
	CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();

	@Test
	public void authenticateCustomerTestValidCredentials() throws InfyBankException{
		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setLoginName("aisha");
		customer.setPassword("aisha123");

		Mockito.when(customerLoginRepository.getCustomerLoginByLoginName("aisha")).thenReturn(customer);

		String actual = customerLoginService.authenticateCustomer(customer);
		Assertions.assertEquals("SUCCESS", actual);
	}

	@Test
	public void authenticateCustomerTestInValidCredentials() throws InfyBankException{
		CustomerLoginDTO customer = new CustomerLoginDTO();
		customer.setLoginName("aisha");
		customer.setPassword("aisha12");

		CustomerLoginDTO fromRepository = new CustomerLoginDTO();
		fromRepository.setLoginName("aisha");
		fromRepository.setLoginName("aisha12");

		Mockito.when(customerLoginRepository.getCustomerLoginByLoginName("aisha")).thenReturn(fromRepository);

		InfyBankException exception=Assertions.assertThrows(InfyBankException.class, () ->
				customerLoginService.authenticateCustomer(customer));
		Assertions.assertEquals("Service.WRONG_CREDENTIALS", exception.getMessage());
	}

	@Test
	void contextLoads() {
	}

}
