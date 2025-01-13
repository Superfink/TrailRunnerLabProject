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
    

    @BeforeEach
    public void setUp(){
        fileStorageMock = mock(FileStorage.class);
    }

    @Test
    public void testCreateRecord(){
        Record record = new Record(0.5, 205);
        fileStorageMock.createRecord(null, 0, 0, null);
        


    }



    @Test
    public void testReadRecord(){
        Record mockRecord1 = new Record(4.5, 456);
        Record mockRecord2 = new Record(7.8, 800, LocalDate.of(2012, 12, 12));
        when(fileStorageMock.readRecord("1")).thenReturn(mockRecord1);
        when(fileStorageMock.readRecord("1")).thenReturn(mockRecord2);

        Record result1 = fileStorageMock.readRecord("1");
        Record result2 = fileStorageMock.readRecord("2");

        assertEquals(result1.getDistance(), 4.5);
        assertEquals(result1.getTime(), 456);
        assertEquals(result1.getDate(), LocalDate.now());

        assertEquals(result2.getDistance(), 7.8);
        assertEquals(result2.getTime(), 800);
        assertEquals(result2.getDate(), LocalDate.of(2012, 12, 12));
    }


    @Test
    public void testRecordNotFound() {
        // Konfigurera mocken att returnera null när readRecord anropas med ett ogiltigt ID
        when(fileStorageMock.readRecord("FinnsEj")).thenReturn(null);
        Record result = fileStorageMock.readRecord("FinnsEj");
        assertNull(result);
    }


 
 


    
}
