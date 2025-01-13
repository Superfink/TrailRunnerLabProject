import org.junit.jupiter.api.*;
import se.kristin.*;
import se.kristin.Record;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFileStorage {
    protected FileStorage fileStorageMock;
    

    @BeforeEach
    public void setUp(){
        fileStorageMock = mock(FileStorage.class);
        
    }

    @Test
    public void testCreateRecord(){
        fileStorageMock.createRecord("6", 5.4, 500, LocalDate.now());
        verify(fileStorageMock, times(1)).createRecord("6", 5.4, 500, LocalDate.now());
    }


    @Test
    public void testGetRecordIDs(){
                
        List<String> mockList = new ArrayList<String>(Arrays.asList("1", "2")) ;
        when(fileStorageMock.getRecordIDs()).thenReturn(mockList);
        
        List<String> expected = mockList;
        List<String> actual = fileStorageMock.getRecordIDs();

        String[] expectedArray = expected.toArray(new String[0]);
        String[] actualArray = actual.toArray(new String[0]);
        
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testIDAlreadyExists(){
       List<String> mockList = new ArrayList<String>(Arrays.asList("1", "2", "3")) ;
        when(fileStorageMock.getRecordIDs()).thenReturn(mockList);

        List<String> result = fileStorageMock.getRecordIDs();
        //kolla om id redan finns


    }

    @Test
    public void testReadRecord(){
        Record mockRecord1 = new Record(4.5, 456);
        Record mockRecord2 = new Record(7.8, 800, LocalDate.of(2012, 12, 12));
        when(fileStorageMock.readRecord("1")).thenReturn(mockRecord1);
        when(fileStorageMock.readRecord("2")).thenReturn(mockRecord2);

        Record result1 = fileStorageMock.readRecord("1");
        Record result2 = fileStorageMock.readRecord("2");

        assertEquals(4.5, result1.getDistance() );
        assertEquals(456, result1.getTime());
        assertEquals(LocalDate.now(), result1.getDate());

        assertEquals(7.8, result2.getDistance());
        assertEquals(800, result2.getTime());
        assertEquals(LocalDate.of(2012, 12, 12), result2.getDate());
        
    }




    @Test
    public void testRecordNotFound() {
        // Konfigurera mocken att returnera null när readRecord anropas med ett ogiltigt ID
        when(fileStorageMock.readRecord("FinnsEj")).thenReturn(null);
        Record result = fileStorageMock.readRecord("FinnsEj");
        assertNull(result);
    }


 
 


    
}
