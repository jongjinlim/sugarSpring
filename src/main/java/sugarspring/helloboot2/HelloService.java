package sugarspring.helloboot2;

import org.springframework.stereotype.Component;

@Component
public interface HelloService {
	String sayHello(String name);
}
