package spring.framework.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.framework.annotation.ext.ExtConfig;

public class IOCTest_Ext {

	@Test
	public void test() {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(ExtConfig.class);
		//MyBeanFactoryPostProcessor beanFactoryPostProcessor = cxt.getBean(MyBeanFactoryPostProcessor.class);
		cxt.publishEvent(new ApplicationEvent(new String("my event")) {});
		cxt.close();
	}
}
