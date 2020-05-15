package spring.framework.annotation.config;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import spring.framework.annotation.bean.Car;
import spring.framework.annotation.bean.Dog;

/*
 *	Bean life cycle: bean construct -- properties set --> destroy
 *
 *  Bean construct: 
 *  	singleton: container start
 *  	prototype: get bean
 *  
 *  init
 *  
 *  destroy
 *
 *  populateBean
 *  initializaeBean
 *  {
 *	applyBeanPostProcessorsBeforeInitialization(wrappedBean, beanName);
 *		iterate through all BeanPostProcessors in the container
 *		call processor.postProcessBeforeInitialization(result, beanName);
 *		break if processor null
 *	invokeInitMethods(beanName, wrappedBean, mbd);
 *	applyBeanPostProcessorsAfterInitialization(wrappedBean, beanName);
 *	}		
 *  1) @Bean(initMethod="", destroyMethod="")
 *  	init:
 *  		constructor, value initiated, call init()
 *  	destroy:
 *  		singleton: container close
 *  		prototype: container will not manage
 *  2) Spring Interfaces
 *  	init:
 *  		implements InitializingBean <I>
 *  	destroy:
 *  		implements DisposableBean <I>
 *  3) JSR250
 *  	@PostConstruct: bean constructed, properties set, init
 *  	@PreDestroy: in the process of being removed
 *  4) BeanPostPrcessor: after bean construct, 
 *  	postProcessBeforeInitialization 
 *  	postProcessAfterInitialization
 *  
 *  spring lower level use of BeanPostProcessor
 */
@Import(Dog.class)
@ComponentScan(value="spring.framework,annotation")
@Configuration
public class MainConfigOfLifeCycle {

	@Bean(initMethod="init", destroyMethod="destroy")
	public Car car() {
		return new Car();
	}
}
