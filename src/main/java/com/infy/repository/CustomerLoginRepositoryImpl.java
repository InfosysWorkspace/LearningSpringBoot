package com.infy.repository;

import com.infy.dto.CustomerLoginDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository(value = "customerLoginRepository")
public class CustomerLoginRepositoryImpl implements CustomerLoginRepository{

    public CustomerLoginDTO getCustomerLoginByLoginName(String loginName){
        Map<String, String> customerCredentials = new HashMap<>();
        customerCredentials.put("buhari", "buhari123");
        customerCredentials.put("maryam", "maryam123");
        customerCredentials.put("aisha", "aisha123");
        customerCredentials.put("fatima", "fatima123");

        CustomerLoginDTO customerLogin = new CustomerLoginDTO();
        customerLogin.setLoginName(loginName);
        customerLogin.setPassword(customerCredentials.get(loginName));

        return customerLogin;
    }
}
