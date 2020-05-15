package spring.framework.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.framework.annotation.bean.Boss;
import spring.framework.annotation.bean.Car;
import spring.framework.annotation.bean.Color;
import spring.framework.annotation.bean.Red;
import spring.framework.annotation.config.MainConfigOfAutowire;
import spring.framework.annotation.dao.BookDao;
import spring.framework.annotation.service.BookService;

public class IOCTest_Autowire {
	
	@Test
	public void test() {
		AnnotationConfigApplicationContext cxt = new AnnotationConfigApplicationContext(MainConfigOfAutowire.class);
		BookService bookService = cxt.getBean(BookService.class);
		bookService.print();
		
		BookDao bookDao = cxt.getBean(BookDao.class);
		System.out.println(bookDao.toString());
		
		Boss boss = cxt.getBean(Boss.class);
		System.out.println(boss);
		
		Car car = cxt.getBean(Car.class);
		System.out.println(car);
		
		Color color = cxt.getBean(Color.class);
		System.out.println(color);
		
		Red red = cxt.getBean(Red.class);
		System.out.println(red);
		cxt.close();
	}
}
