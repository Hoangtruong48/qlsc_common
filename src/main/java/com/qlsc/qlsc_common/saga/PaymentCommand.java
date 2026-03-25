package com.qlsc.qlsc_common.saga;

import lombok.*;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentCommand extends BaseSagaCommand {
    String bookingId;
}
