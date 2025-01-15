

import org.junit.jupiter.api.*;
import se.kristin.Record;
import se.kristin.Runner;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestRecord {

    Record mockRecord1;
    public ArrayList<Record> mockRecordArrayList;
    ArrayList<Record> mockRecordListCopy;
    

    Record mockRecord10;
    Record mockRecord11;
    Record mockRecord12;
    Record mockRecord13;

    Runner runner;

    @BeforeEach
    public void setUp(){
        mockRecord1 = new Record("ID22", 5.5, 300, LocalDate.of(2025, 01, 01));

        mockRecord10 = new Record("ID1", 1.1, 1111, LocalDate.of(2025,01,01));
        mockRecord11 = new Record("ID2", 2.2, 2222, LocalDate.of(2025,01,02));
        mockRecord12 = new Record("ID3", 3.3, 3333, LocalDate.of(2025,01,03));
        mockRecord13 = new Record("ID4", 4.4, 4444, LocalDate.of(2025,01,04));

        mockRecordArrayList = new ArrayList<>();
        mockRecordArrayList.add(mockRecord10);
        mockRecordArrayList.add(mockRecord11);
        mockRecordArrayList.add(mockRecord12);
        mockRecordArrayList.add(mockRecord13);
        mockRecordArrayList.add(mockRecord1);

        mockRecordListCopy= new ArrayList<>();
        mockRecordListCopy.addAll(mockRecordArrayList);

        runner = new Runner(123, 45, 67);
    }


    @Test
    public void testFullRecordCreation(){
        Record record = new Record("ID24", 1.2, 123, LocalDate.of(2025, 01, 10));
        assertEquals("ID24", record.getID());
        assertEquals(1.2, record.getDistance());
        assertEquals(123, record.getTime());
        assertEquals(LocalDate.of(2025, 01,10), record.getDate());
    }


    @Test
    public void testRecordCreationWithoutDate(){
        Record run = new Record("ID", 4.0, 500);
        assertEquals(LocalDate.now(), run.getDate());
    }

    
    
    @Test
    public void testAvgSpeedKmPerHourIsAutomaticallyCalculatedAndAddedToRecord(){
        Record record = new Record("HF", 7.0, 3600);
        assertEquals(7.0, record.getAvgSpeed_kmPerHour());
    }

    @Test
    public void testAvgSpeedMinPerKmIsAutomaticallyCalculatedAndAddedToRecord(){
        Record record = new Record("HF", 7.0, 3600);
        assertEquals(8.6, record.getAvgSpeed_minPerKm(), 0.1);
    }

    @Test
    public void testIDAlreadyExists_staticMethod(){
        boolean expectedTrue = Record.IDAlreadyExists(mockRecordArrayList, "ID2");
        boolean expectedFalse = Record.IDAlreadyExists(mockRecordArrayList, "NonExistentID");

        assertEquals(true, expectedTrue);
        assertEquals(false, expectedFalse);
    }


    @Test
    public void testPrintRecordInfo_forAnyRecord(){
        Record.printRecordInfo(mockRecord1);
    }

    @Test
    public void testPrintRecordInfo_forThisRecord(){
        mockRecord1.printRecordInfo();
    }

    @Test
    public void testGetRecordByID(){
        try {Record.getRecordByID(mockRecordArrayList, "ID2");} catch (Exception e) {}
        assertEquals(mockRecord11, mockRecordArrayList.get(1));
        assertEquals("ID2", mockRecord11.getID());
        assertEquals(2.2, mockRecord11.getDistance());
        
        try {Record.getRecordByID(mockRecordArrayList, "ID4");} catch (Exception e) {}
        assertEquals(mockRecord13, mockRecordArrayList.get(3));
        assertEquals("ID4", mockRecord13.getID());
        assertEquals(4444, mockRecord13.getTime());
    
    }

    @Test 
    public void testExceptionWhenTryingToGetRecordWithNonExistingID(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> { 
            Record.getRecordByID(mockRecordArrayList, "ID46");
        });
        assertEquals("Record not found", e.getMessage());
    }    


    @Test
    public void testDeleteRecordByID(){
        try {Record.deleteRecordByID(mockRecordArrayList, "ID2");} catch (Exception e) {}
        mockRecordListCopy.remove(1);
        assertEquals(mockRecordListCopy, mockRecordArrayList);
        try {Record.deleteRecordByID(mockRecordArrayList, "ID3");} catch (Exception e) {}
        mockRecordListCopy.remove(1);
        assertEquals(mockRecordListCopy, mockRecordArrayList);
    }


    @Test
    public void testRecordIsNotDeletedWhenWrongIDIsEntered(){
        try {Record.deleteRecordByID(mockRecordArrayList, "ID323");} catch (IllegalArgumentException e) {}
        assertEquals(mockRecordListCopy, mockRecordArrayList);
    }

    @Test 
    public void testExceptionWhenTryingToDeleteRecordWithNonExistingID(){
        Exception e = assertThrows(IllegalArgumentException.class, () -> { 
            Record.deleteRecordByID(mockRecordArrayList, "ID456");
        });
        assertEquals("Record not found", e.getMessage());
    }    
    
}
