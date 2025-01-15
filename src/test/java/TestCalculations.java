import org.junit.jupiter.api.*;
import se.kristin.Calculations;
import se.kristin.Record;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCalculations {

    private List<Double> mockDistanceArray1;
    private List<Double> mockDistanceArray2;
    
    private LocalDate mockDate1;
    private LocalDate mockDate2;
    private LocalDate mockDate3;

    Record mockRecord1;
    Record mockRecord2;
    Record mockRecord3;
    Record mockRecord4;
    Record mockRecord5;
    Record mockRecord6;
    Record mockRecord7;
    Record mockRecord8;
    Record mockRecord9;
    Record mockRecord10;
    Record mockRecord11;
    Record mockRecord12;
    Record mockRecord13;

    List<LocalDate> mockDateList;

    ArrayList<Record> mockRecordList;



    @BeforeEach
    public void setUp(){
        mockDistanceArray1 = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        mockDistanceArray2 = Arrays.asList(3.5, 3.5, 5.7, 12.5);
        
        mockDate1 = LocalDate.of(2024, 12, 2);
        mockDate2 = LocalDate.of(2024, 12, 31);
        mockDate3 = LocalDate.of(2025, 1, 5);
    
        mockRecord1 = new Record(5.5, 2345, LocalDate.of(2025,01,01));
        mockRecord2 = new Record(5.5, 2345, LocalDate.of(2024,01,01));
        mockRecord3 = new Record(5.5, 2345, LocalDate.of(2024,06,01));
        mockRecord4 = new Record(6.0, 1800);
        mockRecord5 = new Record(4.3, 3232);
        mockRecord6 = new Record(5.0, 2400);
        mockRecord7 = new Record(8.3, 4550);
        mockRecord8 = new Record(8.3, 4567);
        mockRecord9 = new Record(3.5, 5432);

        mockRecord10 = new Record("ID1", 1.1, 1111, LocalDate.of(2025,01,01));
        mockRecord11 = new Record("ID2", 2.2, 2222, LocalDate.of(2025,01,02));
        mockRecord12 = new Record("ID3", 3.3, 3333, LocalDate.of(2025,01,03));
        mockRecord13 = new Record("ID4", 4.4, 4444, LocalDate.of(2025,01,04));

        mockDateList = Arrays.asList(LocalDate.of(2025, 01, 02), LocalDate.of(2025,01,03), LocalDate.of(2025,01,04), LocalDate.of(2025,01,06));

        mockRecordList = new ArrayList<>();
        mockRecordList.add(mockRecord10);
        mockRecordList.add(mockRecord11);
        mockRecordList.add(mockRecord12);
        mockRecordList.add(mockRecord13);

          
    }


    @Test
    public void testAvgSpeedKmPerHour_forDistanceAndTime(){

        assertEquals(12.0, Calculations.avgSpeedKmPerHour(6.0, 1800));
        assertEquals(4.8, Calculations.avgSpeedKmPerHour(4.3, 3232));
    }

    @Test
    public void testAvgSpeedKmPerHour_forRecord(){

        assertEquals(12.0, Calculations.avgSpeedKmPerHour(mockRecord4));
        assertEquals(4.8, Calculations.avgSpeedKmPerHour(mockRecord5));
    }

    @Test
    public void testSpeedMinutesPerKm_forDistanceAndTime(){

        assertEquals(8.0, Calculations.speedMinutesPerKm(mockRecord6), 0.1);
        assertEquals(9.1, Calculations.speedMinutesPerKm(mockRecord7), 0.1);
        assertEquals(9.1, Calculations.speedMinutesPerKm(mockRecord8), 0.1);
    }

    @Test
    public void testSpeedMinutesPerKm_forRecord(){

        assertEquals(8.0, Calculations.speedMinutesPerKm(5.0, (40*60)), 0.1);
        assertEquals(9.1, Calculations.speedMinutesPerKm(8.3, 4550), 0.1);
        assertEquals(9.1, Calculations.speedMinutesPerKm(8.3, 4567),0.1);
    }


    @Test
    public void testTotalDistance(){

        assertEquals(15.0, Calculations.totalDistance(mockDistanceArray1));
        assertEquals(25.2, Calculations.totalDistance(mockDistanceArray2));
    }

    @Test
    public void testAvgDistanceAllRecords(){

        assertEquals(3.0, Calculations.avgDistanceAllRecords(mockDistanceArray1), 0.1);
        assertEquals(6.3, Calculations.avgDistanceAllRecords(mockDistanceArray2), 0.1);
    }

    @Test
    public void testGetDateOfPreviousRecord(){

        assertEquals(LocalDate.of(2025,01,06), Calculations.getDateOfLastRecord(mockDateList));
    }

    @Test
    public void testDaysBetween_TwoDates(){

        assertEquals(34, Calculations.daysBetween(mockDate1, mockDate3));
        assertEquals(5, Calculations.daysBetween(mockDate2, mockDate3));
        
    }

    @Test
    public void testDaysBetween_Records(){

        assertEquals(366, Calculations.daysBetween(mockRecord1, mockRecord2));
        assertEquals(152, Calculations.daysBetween(mockRecord2, mockRecord3));
    }

    @Test
    public void testOnlyPositiveNumbersShouldBeReturnedBetweenDates(){
        assertEquals(34, Calculations.daysBetween(mockDate3, mockDate1));
        assertEquals(152, Calculations.daysBetween(mockRecord3, mockRecord2));
    }


    @Test
    public void testCalculateNewFitnessScore(){
        
        assertEquals(5, Calculations.calculateNewFitnessScore(0, mockRecord1, 3));
        assertEquals(2, Calculations.calculateNewFitnessScore(0, mockRecord9, 3));
        assertEquals(4, Calculations.calculateNewFitnessScore(3, mockRecord9, 5));
                
    }

    @Test
    public void testIfFitnessScoreIsNegativeThen0ShouldBeReturned(){
        assertEquals(0, Calculations.calculateNewFitnessScore(0, mockRecord9, 500));;
    }

    @Test
    public void testOneDecimalFormatterShouldReturnDoubleWithOneDecimal(){
        assertEquals(7.7, Calculations.oneDecimalFormatter(7.67676767));
    }


}
