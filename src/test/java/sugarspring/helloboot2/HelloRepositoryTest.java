package sugarspring.helloboot2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired HelloRepository helloRepository;

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
