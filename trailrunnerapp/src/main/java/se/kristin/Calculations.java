package se.kristin;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
        

}
