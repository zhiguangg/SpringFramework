package spring.framework.annotation.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import spring.framework.annotation.bean.Car;

/*
 * Ext: 
 * BeanPostProcessor: at the time before or after bean object creation, intercept and work
 * BeanFactoryPostProcessor: Modify the application context's internal bean factory after its standard initialization. 
 * 		BeanDefinitionRegistryPostProcessor
 * 
 */
@ComponentScan("spring.framework.annotation.ext")
@Configuration
public class ExtConfig {

	@Bean
	public Car car() {
		return new Car();
	}
}
