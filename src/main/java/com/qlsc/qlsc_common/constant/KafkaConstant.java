package com.qlsc.qlsc_common.constant;

public class KafkaConstant {
    public static final String TOPIC_SAGA_EVENT = "saga_event";
    public static final String TOPIC_BOOKING_EVENT = "booking_event";
    public static final String TOPIC_PAYMENT_EVENT = "payment_event";
    public static final String TOPIC_NOTIFICATION_EVENT = "notification_event";

    public static final String TOPIC_BOOKING_COMMAND = "booking_command";
    public static final String TOPIC_PAYMENT_COMMAND = "payment_command";
    public static final String TOPIC_NOTIFICATION_COMMAND = "notification_command";

    public static final String GROUP_BOOKING = "booking_group";
    public static final String GROUP_PAYMENT = "payment_group";
    public static final String GROUP_NOTIFICATION = "notification_group";
}
