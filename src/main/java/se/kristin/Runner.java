package se.kristin;

import java.time.LocalDate;
import java.util.ArrayList;

public class Runner {

    private int height;
    private int weight;
    private int age;
    private int fitnessScore;
    public ArrayList<Record> runList = new ArrayList<>();


    public Runner(){
        this.height = 0;
        this.weight = 0;
        this.age = 0;
        this.fitnessScore = 0;
    }

    public Runner(int height, int weight, int age){
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.fitnessScore = 0;
    }

// --- Methods ---------


    public void createAndAddRecord(String ID, double distance, int time, LocalDate date) throws IllegalArgumentException {
            if (Record.IDAlreadyExists(runList, ID)){
                throw new IllegalArgumentException("ID already exists. Record not created");
            }
            Record r = new Record(ID, distance, time, date);
            this.runList.add(r);

    }


/// ---------- Getters and setters ---------

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFitnessScore() {
        return fitnessScore;
    }

    public void setFitnessScore(int fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

}
