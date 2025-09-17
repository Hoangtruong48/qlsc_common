package com.qlsc.qlsc_common.saga;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class BookingCreatedEvent extends BaseSagaEvent {
    Long courtId;
    Integer courtNumber;
    Integer startTime;
    Integer endTime;
    Long bookingDate;
    Integer status;
    Double price;
    String msg;
}
