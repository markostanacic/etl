package com.etl.shiftmanagement.sift.etlservice.config;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class })
public abstract class AuditEntity {

	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime loadedAt;

	@LastModifiedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime updatedAt;

}
