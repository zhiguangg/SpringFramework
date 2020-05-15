package spring.framework.annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import spring.framework.annotation.bean.Person;

@Configuration
@ComponentScan(value="spring.framework.annotation",excludeFilters= {@Filter(type=FilterType.ANNOTATION, classes= {Repository.class, Controller.class})}, useDefaultFilters = false)
@ComponentScan(value="spring.framework.annotation",includeFilters= {@Filter(type=FilterType.ANNOTATION, classes= {Configuration.class})})

//exludeFilters: Filter[]
//includeFilters: Filter[]
//FilterType.ANNOTATION
//FilterType.ASSIGNABLE_TYPE
//FilterType.ASPECTJ
//FilterType.REGEX
//FilterType.CUSTOM
public class AnnotationConfig {

	@Bean("person")
	@Scope("prototype")
	public Person person() {
		System.out.println("bean added");
		return new Person("Tom", 18);
	}
}
