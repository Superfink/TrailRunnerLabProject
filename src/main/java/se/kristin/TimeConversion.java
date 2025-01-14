package se.kristin;

public class TimeConversion {
    
    
    public static int convertHHMMSStoSeconds(int hours, int minutes, int seconds){
        int hourSeconds = convertHoursToSeconds(hours);
        int minuteSeconds = convertMinutesToSeconds(minutes);
        return hourSeconds + minuteSeconds + seconds;

    }
    
    public static int convertHoursToSeconds(int hours){
        return hours * 3600;
    }

    public static int convertMinutesToSeconds(int minutes){
        return minutes * 60;
    }




    public static int convertSecondsToHours(int seconds){
        return seconds / 3600;
    }

    public static int convertSecondsToMinutes(int seconds){
        int minutes = seconds / 60;
        while(minutes > 60){
            minutes = minutes - 60;
        }
        return minutes;
    }

    public static int convertSecondsToRemainingSeconds(int seconds){
        int remainingSeconds = seconds % 60; //Filter minutes
        return remainingSeconds;
    }
}
