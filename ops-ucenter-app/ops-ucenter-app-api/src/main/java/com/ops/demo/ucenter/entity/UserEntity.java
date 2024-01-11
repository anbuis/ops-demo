package com.ops.demo.ucenter.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Table;
import com.ops.demo.common.entity.BaseDisabledEntity;
import com.ops.demo.common.entity.BaseOperateEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author a1517
 * @since 2024-01-07 21:14:41
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(value = "user", schema = "ucenter")
public class UserEntity extends BaseOperateEntity<Long> implements BaseDisabledEntity, Serializable {

    @Column("name")
    private String name;

    @Column("avatar_url")
    private String avatarUrl;

    @Column("gender")
    private Integer gender;

    @Column("phone")
    private String phone;

    @Column("email")
    private String email;

    @Column("status")
    private Integer status;

    @Column("disabled_by")
    private Integer disabledBy;

    @Column("disabled_name")
    private String disabledName;

    @Column("disabled_at")
    private Integer disabledAt;

}
