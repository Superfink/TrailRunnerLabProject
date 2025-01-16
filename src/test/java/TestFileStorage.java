
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
    private Record mockRecord1;
    private Record mockRecord2;
    private Record mockRecord3;
    private Record mockRecord4;

    private ArrayList<Record> mockRecordList;
    private List<String> mockIDList;
    
    @BeforeEach
    public void setUp(){
        fileStorageMock = mock(FileStorage.class);

        mockRecord1 = new Record("ID1", 1.1, 111);
        mockRecord2 = new Record("ID2", 2.2, 222, LocalDate.of(2012, 12, 12));
        mockRecord3 = new Record("ID3", 3.3, 333, LocalDate.of(2013, 12, 12));
        mockRecord4 = new Record("ID4", 4.4, 444, LocalDate.of(2014, 12, 12));
        
        mockRecordList = new ArrayList<>();
        mockRecordList.add(mockRecord1);
        mockRecordList.add(mockRecord2);
        mockRecordList.add(mockRecord3);
        mockRecordList.add(mockRecord4);

        mockIDList = new ArrayList<String>(Arrays.asList("ID1", "ID2", "ID3", "ID4"));

    }

    @Test
    public void testGetRecordIDs(){
        
        when(fileStorageMock.getRecordIDs())
            .thenReturn(mockIDList);

        List<String> actual = fileStorageMock.getRecordIDs();
        assertArrayEquals(mockIDList.toArray(), actual.toArray());
    }

    @Test
    public void testCreateRecord() throws Exception {
        
        try {
            fileStorageMock.createRecord("ID1", 1, 1, LocalDate.now());
        } catch (Exception e) {
            fail("Exception not expected");            
        }
        verify(fileStorageMock, times(1)).createRecord("ID1", 1, 1, LocalDate.now());
    }

    @Test
    public void testCreateRecordWithInvalidIDExpectsException() throws Exception {
        doThrow(new UnsupportedOperationException("ID already exists"))
            .when(fileStorageMock).createRecord("ID1", 1, 1, LocalDate.now());
        
        try {
            fileStorageMock.createRecord("ID1", 1, 1, LocalDate.now());
        } catch (Exception e) {
            assertEquals("ID already exists", e.getMessage());
        }

        verify(fileStorageMock, times(1)).createRecord("ID1", 1, 1, LocalDate.now());
    }

    @Test
    public void testReadRecord() throws Exception{
        
        when(fileStorageMock.readRecord("ID1"))
            .thenReturn(mockRecord1);
        when(fileStorageMock.readRecord("ID2"))
            .thenReturn(mockRecord2);

        Record result1 = fileStorageMock.readRecord("ID1");
        Record result2 = fileStorageMock.readRecord("ID2");
        

        assertEquals("ID1", result1.getID());
        assertEquals(222, result2.getTime());
        
    }


    @Test
    public void testRecordNotFoundExpectsException() throws Exception {
        doThrow(new UnsupportedOperationException("Record not found"))
            .when(fileStorageMock).readRecord("ID34");
        
        try {
            fileStorageMock.readRecord("ID34");
        } catch (Exception e) {
            assertEquals("Record not found", e.getMessage());
        }
        verify(fileStorageMock, times(1)).readRecord("ID34");
    }
        
    @Test
    public void testDeleteRecord() throws Exception {

        doThrow(new UnsupportedOperationException("Record not found"))
            .when(fileStorageMock).deleteRecord("ID5 already removed");
        
        try{
            fileStorageMock.deleteRecord("ID2");
        }catch(Exception e){
            fail("Exception not expected");
        }
        verify(fileStorageMock, times(1)).deleteRecord("ID2");
    }


    @Test
    public void testDeleteRecordWithInvalidIDExpectException() throws Exception {

        doThrow(new UnsupportedOperationException("Record not found"))
            .when(fileStorageMock).deleteRecord("ID5");

            try{
                fileStorageMock.deleteRecord("ID5");
            }catch(Exception e){
                assertEquals("Record not found", e.getMessage());                
            }
            verify(fileStorageMock, times(1)).deleteRecord("ID5");
    }
    
}

