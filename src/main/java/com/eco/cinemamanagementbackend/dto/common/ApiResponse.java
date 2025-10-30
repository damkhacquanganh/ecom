package com.eco.cinemamanagementbackend.dto.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)// không trả về null
public class ApiResponse<T> {

    @Builder.Default
    int status = 1000;// mặc định khi gọi chưa thao tác truyền là 1000;

    String message;

    T result;

    LocalDateTime timestamp;

//    String errorMessage; cần khi khai báo code lỗi
// Thành công chung
    public static <T> ApiResponse<T> success(T result) {
        return ApiResponse.<T>builder()
                .status(200)
                .message("Succes")
                .timestamp(LocalDateTime.now())
                .result(result)
                .build();
    }
//200 có message
    public static <T> ApiResponse<T> success(T result, String message) {
        return ApiResponse.<T>builder()
                .result(result)
                .status(200)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
//400
    public static <T> ApiResponse<T> badRequest(String message ) {
        return ApiResponse.<T>builder()
                .status(400)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
//404
    public static <T> ApiResponse<T> notFound(String message) {
        return ApiResponse.<T>builder()
                .status(404)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
//500
    public static <T> ApiResponse<T> internalError(String message) {
        return ApiResponse.<T>builder()
                .status(500)
                .message(message)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
