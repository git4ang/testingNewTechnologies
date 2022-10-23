package ang.neggaw.technologies;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TestingAppTests {

    @Test
    void contextLoads() {
        assertThat(1 + 3).isEqualTo(2 + 2);
    }

}
