package spring.framework.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import spring.framework.annotation.bean.Car;
import spring.framework.annotation.bean.Color;
import spring.framework.annotation.dao.BookDao;

/*
 * auto assembly;
 * 	Spring use DI to complete IOC assembly
 * 1) @Autowired (Spring)
 * 		1) default will find bean in IOC container by type: applicationContext.getBean(BookDao.class);
 * 		2) if found multiple beans, then use property name as bean id to find from the container 
 * 					applicationContext.getBean("bookDao")
 * 		3) @Qualifier("bookDao"): user @Qualifier define bean id
 * 		4) auto assembly, properties need to be set, or will cause error
 * 			can use @Autowired(required=false);
 * 		5) @Primary: Spring will use as default bean;
 * 				if used @Qualifier, use bean defined by qualifier 
 * 2) Spring also support @Resource(JSR250) and @Inject(JSR330) [from Java]
 * 		@Resource: 
 * 			similar to @Autowired, default use bean name
 * 			do not support @Primary, do not support @Autowired(required=false); 
 * 		@Inject: 
 * 			need javax.inject dependency, support @Primiary, similar to @Autowired, do not have @Autowired(required=false)
 * 
 *  AutowiredAnnotationBeanPostProcessor
 *  
 * 3) @Autowired: constructor, method, field, params, get bean from IOC container
 * 		1) on method: @Bean + param, get param from IOC container; default no need for @Autowired
 * 		2) on constructor (with Params): if only one constructor, @Autowired can be omitted.
 * 		3) on params
 * 4) self defined beans want to use Spring IOC container lower level (ApplicationContext, BeanFactory, xxxAware):
 * 		implement xxxAware; At the time of construct the bean, will DI Spring lower level beans
 * 			xxxAware: xxxProcessor 
 * 		
 */

@ComponentScan(value= {"spring.framework.annotation.dao", "spring.framework.annotation.service", "spring.framework.annotation.controller","spring.framework.annotation.bean"})
@Configuration
public class MainConfigOfAutowire {

	@Primary
	@Bean("bookDao2")
	public BookDao bookDao() {
		BookDao bookDao = new BookDao();
		bookDao.setLabel("2");;
		return bookDao;
	}
	
	@Bean
	public Color color(Car car) {
		Color color = new Color();
		color.setCar(car);
		return color;
	}
}
