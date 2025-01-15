package se.kristin;

import java.time.LocalDate;
import java.util.*;

public class Record {

    String ID;
    double distance;
    int time;
    LocalDate date;
    FileStorage fileStorage;
    double avgSpeed_kmPerHour;
    double avgSpeed_minPerKm;


    public Record(){
        this.distance = 0;
        this.time = 0;
        this.date = LocalDate.now();
    }

    public Record(double distance, int time){
        this.distance = distance;
        this.time = time;
        this.date = LocalDate.now();
    }

    public Record(double distance, int time, LocalDate date){
        this.distance = distance;
        this.time = time;
        this.date = date;
    }

    public Record(String ID, double distance, int time) {

        this.ID = ID;
        this.distance = distance;
        this.time = time;
        this.date = LocalDate.now();
    }
    
    public Record(String ID, double distance, int time, LocalDate date) {
        
        this.ID = ID;
        this.distance = distance;
        this.time = time;
        this.date = date;
    }



// ---- Methods -----





    public static boolean IDAlreadyExists(ArrayList<Record> list, String ID)  {
        for (Record r : list) {
            if(r.getID() == ID) {
                return true;
            }
            
        }
        System.out.println("ID already exists");
        return false;
    }

    public void printRecordInfo(){
        printRecordInfo(this);
    }

    //Overloading
    public static void printRecordInfo(Record record){
        System.out.println("Record ID: " + record.getID());
        System.out.println("Record Distance: " + record.getDistance());
        System.out.println("Record Time: " + record.getTime());
        System.out.println("Record Date: " + record.getDate());
    }

    public static Record getRecordByID(ArrayList<Record> list, String ID) throws IllegalArgumentException {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getID() == ID){
                return list.get(i);
            }
        }
        throw new IllegalArgumentException("Record not found");
    }

    public static void deleteRecordByID(ArrayList<Record> list, String ID) throws IllegalArgumentException {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getID() == ID){
                list.remove(i);
                continue;
            }
        }
        throw new IllegalArgumentException("Record not found");
    }



// -------  Getters and setters --------


    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
