package spring.framework.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.framework.annotation.bean.Car;
import spring.framework.annotation.config.MainConfigOfLifeCycle;

public class IOCTest_LifeCycyle {
	
	
	@Test
	public void test01() {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
		System.out.println("IOC constructed...");
		
//		Car car = cxt.getBean(Car.class);
		cxt.close();	
	}
}
