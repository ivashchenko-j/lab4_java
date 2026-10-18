import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitTest {

    @Test
    void testJUnitWorks() {
        System.out.println("JUnit works just fine!");
        Assertions.assertEquals(4, 2 + 2);
    }
}
