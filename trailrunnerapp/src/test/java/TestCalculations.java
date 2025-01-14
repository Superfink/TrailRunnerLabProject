import org.junit.jupiter.api.*;

import se.kristin.Calculations;
import se.kristin.FileStorage;
import se.kristin.Record;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class TestCalculations {


    @Test
    public void testAvgSpeed(){
        assertEquals(12.0, Calculations.avgSpeedKmPerHour(6.0, 1800));
        assertEquals(4.8, Calculations.avgSpeedKmPerHour(4.3, 3232));
    }

    @Test
    public void testKmSpeed(){
        assertEquals(8.0, Calculations.speedMinutesPerKm(5.0, (40*60)));
        assertEquals(9.1, Calculations.speedMinutesPerKm(8.3, 4550));
        assertEquals(9.2, Calculations.speedMinutesPerKm(8.3, 4567));

    }
}
