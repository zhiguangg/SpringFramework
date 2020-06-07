package spring.framework.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.framework.annotation.tx.TxConfig;
import spring.framework.annotation.tx.UserService;

public class IOCTest_Tx {

	@Test
	public void test() {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(TxConfig.class);
		UserService userService = cxt.getBean(UserService.class);
		userService.insertUser();
		cxt.close();
	}
}
