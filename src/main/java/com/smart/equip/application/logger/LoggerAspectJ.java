package com.smart.equip.application.logger;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Geetha
 *
 */

@Aspect

@Component

public class LoggerAspectJ {
	private Logger logger = Logger.getLogger(getClass().getName());
 
	@Before("execution(* com.smart.equip.application.controller.*.*(..)) || execution(* com.smart.equip.application.service.*.*(..))")
	public void logBeforeCalling(JoinPoint join) {
		logger.info(join.getSignature().getDeclaringTypeName() + " Log Before Calling Method "
				+ join.getSignature().getName());
	}

	@AfterReturning("execution(* com.smart.equip.application.controller.*.*(..)) || execution(* com.smart.equip.application.service.*.*(..))")
	public void logAfterReturning(JoinPoint join) {
		logger.info(join.getSignature().getDeclaringTypeName() + " Log After Calling Method "
				+ join.getSignature().getName());

	}

	@AfterThrowing("execution(* com.smart.equip.application.controller.*.*(..)) || execution(* com.smart.equip.application.service.*.*(..))")
	public void logAfterThrowing(JoinPoint join) {
		logger.info(join.getSignature().getDeclaringTypeName() + " Log After Throwing Method "
				+ join.getSignature().getName());
	}

}
