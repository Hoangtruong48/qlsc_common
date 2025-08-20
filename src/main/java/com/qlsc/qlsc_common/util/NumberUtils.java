package com.qlsc.qlsc_common.util;

public class NumberUtils {
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
}
