package com.qlsc.qlsc_common.response;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ApiResponse<T> {
    int statusCode;
    String message;
    T data;
    Long total;

    public void setSuccess() {
        this.statusCode = 0;
        message = "success";
    }

    public void setError() {
        this.statusCode = -1;
        message = "Action failed";
    }

    public void setMessageFailed(String message) {
        this.statusCode = -1;
        this.message = message;
    }

    public void setMessageSuccess(String message) {
        this.statusCode = 0;
        this.message = message;
    }

    public void setDataSuccess(T data, Long total) {
        this.data = data;
        this.statusCode = 0;
        message = "success";
    }


}
