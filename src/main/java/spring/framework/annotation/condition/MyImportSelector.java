package spring.framework.annotation.condition;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		MergedAnnotations annotations = importingClassMetadata.getAnnotations();
		//MergedAnnotation<Import> mergedAnnotation = annotations.get(Import.class);
		//System.out.println(mergedAnnotation.toString());
		return new String[] {"spring.framework.annotation.bean.Blue", "spring.framework.annotation.bean.Yellow"};
	}

}
