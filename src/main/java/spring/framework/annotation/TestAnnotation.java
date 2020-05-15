package spring.framework.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.framework.annotation.bean.Person;
import spring.framework.annotation.config.AnnotationConfig;

public class TestAnnotation {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		Person person = applicationContext.getBean(Person.class);
		System.out.println(person);
		
		String[] names = applicationContext.getBeanNamesForType(Person.class);
		for(String name : names) {
			System.out.println(name);
		}
		
		((ConfigurableApplicationContext)applicationContext).close();		
	}
	
}
