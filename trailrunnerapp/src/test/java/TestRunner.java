import org.junit.jupiter.api.*;
import se.kristin.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestRunner {

    @BeforeEach
    public void setUp(){
        Runner runner = new Runner();
    }

    @Test
    public void testEmptyRunnerCreation(){
        Runner runner = new Runner();
        assertEquals(runner.getHeight(), 0);
        assertEquals(runner.getWeight(), 0);
        assertEquals(runner.getAge(), 0);
    }

    @Test
    public void testRunnerCreation(){
        Runner runner = new Runner(176, 82, 42);
        assertEquals(runner.getHeight(), 176);
        assertEquals(runner.getWeight(), 82);
        assertEquals(runner.getAge(), 42);
    }


}
