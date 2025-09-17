package com.qlsc.qlsc_common.saga;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookingCommand extends BaseSagaCommand {
    Long userId;
    String userName;
    Long courtId;
    Integer courtNumber;
    Long bookingDate;
    Integer startTime;
    Integer endTime;
    Integer status;
    Double price;
}
