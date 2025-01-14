

import org.junit.jupiter.api.*;

import se.kristin.FileStorage;
import se.kristin.Record;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class TestRecord {

    @BeforeEach
    public void setUp(){
        //Record run = new Record(5.5, 300, LocalDate.of(2025, 01, 01));
    }

    @Test
    public void testEmptyRecordCreation(){
        Record record = new Record();
        assertEquals(0, record.getDistance());
        assertEquals(0, record.getDistance());
        assertEquals(LocalDate.now(), record.getDate());
    }

    @Test
    public void testRecordCreation(){
        Record record = new Record(4.2, 200, LocalDate.of(2024, 02, 13));
        assertEquals(4.2, record.getDistance());
        assertEquals(200, record.getTime());
        assertEquals(LocalDate.of(2024, 02, 13), record.getDate());
    }

    @Test
    public void testRecordCreationWithoutDate(){
        Record run = new Record(4.0, 500);
        assertEquals(LocalDate.now(), run.getDate());
    }

   // @Disabled
    @Test
    public void testAvailableID(){
        FileStorage mockRecordFileStorage = new FileStorage();
       // mockRecordFileStorage = TestFileStorage.fileStorageMock;
     //   assertEquals(true, Record.AvailableID(mockRecordFileStorage, "7")); 
        
    }

    
    
}
