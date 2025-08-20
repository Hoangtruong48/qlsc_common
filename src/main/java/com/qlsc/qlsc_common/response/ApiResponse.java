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

    public ApiResponse<T> setSuccess() {
        this.statusCode = 0;
        message = "success";
        return this;
    }

    public ApiResponse<T> setError() {
        this.statusCode = -1;
        message = "Action failed";
        return this;
    }

    public ApiResponse<T> setMessageFailed(String message) {
        this.statusCode = -1;
        this.message = message;
        return this;
    }

    public ApiResponse<T> setMessageSuccess(String message) {
        this.statusCode = 0;
        this.message = message;
        return this;
    }

    public ApiResponse<T> setDataSuccess(T data, Long total) {
        this.data = data;
        this.statusCode = 0;
        message = "success";
        this.total = total;
        return this;
    }

    public ApiResponse<T> setDataSuccess(T data) {
        this.data = data;
        this.statusCode = 0;
        message = "success";
        return this;
    }




}
