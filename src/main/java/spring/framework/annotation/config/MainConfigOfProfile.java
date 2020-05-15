package spring.framework.annotation.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * Profile: define at which env can beans be register in IOC container
 * 	Spring provides a function which can dynamically activate and switch component
 * 
 *  e.g.: 				dev, 	test, 	prod
 *  	datasource:		(/A)	(/B)	(/C)
 *  
 *  1) only env activated, bean can register in IOC container, default is "default"
 *  2) programmatically set active profile and register config class
 *  3) bean without @Profile will be load at any profile 
 */
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {

	@Value("${db.user}")
	private String user;
	
	private String driverClass;
	
	@Profile("test")
	@Bean("testDataSource")
	public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Profile("default")
	@Bean("devDataSource")
	public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}
	
	@Profile("prod")
	@Bean("prodDataSource")
	public DataSource dataSourceProd(@Value("${db.password}") String pwd)  throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(pwd);
		dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test");
		dataSource.setDriverClass(driverClass);
		return dataSource;
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		this.driverClass = resolver.resolveStringValue("${db.driverClass}");
	}
}
