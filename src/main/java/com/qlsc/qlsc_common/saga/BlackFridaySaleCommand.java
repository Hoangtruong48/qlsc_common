package com.qlsc.qlsc_common.saga;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class BlackFridaySaleCommand {
    String msg;
    Long userId;
}
