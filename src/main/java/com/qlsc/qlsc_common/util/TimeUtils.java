package com.qlsc.qlsc_common.util;

import java.time.*;

public class TimeUtils {
    private static final ZoneId zone = ZoneId.of("GMT+7");
    // Hàm lấy mốc 0h00p00s của ngày
    public static long getStartOfDay(long epochMilli) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        LocalDate date = instant.atZone(zone).toLocalDate();
        ZonedDateTime startOfDay = date.atStartOfDay(zone);
        return startOfDay.toInstant().toEpochMilli();
    }

    // Hàm lấy mốc 23h59p59s của ngày
    public static long getEndOfDay(long epochMilli) {
        Instant instant = Instant.ofEpochMilli(epochMilli);
        LocalDate date = instant.atZone(zone).toLocalDate();
        // End of day: 23:59:59.999
        ZonedDateTime endOfDay = date.atTime(LocalTime.MAX).atZone(zone);
        return endOfDay.toInstant().toEpochMilli();
    }
}
