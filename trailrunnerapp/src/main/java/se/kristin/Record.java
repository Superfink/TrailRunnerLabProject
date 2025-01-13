package se.kristin;

import java.time.LocalDate;

public class Record {
    double distance;
    int time;
    LocalDate date;

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



// -------  Getters and setters --------

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
