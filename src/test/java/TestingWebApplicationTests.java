import Spring.AccessingDataJpaApplication;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest(classes = AccessingDataJpaApplication.class)
public class TestingWebApplicationTests {

    @Test
    public void contextLoads() {
        System.out.println("Hello World!");
    }

}