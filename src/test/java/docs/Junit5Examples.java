package docs;

import org.junit.jupiter.api.*;

public class Junit5Examples {

    @BeforeAll
    static void setup() {
        System.out.println("setup here");
    }

    @BeforeEach
    void each() {
        System.out.println("    beforeEach here");
    }

    @Test
    @Tag("one")
    void someTest() {
        System.out.println("        someTest here");
    }

    @Test
    void anotherTest() {
        System.out.println("        anotherTest here");
    }

    @AfterEach
    void afterEach() {
        System.out.println("    afterEach here");
    }

    @AfterAll
    static void shutdown() {
        System.out.println("shutdown here");
    }
}