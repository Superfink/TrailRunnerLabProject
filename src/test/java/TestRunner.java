import org.junit.jupiter.api.*;
import se.kristin.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestRunner {

    @BeforeEach
    public void setUp(){
        //Empty
    }

    @Test
    public void testEmptyRunnerCreation(){
        Runner runner = new Runner();
        assertEquals(0, runner.getHeight());
        assertEquals(0, runner.getWeight());
        assertEquals(0, runner.getAge());
    }

    @Test
    public void testRunnerCreation(){
        Runner runner = new Runner(176, 82, 42);
        assertEquals(176, runner.getHeight());
        assertEquals(82, runner.getWeight());
        assertEquals(42, runner.getAge());
    }



}
