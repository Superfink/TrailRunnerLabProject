package se.kristin;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Calculations {
    
    
    
    public static double speedKmPerHour(double distance_km, int time_seconds){
        return oneDecimalFormatter(distance_km*3600/(time_seconds));
    }

    //Overloading
    public static double speedKmPerHour(Record record){
        return oneDecimalFormatter(record.getDistance()*3600/(record.getTime()));
    }

    public static double speedMinutesPerKm(double distance_km, int time_seconds){
        return oneDecimalFormatter(time_seconds/(distance_km * 60));
    }

    //Overloading
    public static double speedMinutesPerKm(Record record){
        return oneDecimalFormatter((record.getTime()/(record.getDistance() * 60)));
    }


    public static double totalDistance(List<Double> distanceList){
        double totalDistance = 0;
        for(int i = 0; i < distanceList.size(); i++){
            totalDistance = totalDistance + distanceList.get(i);
        }
        return totalDistance;
    }

    public static double avgDistanceAllRecords(List<Double> distanceList){
        return oneDecimalFormatter(totalDistance(distanceList)/distanceList.size());
    }

    public static LocalDate getDateOfLastRecord(List<LocalDate> dateList){
        return dateList.get(dateList.size()-1);
    }

    public static int daysBetween(LocalDate date1, LocalDate date2){
        return (int) Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }

    //Overloading
    public static int daysBetween(Record record1, Record record2){
        return daysBetween(record1.getDate(), record2.getDate());
    }

    public static int daysBetween(List<Record> list){
        List<LocalDate> dateList = new LinkedList<>();
        if (list.size() <=1) {
            return 0;
        }
        
        for (Record r : list) {
            dateList.add(r.getDate());
        }
        Collections.sort(dateList);
        return daysBetween(dateList.get(dateList.size()-1), dateList.get(dateList.size()-2));
    }

    public static int calculateNewFitnessScore(int fitnessScore, Record record, int daysSinceLastRecord){

        double newFitnessScore = 
        (double) fitnessScore + 
        record.getDistance() + 
        (speedKmPerHour(record) / speedMinutesPerKm(record)) - 
        (daysSinceLastRecord/2);

        if(newFitnessScore < 0){
            return 0;
        }

        return (int) newFitnessScore;
  
        /*formel: - Fitness Score (efter varje löptur), ej <0, endast heltal, Om första rundan är värdet 0
        X + Y + Z/A - B/2
        X - nuvarande fitness score
        Y - distans, km
        Z - medelhastighet, km/h
        A - kilometertid (min/km)
        B - Dagar sedan senaste löptur
        */
    }

    public static List<String> filterByDistanceOver(ArrayList<Record> list, double limit){
        List<String> returnList = new LinkedList<>();
        for (Record r : list) {
            if(r.getDistance() >= limit){
                returnList.add(r.getID());
            }
        }
        return  returnList;
    }

    public static double oneDecimalFormatter(double value){
        DecimalFormat format_oneDecimal = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)); //För att få punkt som skiletecken i stället för kommatecken
        return Double.valueOf(format_oneDecimal.format(value));
    }
}

