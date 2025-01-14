

import se.kristin.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestTimeConversion {
        @Test
    public void testConvertTimeToSeconds(){
        assertEquals(TimeConversion.convertHoursToSeconds(1), 3600);
        assertEquals(TimeConversion.convertMinutesToSeconds(30), 1800);
    }

    @Test
    public void testConvertSecondsToTime(){
        assertEquals(TimeConversion.convertSecondsToHours(4502), 1);  //4502s = 1h 15m 2s
        assertEquals(TimeConversion.convertSecondsToMinutes(4502), 15);
        assertEquals(TimeConversion.convertSecondsToRemainingSeconds(4502), 2);

        assertEquals(TimeConversion.convertSecondsToHours(1234), 0);  //1234s = 1h 15m 2s
        assertEquals(TimeConversion.convertSecondsToMinutes(1234), 20);
        assertEquals(TimeConversion.convertSecondsToRemainingSeconds(1234), 34);

        assertEquals(TimeConversion.convertSecondsToHours(89000), 24);  //89000s = 24h 43m 20s
        assertEquals(TimeConversion.convertSecondsToMinutes(89000), 43);
        assertEquals(TimeConversion.convertSecondsToRemainingSeconds(89000), 20 );
    }

    @Test
    public void testHHMMSStoSeconds(){
        assertEquals(TimeConversion.convertHoursToSeconds(2), 7200);
        assertEquals(TimeConversion.convertMinutesToSeconds(4), 240);
        assertEquals(TimeConversion.convertHHMMSStoSeconds(1, 15, 2), 4502);
    }

}

