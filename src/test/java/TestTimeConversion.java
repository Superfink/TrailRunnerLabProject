

import se.kristin.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestTimeConversion {
    @Test
    public void testConvertTimeToSeconds(){
        assertEquals(3600, TimeConversion.convertHoursToSeconds(1));
        assertEquals(1800, TimeConversion.convertMinutesToSeconds(30));
    }

    @Test
    public void testConvertSecondsToTime(){
        assertEquals(1, TimeConversion.convertSecondsToHours(4502));  //4502s = 1h 15m 2s
        assertEquals(15, TimeConversion.convertSecondsToMinutes(4502));
        assertEquals(2, TimeConversion.convertSecondsToRemainingSeconds(4502));

        assertEquals(0, TimeConversion.convertSecondsToHours(1234));  //1234s = 1h 15m 2s
        assertEquals(20, TimeConversion.convertSecondsToMinutes(1234));
        assertEquals(34, TimeConversion.convertSecondsToRemainingSeconds(1234));

        assertEquals(24, TimeConversion.convertSecondsToHours(89000));  //89000s = 24h 43m 20s
        assertEquals(43, TimeConversion.convertSecondsToMinutes(89000));
        assertEquals(20, TimeConversion.convertSecondsToRemainingSeconds(89000));
    }

    @Test
    public void testHHMMSStoSeconds(){
        assertEquals(7200, TimeConversion.convertHoursToSeconds(2));
        assertEquals(240, TimeConversion.convertMinutesToSeconds(4));
        assertEquals(4502, TimeConversion.convertHHMMSStoSeconds(1, 15, 2));
    }

}

