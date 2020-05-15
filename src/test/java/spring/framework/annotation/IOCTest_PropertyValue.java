package spring.framework.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import spring.framework.annotation.bean.Person;
import spring.framework.annotation.config.MainConfigOfPropertyValue;

public class IOCTest_PropertyValue {
	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);

	@Test
	public void test() {
		printBeans(annotationConfigApplicationContext);
		System.out.println("===========");
		Person person = (Person) annotationConfigApplicationContext.getBean("person");
		System.out.println(person);
		
		ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
		String property = environment.getProperty("person.nickname");
		System.out.println("property:"+property);
		annotationConfigApplicationContext.close();
	}
	
	private void printBeans(AnnotationConfigApplicationContext cxt) {
		String[] names = cxt.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
	}
}
