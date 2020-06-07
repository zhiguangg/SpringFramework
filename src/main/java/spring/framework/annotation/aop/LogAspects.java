package spring.framework.annotation.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LogAspects {
	
	//abstract pointcut expression
	@Pointcut("execution(public int spring.framework.annotation.aop.MathCalculator.*(..))")
	public void pointCut() {};

	@Before("pointCut()")
	public void logStart(JoinPoint joinPoint) {
		System.out.println(""+joinPoint.getSignature().getName()+" start .... params {"+Arrays.asList(joinPoint.getArgs())+"}");
	}
	
	@After("pointCut()")
	public void logEnd(JoinPoint joinPoint) {
		System.out.println(""+joinPoint.getSignature().getName()+" end .... ");
	}
	
	@AfterReturning(value="pointCut()", returning="result")	
	public void logReturn(JoinPoint joinPoint, Object result) {
		System.out.println(""+joinPoint.getSignature().getName()+" normal return .... returned {"+result+"}");
	}
	
	@AfterThrowing(value="pointCut()", throwing="ex")
	public void logException(JoinPoint joinPoint, Exception ex) {
		System.out.println(""+joinPoint.getSignature().getName()+" exception ....  {"+ex+"}");
	}
}
