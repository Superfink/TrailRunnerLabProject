

import se.kristin.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestTimeConversion {

    @Test
    public void testHHMMSStoSeconds(){
        assertEquals(4502, TimeConversion.convertHHMMSStoSeconds(1, 15, 2));
    }

    @Test
    public void testConvertHoursToSeconds(){
        assertEquals(7200, TimeConversion.convertHoursToSeconds(2));
    }

    @Test
    public void testConvertMinutesToSeconds(){
        assertEquals(240, TimeConversion.convertMinutesToSeconds(4));
    }

    @Test
    public void testConvertSecondsToTime(){
        assertEquals(1, TimeConversion.convertSecondsToHours(4502));  //4502s = 1h 15m 2s
        assertEquals(15, TimeConversion.convertSecondsToMinutesExcludingHours(4502));
        assertEquals(2, TimeConversion.convertSecondsExclutingMinutesAndHours(4502));

        assertEquals(0, TimeConversion.convertSecondsToHours(1234));  //1234s = 0h 20m 34s
        assertEquals(20, TimeConversion.convertSecondsToMinutesExcludingHours(1234));
        assertEquals(34, TimeConversion.convertSecondsExclutingMinutesAndHours(1234));

        assertEquals(24, TimeConversion.convertSecondsToHours(89000));  //89000s = 24h 43m 20s
        assertEquals(43, TimeConversion.convertSecondsToMinutesExcludingHours(89000));
        assertEquals(20, TimeConversion.convertSecondsExclutingMinutesAndHours(89000));
    }


}
