package spring.framework.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import spring.framework.annotation.bean.Person;
import spring.framework.annotation.config.AnnotationConfig;
import spring.framework.annotation.config.AnnotationConfig2;

public class IOCTest {
	AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(AnnotationConfig2.class);

	@Test
	public void test01() {
		String[] names =cxt.getBeanDefinitionNames();
		/*
		 * for(String name : names) { System.out.println(name); }
		 * ((ConfigurableApplicationContext)cxt).close();
		 */
		System.out.println("IOC initiated...");
		Person person = (Person)cxt.getBean("person");
		Person person2 = (Person)cxt.getBean("person");
		
		System.out.println(person == person2);
	}
	
	@Test
	public void test02() {
		
		ConfigurableEnvironment environment = cxt.getEnvironment();
		  String[] names = cxt.getBeanNamesForType(Person.class); String os
		  =environment.getProperty("os.name"); System.out.println("os:"+os); for(String
		  name : names) { System.out.println(name); }
		 
		
	}
	
	@Test
	public void testImport() {
		Object bean = cxt.getBean("&colorFactoryBean");
		System.out.println(bean.getClass());
//		printBeans(cxt);
	}
	
	private void printBeans(AnnotationConfigApplicationContext cxt) {
		String[] names = cxt.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
	}
}
