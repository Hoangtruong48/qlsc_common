package com.qlsc.qlsc_common.saga;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEvent extends BaseSagaEvent {
    Long bookingId;
    Long paymentId;
    Long notificationId;
}
