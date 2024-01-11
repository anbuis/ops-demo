package com.ops.demo.common.entity;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

/**
 * @author a1517
 * @since 2024-01-07 21:40:33
 */
@Data
public abstract class AbstractPersistableEntity<ID extends Serializable> implements Persistable<ID> {

    @Override
    public boolean isNew() {
        Serializable id = getId();
        return id == null || StrUtil.isBlank(String.valueOf(id));
    }

    public boolean isNotNew() {
        return !isNew();
    }
}
