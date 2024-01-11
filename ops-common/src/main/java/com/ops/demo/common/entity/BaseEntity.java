package com.ops.demo.common.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author a1517
 * @since 2024-01-07 21:16:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseEntity<ID extends Serializable> extends AbstractPersistableEntity<ID> implements Serializable {

    @Column("id")
    @Id(keyType = KeyType.Auto)
    private ID id;

}
