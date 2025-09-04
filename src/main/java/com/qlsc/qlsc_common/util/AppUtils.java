package com.qlsc.qlsc_common.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.TimeZone;

public class AppUtils {

    public static final TimeZone timezone = TimeZone.getTimeZone(ZoneId.of("Asia/Ho_Chi_Minh"));

    private AppUtils() {
        throw new IllegalStateException("AppUtils class");
    }

    public static String formatMethodName(String str) {
        str = formatName(str);
        str = str.substring(0, 1).toUpperCase() + str.substring(1);
        return str;
    }

    public static String formatName(String str) {
        String[] index = str.split("_");
        StringBuilder all = new StringBuilder();
        if (!str.toUpperCase().equalsIgnoreCase(str) && index.length == 1) {
            all = new StringBuilder(String.valueOf(index[0].charAt(0)).toUpperCase() + index[0].substring(1));
        } else {
            for (String s : index) {
                all.append(String.valueOf(s.charAt(0)).toUpperCase()).append(s.substring(1).toLowerCase());
            }
        }
        return all.toString();
    }


    public static int buildPartDate(Long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setTimeZone(timezone);
        String date = dateFormat.format(time);
        return Integer.parseInt(date);
    }


    public static int buildPartDate(Timestamp date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat.setTimeZone(timezone);
        String time = dateFormat.format(date);
        return Integer.parseInt(time);
    }

    public static int buildPartMonth(Long time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        dateFormat.setTimeZone(timezone);
        String date = dateFormat.format(time);
        return Integer.parseInt(date);
    }


    public static int buildPartMonth(Timestamp date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        dateFormat.setTimeZone(timezone);
        String time = dateFormat.format(date);
        return Integer.parseInt(time);
    }

    public static int buildPartYear(Long date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        dateFormat.setTimeZone(timezone);
        String time = dateFormat.format(date);
        return Integer.parseInt(time);
    }

    public static int buildPartYear(Timestamp date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        dateFormat.setTimeZone(timezone);
        String time = dateFormat.format(date);
        return Integer.parseInt(time);
    }

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isListNullOrEmpty(List<?> list) {
        return (list == null || list.isEmpty());
    }

    public static String convertLongToDateStr(long epochMillis) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                .withZone(ZoneId.systemDefault());
        return fmt.format(Instant.ofEpochMilli(epochMillis));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException("places < 0");
        return BigDecimal.valueOf(value)
                .setScale(places, RoundingMode.HALF_UP)   // HALF_UP = làm tròn 4 bỏ 5 lên
                .doubleValue();
    }

    public static int roundUpIfGreaterOrEqualToPointFive(double number) {
        int integerPart = (int) number;
        double fractional = number - integerPart;
        if (fractional >= 0.5) {
            return integerPart + 1;
        } else {
            return integerPart;
        }
    }
}
