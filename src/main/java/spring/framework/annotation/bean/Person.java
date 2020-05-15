package spring.framework.annotation.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
	//1. basic value
	//2. SpEL #{}
	//3. ${}; value from env
	@Value("Tom")
	private String name;
	@Value("#{20-2}")
	private Integer age;
	@Value("${person.nickname}")
	private String nickname;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nickname=" + nickname + "]";
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
}
