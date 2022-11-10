package com.infy.utility;


import com.infy.exception.InfyBankException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);

    @Before("execution(* com.infy.service.*Impl.*(..))")
    public void before() throws InfyBankException{
        LOGGER.info("Before advice called.");
    }

    @After("execution(* com.infy.service.*Impl.*(..))")
    public void afer() throws InfyBankException{
        LOGGER.info("After advice called.");
    }

    @AfterReturning("execution(* com.infy.service.*Impl.*(..))")
    public void afterReturning() throws InfyBankException{
        LOGGER.info("After returning advice called.");
    }

    @AfterThrowing(pointcut = "execution(* com.infy.service.*Impl.*(..))", throwing = "exception")
    public void afterThrowing(InfyBankException exception) throws InfyBankException{
        LOGGER.error(exception.getMessage(), exception);
    }
}
