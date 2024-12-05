package sugarspring.helloboot2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.*;

@HellobootTest
public class HelloRepositoryTest {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired HelloRepository helloRepository;

	@BeforeEach
	void init() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS HELLO(NAME VARCHAR(50) PRIMARY KEY, COUNT INT)");
	}

	@Test
	void findHelloFailed() {
		assertThat(helloRepository.findHello("Sugar")).isNull();
	}

	@Test
	void increaseCount() {
		assertThat(helloRepository.countOf("Sugar")).isEqualTo(0);

		helloRepository.increaseCount("Sugar");
		assertThat(helloRepository.countOf("Sugar")).isEqualTo(1);

		helloRepository.increaseCount("Sugar");
		assertThat(helloRepository.countOf("Sugar")).isEqualTo(2);
	}
}
