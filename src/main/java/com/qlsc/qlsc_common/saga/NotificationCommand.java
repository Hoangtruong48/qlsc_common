package com.qlsc.qlsc_common.saga;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationCommand extends BaseSagaCommand {
    String message;
    Integer status;
    String bookingId;
    String paymentId;

}
