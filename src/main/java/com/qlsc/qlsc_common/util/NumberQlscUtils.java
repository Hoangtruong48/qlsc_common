package com.qlsc.qlsc_common.util;

import java.math.BigDecimal;

public class NumberQlscUtils {
    /**
     * Làm tròn số thực đến bội số gần nhất của base.
     * @param number Số thực đầu vào (VD: 81234.7)
     * @param base Bội số cần làm tròn tới (VD: 5000)
     * @return Số đã làm tròn (VD: 80000.0 hoặc 85000.0)
     */
    public static double roundToNearestBase(double number, double base) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base must be greater than 0");
        }

        double remainder = number % base;
        if (remainder < base / 2) {
            return number - remainder; // Làm tròn xuống
        } else {
            return number + (base - remainder); // Làm tròn lên
        }
    }

    public static double roundDownToBase(double number, double base) {
        if (base <= 0) throw new IllegalArgumentException("Base must be > 0");
        return Math.floor(number / base) * base;
    }

    public static double roundUpToBase(double number, double base) {
        if (base <= 0) throw new IllegalArgumentException("Base must be > 0");
        return Math.ceil(number / base) * base;
    }

    public static int compareDouble(double a, double b, double epsilon) {
        if (Math.abs(a - b) <= epsilon) {
            return 0; // Hai số gần bằng nhau
        } else if (a > b) {
            return 1; // a lớn hơn b
        } else {
            return -1; // a nhỏ hơn b
        }
    }

    public static int compareDouble(double a, double b) {
        return compareDouble(a, b, 1e-10);
    }

    public static Integer parseInteger(Object value) {
        if (value == null) return -1;
        try {
            if (value instanceof Number) {
                return ((Number) value).intValue();
            }
            return Integer.parseInt(value.toString().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    // ======================== Long ========================
    public static Long parseLong(Object value) {
        if (value == null) return -1L;
        try {
            if (value instanceof Number) {
                return ((Number) value).longValue();
            }
            return Long.parseLong(value.toString().trim());
        } catch (Exception e) {
            return -1L;
        }
    }

    // ======================== Double ========================
    public static Double parseDouble(Object value) {
        if (value == null) return -1.0;
        try {
            if (value instanceof Number) {
                return ((Number) value).doubleValue();
            }
            return Double.parseDouble(value.toString().trim());
        } catch (Exception e) {
            return -1.0;
        }
    }

    // ======================== Float ========================
    public static Float parseFloat(Object value) {
        if (value == null) return -1.0f;
        try {
            if (value instanceof Number) {
                return ((Number) value).floatValue();
            }
            return Float.parseFloat(value.toString().trim());
        } catch (Exception e) {
            return -1.0f;
        }
    }

    // ======================== BigDecimal ========================
    public static BigDecimal parseBigDecimal(Object value) {
        if (value == null) return BigDecimal.valueOf(-1);
        try {
            if (value instanceof BigDecimal) {
                return (BigDecimal) value;
            }
            if (value instanceof Number) {
                return BigDecimal.valueOf(((Number) value).doubleValue());
            }
            return new BigDecimal(value.toString().trim());
        } catch (Exception e) {
            return BigDecimal.valueOf(-1);
        }
    }
}
