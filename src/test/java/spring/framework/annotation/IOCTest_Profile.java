package spring.framework.annotation;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.framework.annotation.config.MainConfigOfProfile;

public class IOCTest_Profile {

	//1. run params -Dspring.profiles.active=test
	//2. programmatic  see test02()
	@Test
	public void test02() {
		//1. create an applicationContext - no param constructor
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		//2. set active profile
		annotationConfigApplicationContext.getEnvironment().setActiveProfiles("test");
		//3. register config class
		annotationConfigApplicationContext.register(MainConfigOfProfile.class);	
		//4. IOC container refresh()
		annotationConfigApplicationContext.refresh();
		String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
		for(String string : beanNamesForType) {
			System.out.println(string);
		}
		annotationConfigApplicationContext.close();
	}
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfProfile.class);
		String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(DataSource.class);
		for(String string : beanNamesForType) {
			System.out.println(string);
		}
		annotationConfigApplicationContext.close();
	}
	
	private void printBeans(AnnotationConfigApplicationContext cxt) {
		String[] names = cxt.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
	}
}
