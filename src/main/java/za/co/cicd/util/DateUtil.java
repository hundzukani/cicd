package za.co.cicd.util;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateUtil {

    public static final DateTimeFormatter DATE_TIME_FORMATTER_1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public static final DateTimeFormatter DATE_TIME_FORMATTER_2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final String INVALID_DAY = "Invalid Day";


    public static String getCurrentMonth() {
        return Month.of(LocalDate.now().getMonthValue()).name();
    }

    public static String getDayOfYear() {
        Calendar cal = Calendar.getInstance();
        int dayOfYear = cal.get(Calendar.DAY_OF_YEAR);
        return String.valueOf(dayOfYear);
    }

    public static String getDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return formatDay(dayOfMonth);
    }

    public static String getDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return formatDay(dayOfWeek);
    }

    public static String formatDay(int day) {
        String dayOfWeek = String.valueOf(day);
        return dayOfWeek.length() == 1 ? "0".concat(dayOfWeek) : dayOfWeek;
    }

    public static int getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDaysInMonth() {
        // Get the number of days in that month
        YearMonth yearMonth = YearMonth.of(getYear(), getLastMonth());
        return yearMonth.lengthOfMonth();
    }

    public static int getYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) + 1;
    }

    public static LocalDateTime getCurrentYearAndPreviousMonthAndFirstDayOfMonth() {
        return LocalDateTime.of(getYear(), getLastMonth(), 1, 0, 0, 0);
    }

    public static LocalDateTime getCurrentYearAndPreviousMonthAndLastDayOfMonth() {
        return LocalDateTime.of(getYear(), getLastMonth(), getDaysInMonth(), 0, 0, 0);
    }

    public static LocalDateTime of(int year, int month, int day) {
        return LocalDateTime.of(year, month, day, 0, 0, 0);
    }

    public static LocalDateTime from(String from) {
        LocalDateTime ldt = null;
        try {
            if (Objects.nonNull(from)) {
                from = trimDate(from);
                ldt = convert(from);
            }
        } catch (Exception e) {
            log.error("Failed To Convert Date.", e);
        }
        return ldt;
    }

    private static LocalDateTime convert(String from) {
        LocalDateTime ldt = null;
        if (from.contains("T")) {
            ldt = LocalDateTime.parse(from, DATE_TIME_FORMATTER_1);
        } else {
            ldt = LocalDateTime.parse(from, DATE_TIME_FORMATTER_2);
        }
        return ldt;
    }

    private static String trimDate(String from) {
        if (from.contains(".")) {
            from = from.substring(0, from.indexOf("."));
        }
        return from;
    }

    public static String convertLocalDateTimeToDateComplaintFormat(LocalDateTime ldt) {
        return ldt.getYear() + "-" + ldt.getMonth().getValue() + "-" + ldt.getDayOfMonth() + " " + ldt.getHour() + ":" + ldt.getMinute() + ":" + ldt.getSecond();
    }

    public static long getNoOfHoursSince(LocalDateTime from) {
        LocalDateTime now = LocalDateTime.now();
        return from.until(now, ChronoUnit.HOURS);
    }

}

