

import org.junit.jupiter.api.*;

import se.kristin.FileStorage;
import se.kristin.Record;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class TestRecord {

    @BeforeEach
    public void setUp(){
        Record run = new Record(5.5, 300, LocalDate.of(2025, 01, 01));
    }

    @Test
    public void testRecordCreation(){
        Record run = new Record(4.2, 200, LocalDate.of(2024, 02, 13));
        assertEquals(run.getDistance(), 4.2);
        assertEquals(run.getTime(), 200);
        assertEquals(run.getDate(), LocalDate.of(2024, 02, 13));
    }

    @Test
    public void testRecordCreationWithoutDate(){
        Record run = new Record(4.0, 500);
        assertEquals(run.getDate(), LocalDate.now());
    }

   // @Disabled
    @Test
    public void testAvailableID(){
        FileStorage mockRecordFileStorage = new FileStorage();
       // mockRecordFileStorage = TestFileStorage.fileStorageMock;
     //   assertEquals(true, Record.AvailableID(mockRecordFileStorage, "7")); 
        
    }

    
    
}
