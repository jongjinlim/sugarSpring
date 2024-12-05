package sugarspring.helloboot2;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import sugarspring.config.MySpringBootApplication;


@MySpringBootApplication
public class HelloBoot2Application {
	private final JdbcTemplate jdbcTemplate;

	public HelloBoot2Application(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS HELLO(NAME VARCHAR(50) PRIMARY KEY, COUNT INT)");
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloBoot2Application.class, args);
	}
}
