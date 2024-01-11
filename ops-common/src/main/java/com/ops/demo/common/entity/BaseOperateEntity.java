package com.ops.demo.common.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author a1517
 * @since 2024-01-07 21:21:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseOperateEntity<ID extends Serializable> extends BaseEntity<ID> implements Serializable {

    @Column("created_by")
    private Integer createdBy;

    @Column("created_name")
    private String createdName;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_by")
    private Integer updatedBy;

    @Column("updated_name")
    private String updatedName;

    @Column("updated_at")
    private LocalDateTime updatedAt;

}
