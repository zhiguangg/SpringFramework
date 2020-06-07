package spring.framework.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.framework.annotation.aop.MathCalculator;
import spring.framework.annotation.config.MainConfigOfAOP;

public class IOCTest_AOP {

	@Test
	public void test() {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
		MathCalculator calculator = cxt.getBean(MathCalculator.class);
		calculator.div(10, 3);
		calculator.multiply(10, 3);
		calculator.add(10, 3);
		calculator.subtract(10, 3);
		cxt.close();
	}
}
