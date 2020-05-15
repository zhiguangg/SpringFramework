package spring.framework.annotation.bean;

import org.springframework.beans.factory.FactoryBean;

public class ColorFactoryBean implements FactoryBean<Color> {

	//return a Color object, added to container
	@Override
	public Color getObject() throws Exception {
		System.out.println("ColorFactoryBean...getObject()");
		return new Color();
	}

	@Override
	public Class<?> getObjectType() {
		System.out.println("ColorFactoryBean...getObjectType()");
		return Color.class;
	}
	
	public boolean isSingleton() {
		return true;
	}
}
