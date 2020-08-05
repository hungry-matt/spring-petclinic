package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//bean 등록
@Component
//생성한 애노테이션을 작동하기 위해
@Aspect
public class LogAspect {
	Logger logger = LoggerFactory.getLogger(LogAspect.class);

//	@Around("@annotation(LogExecutionTime)")
	//Pointcut 직접 지정
	@Around("execution(* org.springframework.samples.petclinic.owner.*Controller.*(..))")
	public Object LogExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		// joinPoint -> 해당 애노테이션이 있는 메소드를 가리킨다
		// Proxy pattern AOP
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object proceed = joinPoint.proceed();
		Object args[] = joinPoint.getArgs();
		logger.info(args[0].getClass().getName());
		logger.info(joinPoint.getSignature().getName());

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		return proceed;
	}
}
