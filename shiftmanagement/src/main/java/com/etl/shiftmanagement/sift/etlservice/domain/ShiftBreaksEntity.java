package com.etl.shiftmanagement.sift.etlservice.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.etl.shiftmanagement.sift.etlservice.config.AuditEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shift_breaks")
public class ShiftBreaksEntity extends AuditEntity {

	@Id
	@Column
	private Integer id;

	@Column
	private Integer shift_id;

	@Column
	private Integer timesheet_id;

	@Column
	private LocalDate date;

	@Column
	private LocalDateTime start;

	@Column
	private LocalDateTime finish;

	@Column
	private Long length;

	@Column
	private Boolean paid;
}
