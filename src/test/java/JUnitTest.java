import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class JUnitTest {

    @DisplayName("1+2는 3이다")
    @Test
    public void junitTest() {
        int a = 1;
        int b = 2;
        int sum = 3;

        System.out.println("1+2는 3이다");
        // expected value, actual value
        Assertions.assertEquals(sum, a + b);
    }

    @DisplayName("1+3은 3이다.")
    @Test
    public void junitFailTest() {
        int a = 1;
        int b = 3;
        int sum = 3;

        System.out.println("1+3는 3이다");
        Assertions.assertEquals(sum, a + b);
    }

    @BeforeEach
    public void prepare() {
        System.out.println("테스트 준비");
    }

    @BeforeAll
    public static void prepareAll() {
        System.out.println("최초 준비");
    }

    @AfterAll
    public static void cleanAll() {
        System.out.println("최종 마무리");
    }
}