package com.qlsc.qlsc_common.constant;

public class SagaConstant {
    public static int FAILED = -1;
    public static int SUCCEEDED = 999;
    public static int STARTED = 0;

    // các class con định nghĩa các service đi qua
    public static class BookingSaga {
        // name
        public static String BOOKING_NAME = "booking";
        // id saga
        public static int BOOKING_SAGA = 1;

        // cac service di qua
        public static int BOOKING = 1;
        public static int PAYMENT = 2;
        public static int NOTIFICATION = 3;
    }
}
