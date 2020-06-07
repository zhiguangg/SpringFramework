package spring.framework.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import spring.framework.annotation.aop.LogAspects;
import spring.framework.annotation.aop.MathCalculator;

/*
 * AOP:  
 * 		1. add dependency: spring-aspects
 * 		2. create a business logic class
 * 		3. create a aspect class
 * 			@Before
 * 			@After
 * 			@AfterReturning
 * 			@AfterThrowing
 * 			@Around
 * 		4. annotate aspect class method
 * 		5. register aspect class and business class into IOC
 * 		6. @Aspect annotate aspect class
 * 		7. @EnableAspectJAutoProxy to config class
 * 3 steps:
 * 		1. register business logic and aspect class in IOC, tell IOC which class is the aspect class (@Aspect)
 * 		2. annotate every method in aspect class, tell spring when where execute (Pointcut)
 * 		3. @EnableAspectJAutoProxy
 * 
 * AOP principle:
 * 
 * 	1. @EnableAspectJAutoProxy
 * 		@Import(AspectJAutoProxyRegistrar.class)
 * 			use ImportBeanDefinitionRegistrar to register self defined bean
 * 
 */

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {

	@Bean
	public MathCalculator calculator() {
		return new MathCalculator();
	}
	
	@Bean
	public LogAspects logAspect() {
		return new LogAspects();
	}
}
