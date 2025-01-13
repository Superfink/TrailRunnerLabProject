import org.junit.jupiter.api.*;
import se.kristin.*;
import se.kristin.Record;

import java.time.LocalDate;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFileStorage {
    private FileStorage fileStorageMock;
    private RecordHandler recordHandler;

    @BeforeEach
    public void setUp(){
        fileStorageMock = mock(FileStorage.class);
    }

    @Test
    public void testCreateRecord(){

    }



    @Test
    public void testReadRecord(){
        Record mockRecord = new Record(4.5, 456);
        when(fileStorageMock.readRecord("1")).thenReturn(mockRecord);

        Record result = fileStorageMock.readRecord("1");

        assertEquals(result.getDistance(), 4.5);
        assertEquals(result.getTime(), 456);
        assertEquals(result.getDate(), LocalDate.now());
    }


    @Test
    public void testRecordNotFound() {
        // Konfigurera mocken att returnera null när readRecord anropas med ett ogiltigt ID
        when(fileStorageMock.readRecord("FinnsEj")).thenReturn(null);
        Record result = fileStorageMock.readRecord("FinnsEj");
        assertNull(result);
    }

    @Test

 
 


    
}
