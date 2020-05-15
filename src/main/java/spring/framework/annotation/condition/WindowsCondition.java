package spring.framework.annotation.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		Environment environment = context.getEnvironment();
		String os = environment.getProperty("os.name");
		if(os.contains("Windows")) {
			return true;
		}
		return false;
	}

}

