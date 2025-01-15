import org.junit.jupiter.api.*;
import se.kristin.*;
import se.kristin.Record;

import static org.junit.jupiter.api.Assertions.*;


public class TestRunner {

    Record mockRecord1;
    Record mockRecord2;
    Runner runner;
    

    @BeforeEach
    public void setUp(){
        runner = new Runner(176, 82, 42);
        mockRecord1 = new Record("ID1", 5.2, 123);
        mockRecord2 = new Record("ID2", 5.2, 123);
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
        Runner runner = new Runner(123, 12, 1);
        assertEquals(123, runner.getHeight());
        assertEquals(12, runner.getWeight());
        assertEquals(1, runner.getAge());
    }

    @Test
    public void testAddRecordToRunList(){
        int runListSize = runner.runList.size();
        runner.addRecordToRunList(mockRecord1);
        assertEquals(runListSize+1, runner.runList.size());
    }

    @Test
    public void testAddRecordToRunListWithUnavailableID(){
        int runListSize = runner.runList.size();
        runner.addRecordToRunList(mockRecord1);
        runner.addRecordToRunList(mockRecord2);
        Exception e = assertThrows(IllegalArgumentException.class, () -> { 
            runner.addRecordToRunList(mockRecord1);;
        });
        assertEquals("ID already exists", e.getMessage());
        assertEquals(runListSize+2, runner.runList.size());
    }


}
