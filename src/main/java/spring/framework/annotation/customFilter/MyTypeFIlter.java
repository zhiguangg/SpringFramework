package spring.framework.annotation.customFilter;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFIlter implements TypeFilter {

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		Resource resource = metadataReader.getResource();
		System.out.println("annotationMetadata.getClassName():"+annotationMetadata.getClassName());
		System.out.println("classMetadata.getClassName():"+classMetadata.getClassName());
		System.out.println("resource.getFilename():"+resource.getFilename());
		String className = classMetadata.getClassName();
		return className.contains("er");
	}

}
