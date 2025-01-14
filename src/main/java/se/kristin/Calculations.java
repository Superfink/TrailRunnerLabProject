package se.kristin;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;

public class Calculations {
    
    
    
    public static double avgSpeedKmPerHour(double distance_km, int time_seconds){

        DecimalFormat format_oneDecimal = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)); //För att få punkt som skiletecken i stället för kommatecken
        String avgSpeedString = format_oneDecimal.format((distance_km*3600/(time_seconds)));
        return Double.valueOf(avgSpeedString);

    }

    public static double speedMinutesPerKm(double distance_km, int time_seconds){

        DecimalFormat format_oneDecimal = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)); //För att få punkt som skiletecken i stället för kommatecken
        String speedString = format_oneDecimal.format((time_seconds/(distance_km * 60)));
        return Double.valueOf(speedString);
    }
    
    public static double totalDistance(List<Double> distanceList){
        double totalDistance = 0;
        for(int i = 0; i < distanceList.size(); i++){
            totalDistance = totalDistance + distanceList.get(i);
        }
        return totalDistance;
    }

    public static double avgDistanceAllRecords(List<Double> distanceList){

        DecimalFormat format_oneDecimal = new DecimalFormat("#.#", new DecimalFormatSymbols(Locale.US)); //För att få punkt som skiletecken i stället för kommatecken
        
        double totalDistance = totalDistance(distanceList);

        double avgDistance = totalDistance / distanceList.size();
        String speedString = format_oneDecimal.format(avgDistance);
        return Double.valueOf(speedString);
    }

    public static LocalDate getDateOfLastRecord(List<LocalDate> dateList){
        return dateList.get(dateList.size()-1);
    }

    public static int daysBetweenTwoDates(LocalDate date1, LocalDate date2){
        return (int) Math.abs(ChronoUnit.DAYS.between(date1, date2));
    }

    public static int daysBetweenRecords(Record record1, Record record2){
        return daysBetweenTwoDates(record1.getDate(), record2.getDate());
    }


}

