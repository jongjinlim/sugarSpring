package sugarspring.helloboot2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
		SimpleHelloService helloService = new SimpleHelloService(helloRepositoryStub);

		String ret = helloService.sayHello("Test");

		Assertions.assertThat(ret).isEqualTo("Hello Test");
	}

	private static HelloRepository helloRepositoryStub = new HelloRepository() {
			@Override
			public Hello findHello(String name) {
				return null;
			}

			@Override
			public void increaseCount(String name) {

			}
	};

	@Test
	void helloDecorator() {
		HelloDecorator decorator = new HelloDecorator(name -> name);
		String ret = decorator.sayHello("Test");

		Assertions.assertThat(ret).isEqualTo("*Test*");
	}
}
