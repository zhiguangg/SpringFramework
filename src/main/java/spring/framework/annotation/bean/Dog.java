package spring.framework.annotation.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class Dog {

	public Dog() {
		System.out.println("Dog...Constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Dog...PostConstruct...");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Dog...PreDestroy...");
	}
}
