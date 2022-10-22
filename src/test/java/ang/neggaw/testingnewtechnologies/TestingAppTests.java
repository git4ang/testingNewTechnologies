package ang.neggaw.testingnewtechnologies;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestingAppTests {

    @Test
    void contextLoads() {
        Assertions.assertEquals("7 + 3", "7 + 2 + 1", "It's same");
    }

}
