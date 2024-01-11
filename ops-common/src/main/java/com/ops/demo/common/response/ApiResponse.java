package com.ops.demo.common.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author a1517
 * @since 2023-12-31 11:56:48
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "统一返回结果", description = "统一返回结果")
public class ApiResponse<T> implements Serializable {

    @Schema(description = "返回代码")
    private Integer code;

    @Schema(description = "返回信息")
    private String message;

    @Schema(description = "返回数据")
    private T data;

    @Schema(description = "是否成功 0 是成功，其他的都是失败")
    public boolean isSuccess() {
        return code == 0;
    }

    public static <T> ApiResponse<T> build(Integer code, String message, T data) {
        return ApiResponse.<T>builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> build(ApiResponseCode responseCode, T data) {
        return build(responseCode.getCode(), responseCode.getMessage(), data);
    }

    public static <T> ApiResponse<T> ok(T data) {
        return build(BaseApiResponseCode.OPS_SUCCESS, data);
    }

    public static <T> ApiResponse<T> ok() {
        BaseApiResponseCode opsSuccess = BaseApiResponseCode.OPS_SUCCESS;
        return ApiResponse.<T>builder()
                .code(opsSuccess.getCode())
                .message(opsSuccess.getMessage())
                .build();
    }

    public static <T> ApiResponse<T> error(Integer code, String message) {
        return ApiResponse.<T>builder()
                .code(code)
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> error(ApiResponseCode responseCode) {
        return error(responseCode.getCode(), responseCode.getMessage());
    }

}
