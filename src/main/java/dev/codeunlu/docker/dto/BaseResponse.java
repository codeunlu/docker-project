package dev.codeunlu.docker.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BaseResponse<T>(
        @JsonProperty("success")
        boolean isSuccess,
        @JsonProperty("payload")
        T payload,
        @JsonProperty("message")
        String message
        ) {
        public static <T> BaseResponse<T> success(T payload, String message){
                return new BaseResponse<T>(true, payload, message);
        }

        public static <T> BaseResponse<T> fail(T payload, String message){
                return new BaseResponse<>(false, payload, message);
        }
}
