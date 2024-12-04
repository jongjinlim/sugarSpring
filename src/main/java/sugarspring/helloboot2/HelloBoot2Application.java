package sugarspring.helloboot2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import sugarspring.config.MySpringBootApplication;


@MySpringBootApplication
public class HelloBoot2Application {

//	@Bean
//	ApplicationRunner applicationRunner(Environment env) {
//		return args -> {
//			String name = env.getProperty("my.name");
//			System.out.println("my.name: " + name);
//		};
//	}

	public static void main(String[] args) {
		SpringApplication.run(HelloBoot2Application.class, args);
	}
}
