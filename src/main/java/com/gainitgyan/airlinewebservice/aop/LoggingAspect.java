package com.gainitgyan.airlinewebservice.aop;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	private static final Logger logger = LogManager.getLogger(LoggingAspect.class);
	
	@Pointcut("within(com.gainitgyan.airlinewebservice.controller.*)")
	public void applicaitonControllerPackage() {
		
	}
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void applicaitonControllerBean() {
		
	}
	
	@Around("applicaitonControllerBean() && applicaitonControllerPackage()")
	public Object logAround(ProceedingJoinPoint joinpoint) throws Throwable {
		
		logger.debug("Request for {}.{}() with arguments[s]={}",joinpoint.getSignature().getDeclaringTypeName(), 
				joinpoint.getSignature().getName() , Arrays.toString(joinpoint.getArgs()));
		
		Instant start = Instant.now();
		
		Object returnValue = joinpoint.proceed();
		
		Instant finish = Instant.now();
				
		long timeElapsed = Duration.between(start, finish).toMillis();
		
		logger.debug("Response for {}.{} with Result ={}",joinpoint.getSignature().getDeclaringTypeName(), 
				joinpoint.getSignature().getName() ,returnValue);
		
		logger.info("Request for {}.{}() Execution Time={}",joinpoint.getSignature().getDeclaringTypeName(), 
				joinpoint.getSignature().getName() , new SimpleDateFormat("mm:ss:SSS").format(new Date(timeElapsed)));
		
		return returnValue;
	}
	
	@Pointcut("within(com.gainitgyan.airlinewebservice..*)")
	//@Pointcut("execution(* com.gainitgyan.airlinewebservice.controller.FlightController.*(..))")
	public void applicaitonExceptionPackage() {
		
	}
	@Pointcut("this(org.springframework.web.filter.GenericFilterBean)")
	private void genericFilterBeanImpl() {}
	
	@AfterThrowing(pointcut = "applicaitonExceptionPackage() && !genericFilterBeanImpl()",throwing = "e")
	public void logAfterThrowing(JoinPoint joinpoint, Throwable e) {
		logger.error("Exception in {}.{} with cause = {} , with message = {}",
				joinpoint.getSignature().getDeclaringTypeName(),joinpoint.getSignature().getName(),
				e.getCause() !=null ? e.getCause() : "NULL",
				e.getMessage() !=null ? e.getMessage() : "NULL"
				);
	}
	
}
