package sugarspring.helloboot2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.IntStream;

@HellobootTest
public class HelloServiceCountTest {
	@Autowired HelloService helloService;
	@Autowired HelloRepository helloRepository;

	@Test
	void sayHelloIncreaseCount() {
		IntStream.rangeClosed(1, 10).forEach(count -> {
			helloService.sayHello("Sugar");
			Assertions.assertThat(helloRepository.countOf("Sugar")).isEqualTo(count);
		});
	}
}
