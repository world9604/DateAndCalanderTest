import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.zone.ZoneRules;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class OldJdkDateTest {

    @Test
    public void shouldGetUTCTime() {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(utc);
        SimpleDateFormat formatter = new SimpleDateFormat ( "yyyy.MM.dd HH:mm");
        formatter.setTimeZone(utc);
        String theDay = formatter.format(calendar.getTime());
        assertThat(theDay).isEqualTo("2020.07.26 22:44");
    }

    @Test
    public void shouldGetSeoulTime() {
        ZoneId seoul = ZoneId.of("Asia/Seoul");
        ZonedDateTime theTime = ZonedDateTime.of(2020, 7, 26, 23, 9, 0, 0, seoul);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        assertThat(theTime.format(formatter)).isEqualTo("2020.07.26 23:09");
    }
}