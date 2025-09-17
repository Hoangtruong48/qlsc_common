package com.qlsc.qlsc_common.user;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    Long userId;

    String username;

    String passwordHash;

    String email;

    String fullName;

    String phone;

    Integer role;

    Integer status;
}
