package sugarspring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

	private final ClassLoader classLoader;

	public MyAutoConfigImportSelector(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		// 이 람다식을
//		Iterable<String> candidates = ImportCandidates.load(MyAutoConfiguration.class, classLoader);
//		return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);

		// 이렇게 포문으로 바꿔줄수 있다.
		List<String> autoConfigs = new ArrayList<>();
//		for(String candidate: ImportCandidates.load(MyAutoConfiguration.class, classLoader)) {
//			autoConfigs.add(candidate);
//		}

		// 이것도
//		ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(candidate ->
//			autoConfigs.add(candidate)
//		);

		// 이렇게 바꿀수 있다.
		ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);

		return autoConfigs.toArray(new String[0]);
//		return Arrays.copyOf(autoConfigs.toArray(), autoConfigs.size(), String[].class);
//		return autoConfigs.stream().toArray(String[]::new);
	}
}
