import org.junit.jupiter.api.*;

import net.bytebuddy.asm.Advice.Local;
import se.kristin.Calculations;
import se.kristin.FileStorage;
import se.kristin.Record;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCalculations {


    @Test
    public void testAvgSpeed(){
        assertEquals(12.0, Calculations.avgSpeedKmPerHour(6.0, 1800));
        assertEquals(4.8, Calculations.avgSpeedKmPerHour(4.3, 3232));
    }

    @Test
    public void testKmSpeed(){
        assertEquals(8.0, Calculations.speedMinutesPerKm(5.0, (40*60)), 0.1);
        assertEquals(9.1, Calculations.speedMinutesPerKm(8.3, 4550), 0.1);
        assertEquals(9.1, Calculations.speedMinutesPerKm(8.3, 4567),0.1);
    }

    @Test
    public void testTotalDistance(){
        List<Double> mockDistanceArray1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> mockDistanceArray2 = Arrays.asList(3.5, 3.5, 5.7, 12.5);
  
        assertEquals(15.0, Calculations.totalDistance(mockDistanceArray1));
        assertEquals(25.2, Calculations.totalDistance(mockDistanceArray2));
    }

    @Test
    public void testAvgDistanceAllRecords(){
        List<Double> mockDistanceArray1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> mockDistanceArray2 = Arrays.asList(3.5, 2.2, 8.3, 15.1);
       
        assertEquals(3.0, Calculations.avgDistanceAllRecords(mockDistanceArray1), 0.1);
        assertEquals(7.3, Calculations.avgDistanceAllRecords(mockDistanceArray2), 0.1);
    }

    @Test
    public void testGetDateOfPreviousRecord(){
        List<LocalDate> dateList = Arrays.asList(LocalDate.of(2025, 01, 02), LocalDate.of(2025,01,03), LocalDate.of(2025,01,04), LocalDate.of(2025,01,06));
        assertEquals(LocalDate.of(2025,01,06), Calculations.getDateOfLastRecord(dateList));
    }

    @Test
    public void testDaysBetweenTwoDates(){
        LocalDate mockDate1 = LocalDate.of(2024, 12, 2);
        LocalDate mockDate2 = LocalDate.of(2024, 12, 31);
        LocalDate mockDate3 = LocalDate.of(2025, 1, 5);

        assertEquals(34, Calculations.daysBetweenTwoDates(mockDate1, mockDate3));
        assertEquals(5, Calculations.daysBetweenTwoDates(mockDate2, mockDate3));
        assertEquals(5, Calculations.daysBetweenTwoDates(mockDate3, mockDate2));
    }

    @Test
    public static void testDaysBetweenRecords(){
        Record mockRecord1 = new Record(5.5, 2345, LocalDate.of(2025,01,01));
        Record mockRecord2 = new Record(5.5, 2345, LocalDate.of(2024,01,01));
        Record mockRecord3 = new Record(5.5, 2345, LocalDate.of(2024,06,01));

        assertEquals(365, Calculations.daysBetweenRecords(mockRecord1, mockRecord2));
    }
}
