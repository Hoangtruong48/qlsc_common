package com.qlsc.qlsc_common.saga;

public class NotificationEvent extends BaseSagaEvent {
    Long bookingId;
    Long paymentId;
    Long notificationId;
}
