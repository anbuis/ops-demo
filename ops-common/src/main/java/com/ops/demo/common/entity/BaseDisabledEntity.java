package com.ops.demo.common.entity;

/**
 * @author a1517
 * @since 2024-01-07 21:25:59
 */
public interface BaseDisabledEntity {

    Integer getDisabledAt();

    void setDisabledName(String name);

    void setDisabledBy(Integer byId);

    void setDisabledAt(Integer disabledAt);

}
