package spring.framework.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Boss {

	private Car car;

	//@Autowired
	public Boss(@Autowired Car car) {
		this.car = car;
	}
	
	public Car getCar() {
		return car;
	}

	//@Autowired //when Spring create current bean, it will call the set method with bean from IOC container
	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Boss [car=" + car + "]";
	}
	
}
