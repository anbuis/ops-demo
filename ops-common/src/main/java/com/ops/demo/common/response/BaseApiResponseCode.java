package com.ops.demo.common.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author a1517
 * @since 2023-12-31 12:11:45
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BaseApiResponseCode implements ApiResponseCode {

    OPS_SUCCESS(0, "操作成功"),
    OPS_INTERNAL_ERROR(500, "系统内部异常，请联系管理员"),
    OPS_REQUEST_ERROR(400, "请求异常，请检测请求信息"),
    ;

    private final Integer code;

    private final String message;

}
