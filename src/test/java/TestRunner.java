import org.junit.jupiter.api.*;
import se.kristin.*;
import se.kristin.Record;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;


public class TestRunner {

    Record mockRecord1;
    Record mockRecord2;
    Record mockRecord3;
    Runner runner;
    

    @BeforeEach
    public void setUp(){
        runner = new Runner(176, 82, 42);
        mockRecord1 = new Record("ID1", 5.2, 123);
        mockRecord2 = new Record("ID2", 5.2, 123);
        mockRecord3 = new Record("ID3", 4.2, 234);
        runner.runList.add(mockRecord1);
        runner.runList.add(mockRecord2);
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



 //Testa att record kan skapas med giltigt ID   
    @Test
    public void testRecordCreationWithValidID(){
        int runListSize = runner.runList.size();
        runner.createAndAddRecord("ID25", 23, 34, LocalDate.of(2025,01,01));
        assertEquals(runListSize+1, runner.runList.size());

    }

    //Skapa Test: Test create record without date

    @Test
    public void testRecordCreationWithInvalidID(){
        int runListSize = runner.runList.size();
        Exception e = assertThrows(IllegalArgumentException.class, () -> { 
            runner.createAndAddRecord("ID1", 2, 3, LocalDate.of(2025,01,01));
        });
        assertEquals("ID already exists. Record not created", e.getMessage());
        assertEquals(runListSize, runner.runList.size());
    }

//Test: Beräkna fitness score automatiskt vid skapande av löprunda. Utgår från att listan är sorterad i datumordning


//Test: Beräkna fitness score automatiskt vid skapande av löprunda. Listan är INTE sorterad i datumordning

//Test: Filtrera på tid, returnera lista med ID





}
