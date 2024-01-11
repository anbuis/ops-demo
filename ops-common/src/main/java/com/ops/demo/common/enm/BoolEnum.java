package com.ops.demo.common.enm;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author a1517
 * @since 2023-12-31 16:06:08
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum BoolEnum implements BaseNativeEnum{

    Y(0, "是"),
    N(1, "否")
    ;

    private final Integer value;

    private final String desc;

}
