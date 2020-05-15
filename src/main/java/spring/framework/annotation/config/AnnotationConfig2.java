package spring.framework.annotation.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import spring.framework.annotation.bean.Color;
import spring.framework.annotation.bean.ColorFactoryBean;
import spring.framework.annotation.bean.Person;
import spring.framework.annotation.bean.Red;
import spring.framework.annotation.condition.LinuxCondition;
import spring.framework.annotation.condition.MyImportBeanDefinitionRegistrar;
import spring.framework.annotation.condition.MyImportSelector;
import spring.framework.annotation.condition.WindowsCondition;

/*
 * summary: register in IOC container
 * 	1. ComponentScan + annotation (@Component, @Repository, @Resource, @Controller) -- limited to self written 
 *  2. @Bean[third party component]
 *  3. @Import[fast add a component into container]
 *  	1)@Import(the Component to be added)
 *  	2)ImportSelector: return array of component full class names
 *  	3)ImportBeanDefinitionRegistrar
 *  4. use FactoryBean from spring
 *  	1) default getObject
 *  `	2) to get the FactoryBean, prefix & to id
 */

//custome ImportSelector
//Register bean definition manually
@Configuration
@Import({Color.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class AnnotationConfig2 {
	
	@Bean
	@Lazy
	public Person person() {
		return new Person("person", 22);
	}

	@Bean("bill")
	@Conditional(WindowsCondition.class)
	public Person person01() {
		return new Person("Bill", 62);
	}
	
	@Bean("linus")
	@Conditional(LinuxCondition.class)
	public Person person02() {
		return new Person("Bill", 62);
	}
	
	@Bean
	public ColorFactoryBean colorFactoryBean() {
		return new ColorFactoryBean();
	}
	
	
}
