package ru.netology.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    private static GenericContainer<?> myapp = new GenericContainer("devapp");
    private static GenericContainer<?> myapp2 = new GenericContainer("prodapp");
    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    public static void setUp() {
        myapp.start();
        myapp2.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntityFirst = restTemplate.getForEntity("http://localhost:" + myapp.getMappedPort(8099), String.class);
        ResponseEntity<String> forEntitySecond = restTemplate.getForEntity("http://localhost:" + myapp2.getMappedPort(8098), String.class);
        System.out.println(forEntityFirst.getBody());
        System.out.println(forEntitySecond.getBody());
    }

}
