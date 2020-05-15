package spring.framework.annotation.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import spring.framework.annotation.bean.RainBow;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar{

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		// TODO Auto-generated method stub
		ImportBeanDefinitionRegistrar.super.registerBeanDefinitions(importingClassMetadata, registry);
		RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
		registry.registerBeanDefinition("rainBow", beanDefinition);
	}
	
}
