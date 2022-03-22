package za.co.cicd.util;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.Calendar;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateUtil {


    public static String getDayOfYear() {
        Calendar cal = Calendar.getInstance();
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        return String.valueOf(dayOfYear);
    }

}

