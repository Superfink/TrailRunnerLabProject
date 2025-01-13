package se.kristin;

public class Runner {

    int height;
    int weight;
    int age;

    public Runner(){
        this.height = 0;
        this.weight = 0;
        this.age = 0;
    }

    public Runner(int height, int weight, int age){
        this.height = height;
        this.weight = weight;
        this.age = age;
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

}
