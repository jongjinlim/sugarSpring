package sugarspring.helloboot2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 이런식으로 메타에 메타에 메타 어노테이션을 사용 할 수 있다.
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.METHOD)
//@UnitTest
//@interface FastUnitTest {}

//@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
//@Test
//@interface UnitTest {}

public class HelloServiceTest {
	@Test
	void simpleHelloService() {
		SimpleHelloService helloService = new SimpleHelloService();

		String ret = helloService.sayHello("Test");

		Assertions.assertThat(ret).isEqualTo("Hello Test");
	}

	@Test
	void helloDecorator() {
		HelloDecorator decorator = new HelloDecorator(name -> name);
		String ret = decorator.sayHello("Test");

		Assertions.assertThat(ret).isEqualTo("*Test*");
	}
}
