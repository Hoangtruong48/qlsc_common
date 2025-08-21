package com.qlsc.qlsc_common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    @CreatedDate
    @Column(name = BaseEntityConstant.CREATED_AT, updatable = false)
    private Long createdAt;

    @LastModifiedDate
    @Column(name = BaseEntityConstant.UPDATED_AT)
    private Long updatedAt;

    @Column(name = BaseEntityConstant.CREATED_BY, updatable = false)
    private String createdBy;

    @Column(name = BaseEntityConstant.UPDATED_BY)
    private String updatedBy;

    public static class BaseEntityConstant {
        public static final String CREATED_BY = "created_by";
        public static final String UPDATED_BY = "updated_by";
        public static final String CREATED_AT = "create_at";
        public static final String UPDATED_AT = "updated_at";
    }
}

