package se.kristin;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FileStorage {

    public void createRecord(String id, double distance, int time_seconds, LocalDate date) 
            /*throws IOException*/ {
       //TestRecord.fileStorageMock.add()
       
       
       
                // throw new UnsupportedOperationException();
    }

    public Record readRecord(String id) /*throws IOException*/ {

        Record record = new Record();
        return record;

        //throw new UnsupportedOperationException();
    }

    public List<String> getRecordIDs() {
        throw new UnsupportedOperationException();
    }
    
    public void deleteRecord(String id) throws IOException {
        throw new UnsupportedOperationException();
    }
}